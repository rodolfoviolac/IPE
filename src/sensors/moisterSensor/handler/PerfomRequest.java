package sensors.moisterSensor.handler;
import sensors.HttpRequest;

public class PerfomRequest {
    public PerfomRequest() {}
    public double getSoilMoisture() {
        double soilMoistureValue = 0;
        HttpRequest request = new HttpRequest();
        try {
            soilMoistureValue = request.requestSensors().getDouble("soilMoisture");
        }catch (Exception e) {
            System.out.println(e);
        }
        return soilMoistureValue;
    }
}