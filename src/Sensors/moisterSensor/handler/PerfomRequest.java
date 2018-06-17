package Sensors.moisterSensor.handler;
import Handlers.FrameWorkUtils.ApplicationContextProvider;
import Handlers.Http.HttpRequest;

public class PerfomRequest {
    HttpRequest request = ApplicationContextProvider.getApplicationContext().getBean("httpRequest", HttpRequest.class);
    public PerfomRequest() {}
    public double getSoilMoisture() {
        double soilMoistureValue = 0;
        try {
            soilMoistureValue = request.requestSensors().getDouble("soilMoisture");
        }catch (Exception e) {
            System.out.println(e);
        }
        return soilMoistureValue;
    }
}