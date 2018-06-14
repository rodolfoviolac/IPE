package moisterSensor.handler;

public class SetHandler {
    public boolean moisterSetHandler(double newValue){
        boolean shouldReturn = false;
        if (newValue >= 0 && newValue <= 100) shouldReturn = true;
        return shouldReturn;
    }
}
