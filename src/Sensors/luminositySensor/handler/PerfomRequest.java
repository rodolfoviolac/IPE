package Sensors.luminositySensor.handler;
import Handlers.Http.HttpRequest;
import Handlers.FrameWorkUtils.ApplicationContextProvider;

public class PerfomRequest {
    HttpRequest request = ApplicationContextProvider.getApplicationContext().getBean("httpRequest", HttpRequest.class);
    public PerfomRequest() {}
    public double getLuminosity() {
        double LuminosityValue = 0;
        try {
            LuminosityValue = request.requestSensors().getDouble("luminosity");
        }catch (Exception e) {
            System.out.println(e);
        }
        return LuminosityValue;
    }
}