package receiver;

import receiver.resultdata.ResultNewsInfo;
import receiver.models.NewsInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 06.02.14.
 */
public class ReceiveNewsInfo extends Receive {
    public static ResultNewsInfo getConditions() throws IOException {
        ResultNewsInfo result = new ResultNewsInfo();
        URL xmlUrl = new URL(NEWS_XML_URL);
        InputStream in = xmlUrl.openStream();
        Document doc = parse(in);
        try {
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("item");
            result.hasError = nodeList.getLength() == 0;
            List<NewsInfo> list = new ArrayList<NewsInfo>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element elementItem = (Element) nodeList.item(i);
                Element elementTitle = (Element) elementItem.getElementsByTagName("title").item(0);
                Element elementDescription = (Element) elementItem.getElementsByTagName("description").item(0);
                String title = getTextFromTitleElement(elementTitle);
                String image = getImageUrlFromElement(elementDescription);
                String description = getTextFromDescriptionElement(elementDescription);
                list.add(new NewsInfo(title, description, image));
            }
            result.data = list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String getTextFromDescriptionElement(Element element) {
        String text = element.getTextContent();
        return text.substring(text.indexOf("/>") + 2).trim();
    }

    private static String getTextFromTitleElement(Element element) {
        String text = element.getTextContent();
        int end = text.indexOf("(видео)");
        return (end != -1) ? text.substring(0, end).trim() : text.trim();
    }


}
