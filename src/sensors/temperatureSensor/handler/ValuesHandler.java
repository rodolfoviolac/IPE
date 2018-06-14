package sensors.temperatureSensor.handler;

public class ValuesHandler {
    public boolean temperatureSetHandler(double newValue){
        boolean shouldReturn = false;
        if (newValue >= 0 && newValue <= 100) shouldReturn = true;
        return shouldReturn;
    }
}
