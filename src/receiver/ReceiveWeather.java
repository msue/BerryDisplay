package receiver;

import receiver.resultdata.ResultWeather;
import receiver.models.Weather;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by 1 on 06.02.14.
 */
public class ReceiveWeather extends Receive {
    public static ResultWeather getConditions() throws IOException {
        ResultWeather result = new ResultWeather();
        URL xmlUrl = new URL(WEATHER_XML_URL);
        InputStream in = xmlUrl.openStream();
        Document doc = parse(in);

        try {
            doc.getDocumentElement().normalize();
            //extracting humidity
            NodeList nodeList = doc.getElementsByTagName("yweather:atmosphere");
            Node node = nodeList.item(0);
            Element element = (Element) node;
            int humidity = Integer.parseInt(element.getAttribute("humidity"));
            NodeList nList = doc.getElementsByTagName("item");
            Node nNode = nList.item(0);
            Element eElement = (Element) nNode;
            //extracting temperature and forecast text
            nodeList = eElement.getElementsByTagName("yweather:condition");
            node = nodeList.item(0);
            element = (Element) node;
            int temperature = Integer.parseInt(element.getAttribute("temp"));
            String forecast = element.getAttribute("text");
            //extracting url of forecast image
            nodeList = eElement.getElementsByTagName("description");
            node = nodeList.item(0);
            element = (Element) node;
            String image = getImageUrlFromElement(element);
            result.data = new Weather(temperature, humidity, forecast, image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
