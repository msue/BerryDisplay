package receiver;

import receiver.resultdata.ResultCurrency;
import receiver.models.Currency;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 06.02.14.
 */
public class ReceiveCurrency extends Receive {
    public static ResultCurrency getConditions() throws IOException {
        ResultCurrency result = new ResultCurrency();
        URL xmlUrl = new URL(CURRENCY_XML_URL);
        InputStream in = xmlUrl.openStream();
        Document doc = parse(in);
        try {

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Valute");
            result.hasError = nList.getLength() == 0;
            List<Currency> list = new ArrayList<Currency>();
            for (int i = 0; i < nList.getLength(); i++) {
                Element element = (Element) nList.item(i);
                String code = element.getElementsByTagName("CharCode").item(0).getTextContent();
                double value = Double.parseDouble(element.getElementsByTagName("Value").item(0).getTextContent());
                int nominal = Integer.parseInt(element.getElementsByTagName("Nominal").item(0).getTextContent());
                DecimalFormat decim = new DecimalFormat("0.00");
                String ammount = decim.format(value / nominal);
                list.add(new Currency(code, ammount));
            }
            result.data = list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


}
