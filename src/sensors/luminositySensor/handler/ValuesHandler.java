package sensors.luminositySensor.handler;

public class ValuesHandler {
    public boolean luminositySetHandler(double newValue){
        boolean shouldReturn = false;
        if (newValue >= 0 && newValue <= 24) shouldReturn = true;
        return shouldReturn;
    }
}
