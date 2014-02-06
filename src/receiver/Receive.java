package receiver;

import receiver.resultdata.ResultData;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 1 on 05.02.14.
 */
public abstract class Receive {
    final static String CURRENCY_XML_URL = "http://pfsoft.com.ua/service/currency/";
    final static String WEATHER_XML_URL = "http://weather.yahooapis.com/forecastrss?w=918247&u=c";
    final static String NEWS_XML_URL = "http://podrobnosti.ua/rss/news/ukraine.rss";
    final static String INOUT_JSON_URL = "http://inout.osdn.nl/index/ajax/format/json";

    static ResultData getConditions() throws IOException, ParseException, java.text.ParseException {
        return null;
    }

    protected static Document parse(InputStream is) {
        Document doc = null;
        DocumentBuilderFactory domFactory;
        DocumentBuilder builder;

        try {
            domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setValidating(false);
            domFactory.setNamespaceAware(false);
            builder = domFactory.newDocumentBuilder();

            doc = builder.parse(is);
        } catch (Exception ex) {
            System.err.println("unable to load XML: " + ex);
        }
        return doc;
    }

    protected static String getImageUrlFromElement(Element element) {
        String text = element.getTextContent();
        int index = text.indexOf("\"", 15);
        return text.substring(text.indexOf("http://"), text.indexOf("\"", 15));
    }
}

