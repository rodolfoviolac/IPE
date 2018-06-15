package sensors.pluviometricSensor.handler;

public class ValuesHandler {
    public boolean pluviometricSetHandler(double newValue){
        boolean shouldReturn = false;
        if (newValue >= 0 && newValue <= 300) shouldReturn = true;
        return shouldReturn;
    }
}
