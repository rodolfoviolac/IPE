package sensors.phSensor.handler;

import sensors.HttpRequest;

public class PerformRequest {
    public PerformRequest() {}
    public double getPh() {
        double phValue = 0;
        HttpRequest request = new HttpRequest();
        try {
            phValue = request.requestSensors().getDouble("ph");
        }catch (Exception e) {
            System.out.println(e);
        }
        return phValue;
    }
}