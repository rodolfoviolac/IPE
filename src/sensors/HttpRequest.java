package sensors;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {
    public HttpRequest() {}
    public JSONObject requestSensors() {
        JSONObject sensorResponse = new JSONObject();
        try {
            String API_URL = "https://plantingdecision.herokuapp.com/sensors";
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
            System.out.println(result);
            sensorResponse = new JSONObject(result);
            in.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
        return sensorResponse;
    }
}