package sensors.temperatureSensor.handler;

import sensors.HttpRequest;

public class PerformRequest {
    public PerformRequest() {}
    public double getTemperature() {
        double soilTemperatureValue = 0;
        HttpRequest request = new HttpRequest();
        try {
            soilTemperatureValue = request.requestSensors().getDouble("temperature");
        }catch (Exception e) {
            System.out.println(e);
        }
        return soilTemperatureValue;
    }
}