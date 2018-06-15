package sensors.luminositySensor.handler;
import sensors.HttpRequest;

public class PerfomRequest {
    public PerfomRequest() {}
    public double getLuminosity() {
        double LuminosityValue = 0;
        HttpRequest request = new HttpRequest();
        try {
            LuminosityValue = request.requestSensors().getDouble("luminosity");
        }catch (Exception e) {
            System.out.println(e);
        }
        return LuminosityValue;
    }
}