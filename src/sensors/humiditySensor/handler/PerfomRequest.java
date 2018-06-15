package sensors.humiditySensor.handler;
import sensors.HttpRequest;

public class PerfomRequest {
    public PerfomRequest() {}
    public double getHumidity() {
        double humidityValue = 0;
        HttpRequest request = new HttpRequest();
        try {
            humidityValue = request.requestSensors().getDouble("humidity");
        }catch (Exception e) {
            System.out.println(e);
        }
        return humidityValue;
    }
}