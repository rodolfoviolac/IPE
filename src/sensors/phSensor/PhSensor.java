package sensors.phSensor;

import sensors.phSensor.handler.RequestHandler;
import sensors.phSensor.handler.ValuesHandler;

public class PhSensor {
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
