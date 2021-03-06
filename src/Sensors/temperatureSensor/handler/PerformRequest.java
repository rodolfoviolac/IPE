package Sensors.temperatureSensor.handler;

import Handlers.FrameWorkUtils.ApplicationContextProvider;
import Handlers.Http.HttpRequest;

public class PerformRequest {
    HttpRequest request = ApplicationContextProvider.getApplicationContext().getBean("httpRequest", HttpRequest.class);
    public PerformRequest() {}
    public double getTemperature() {
        double soilTemperatureValue = 0;
        try {
            soilTemperatureValue = request.requestSensors().getDouble("temperature");
        }catch (Exception e) {
            System.out.println(e);
        }
        return soilTemperatureValue;
    }
}