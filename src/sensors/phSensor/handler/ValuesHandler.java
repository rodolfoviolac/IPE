package sensors.phSensor.handler;

public class ValuesHandler {
    public boolean phSetHandler(double newValue){
        boolean shouldReturn = false;
        if (newValue >= 0 && newValue <= 14) shouldReturn = true;
        return shouldReturn;
    }
}
