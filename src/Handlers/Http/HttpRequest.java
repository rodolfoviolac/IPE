package Handlers.Http;
import Handlers.Http.handler.Predict;
import Handlers.Http.handler.Sensors;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Scope(value = "singleton")
@Component
public class HttpRequest implements HttpRequestInterface {
    public static final long TTL = 30000; // 30s
    private Date lastSensorsRead;
    private JSONObject sensorResponse;

    public HttpRequest() {
        Sensors sensorsData = new Sensors();
        sensorResponse = sensorsData.performRequest();
        this.lastSensorsRead = new Date();
    }

    public int requestPredict(){
        Predict result = new Predict();
        return result.getPlantingPredict();
    }

    public JSONObject requestSensors() {
        if (isTimeExpired()) {
            Sensors sensorsData = new Sensors();
            sensorResponse = sensorsData.performRequest();
            this.lastSensorsRead = new Date();
        }
        return sensorResponse;
    }

    private boolean isTimeExpired() {
        Date now = new Date();
        return ((now.getTime() - lastSensorsRead.getTime()) > TTL);
    }
}