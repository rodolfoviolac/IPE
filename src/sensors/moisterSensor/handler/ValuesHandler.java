package sensors.moisterSensor.handler;

public class ValuesHandler {
    public boolean moisterSetHandler(double newValue){
        boolean shouldReturn = false;
        if (newValue >= 0 && newValue <= 100) shouldReturn = true;
        return shouldReturn;
    }
}
