package sensors.humiditySensor.handler;
import sensors.HttpRequest;
import utils.ApplicationContextProvider;

public class PerfomRequest {
    HttpRequest request = ApplicationContextProvider.getApplicationContext().getBean("httpRequest", HttpRequest.class);
    public PerfomRequest() {}
    public double getHumidity() {
        double humidityValue = 0;
        try {
            humidityValue = request.requestSensors().getDouble("humidity");
        }catch (Exception e) {
            System.out.println(e);
        }
        return humidityValue;
    }
}