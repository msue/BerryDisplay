import receiver.models.Currency;
import receiver.models.InOutInfo;
import receiver.models.NewsInfo;
import receiver.ReceiveCurrency;
import receiver.ReceiveInOutInfo;
import receiver.ReceiveNewsInfo;
import receiver.ReceiveWeather;
import receiver.resultdata.ResultCurrency;
import receiver.resultdata.ResultInOutInfo;
import receiver.resultdata.ResultNewsInfo;
import receiver.resultdata.ResultWeather;
import org.json.simple.parser.ParseException;

import javax.xml.transform.TransformerException;
import java.io.IOException;import java.lang.String;import java.lang.System;


public class Process {


    public static void main(String[] args) throws IOException, TransformerException, ParseException, java.text.ParseException {

        ReceiveCurrency receiveCurrency = new ReceiveCurrency();
        ResultCurrency resultCurrency = receiveCurrency.getConditions();
        while (resultCurrency.hasError) {
            resultCurrency = receiveCurrency.getConditions();
        }
        for (Currency element : resultCurrency.data)
            System.out.println(element.toString());
        ReceiveWeather receiveWeather = new ReceiveWeather();
        ResultWeather resultWeather = receiveWeather.getConditions();
        while (resultWeather.hasError) {
            resultWeather = receiveWeather.getConditions();
        }
        System.out.println(resultWeather.data);
        ReceiveNewsInfo receiveNewsInfo = new ReceiveNewsInfo();
        ResultNewsInfo resultNewsInfo = receiveNewsInfo.getConditions();
        if (resultNewsInfo.hasError) {
            resultNewsInfo = receiveNewsInfo.getConditions();
        } else for (NewsInfo element : resultNewsInfo.data)
            System.out.println(element.toString());
        ReceiveInOutInfo receiveInOutInfo = new ReceiveInOutInfo();
        ResultInOutInfo resultInOutInfo = receiveInOutInfo.getConditions();
        if (resultInOutInfo.hasError) {
            resultInOutInfo = ReceiveInOutInfo.getConditions();
        } else for (InOutInfo element : resultInOutInfo.data)
            System.out.println(element.toString());
    }
}