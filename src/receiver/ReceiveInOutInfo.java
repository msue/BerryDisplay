package receiver;

import receiver.resultdata.ResultInOutInfo;
import receiver.models.InOutInfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 06.02.14.
 */
public class ReceiveInOutInfo extends Receive {
    public static ResultInOutInfo getConditions() throws IOException, ParseException, org.json.simple.parser.ParseException {
        ResultInOutInfo result = new ResultInOutInfo();
        List<InOutInfo> list = new ArrayList<InOutInfo>();
        URL html = new URL(INOUT_JSON_URL);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(html.openStream()));
        String inputLine = in.readLine();
        JSONObject json = (JSONObject) new JSONParser().parse(inputLine);
        JSONArray content = (JSONArray) new JSONParser().parse(json.get("content").toString());
        JSONArray statuses = (JSONArray) new JSONParser().parse(json.get("statuses").toString());
        int i = 0;
        result.hasError = content.size() == 0;
        while (content.size() > i) {
            JSONObject jo = (JSONObject) new JSONParser().parse(content.get(i).toString());
            String safescanId = jo.get("safescanId").toString();
            String firstName = jo.get("firstName").toString();
            String lastName = jo.get("lastName").toString();
            String status = "OUT";
            String start = "????-??-?? ??:??:??";
            String end = "????-??-?? ??:??:??";
            int j = 0;
            boolean isAbsent = true;
            while (statuses.size() > j) {
                jo = (JSONObject) new JSONParser().parse(statuses.get(j).toString());
                if (safescanId.equals(jo.get("safescanId"))) {
                    status = jo.get("status").toString();
                    start = jo.get("start").toString();
                    end = jo.get("end").toString();
                }
                j++;
            }
            list.add(new InOutInfo(safescanId, firstName, lastName, status, start, end));
            i++;
        }
        result.data = list;
        in.close();
        return result;
    }


}
