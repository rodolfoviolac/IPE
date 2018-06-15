package sensors.humiditySensor.handler;

public class ValuesHandler {
    public boolean humiditySetHandler(double newValue){
        boolean shouldReturn = false;
        if (newValue >= 0 && newValue <= 100) shouldReturn = true;
        return shouldReturn;
    }
}
