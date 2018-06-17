package Sensors.phSensor;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import Sensors.phSensor.handler.RequestHandler;
import Sensors.phSensor.handler.ValuesHandler;

@Scope(value = "singleton")
@Component
public class PhSensor implements PhSensorInterface {
    RequestHandler request = new RequestHandler();
    ValuesHandler handler = new ValuesHandler();
    private double temperatureValue;

    private PhSensor(){
        getCurrentValue();
    }

    public double getCurrentValue() {
        temperatureValue = request.getCurrentValue();
        return temperatureValue;
    }

    public double getPhValue() {
        return temperatureValue;
    }

    public void setPhValue(double newValue) {
        if(handler.phSetHandler(newValue)) temperatureValue = newValue;
    }
}
