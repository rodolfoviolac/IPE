package Sensors.pluviometricSensor.handler;

import Handlers.FrameWorkUtils.ApplicationContextProvider;
import Handlers.Http.HttpRequest;


public class PerformRequest {
    HttpRequest request = ApplicationContextProvider.getApplicationContext().getBean("httpRequest", HttpRequest.class);
    public PerformRequest() {}
    public double getPluviometric() {
        double pluviometricValue = 0;
        try {
            pluviometricValue = request.requestSensors().getDouble("pluviometric");
        }catch (Exception e) {
            System.out.println(e);
        }
        return pluviometricValue;
    }
}