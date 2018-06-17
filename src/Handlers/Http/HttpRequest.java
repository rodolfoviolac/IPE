package Handlers.Http;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

@Scope(value = "singleton")
@Component
public class HttpRequest {
    public static final long TTL = 30000; // 30s
    private Date lastRead;
    JSONObject sensorResponse;

    public HttpRequest() {
        performRequest();
    }


    public JSONObject requestSensors() {
        if (isTimeExpired()) {
           performRequest();
        }
        return sensorResponse;
    }

    private void performRequest(){
        try {
            String API_URL = "http://plantingdecision.herokuapp.com/Sensors";
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
            this.lastRead = new Date();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private boolean isTimeExpired() {
        Date now = new Date();
        return ((now.getTime() - lastRead.getTime()) > TTL);
    }
}