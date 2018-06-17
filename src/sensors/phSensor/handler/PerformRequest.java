package sensors.phSensor.handler;

import sensors.HttpRequest;
import utils.ApplicationContextProvider;

public class PerformRequest {
    HttpRequest request = ApplicationContextProvider.getApplicationContext().getBean("httpRequest", HttpRequest.class);
    public PerformRequest() {}
    public double getPh() {
        double phValue = 0;
        try {
            phValue = request.requestSensors().getDouble("ph");
        }catch (Exception e) {
            System.out.println(e);
        }
        return phValue;
    }
}