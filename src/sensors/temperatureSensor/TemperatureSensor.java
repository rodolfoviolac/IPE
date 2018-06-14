package sensors.temperatureSensor;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sensors.temperatureSensor.handler.RequestHandler;
import sensors.temperatureSensor.handler.ValuesHandler;

@Scope(value = "singleton")
@Component
public class TemperatureSensor implements TemperatureSensorInterface {
    RequestHandler request = new RequestHandler();
    ValuesHandler handler = new ValuesHandler();
    private double temperatureValue;

    private TemperatureSensor(){
        getCurrentValue();
    }

    public double getCurrentValue() {
        temperatureValue = request.getCurrentValue();
        return temperatureValue;
    }

    public double getMoisterValue() {
        return temperatureValue;
    }

    public void setTemperatureValue(double newValue) {
        if(handler.temperatureSetHandler(newValue)) temperatureValue = newValue;
    }
}
