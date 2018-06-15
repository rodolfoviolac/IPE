package sensors.pluviometricSensor.handler;

import sensors.HttpRequest;

public class PerformRequest {
    public PerformRequest() {}
    public double getPluviometric() {
        double pluviometricValue = 0;
        HttpRequest request = new HttpRequest();
        try {
            pluviometricValue = request.requestSensors().getDouble("pluviometric");
        }catch (Exception e) {
            System.out.println(e);
        }
        return pluviometricValue;
    }
}