package sensors.luminositySensor;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sensors.luminositySensor.handler.RequestHandler;
import sensors.luminositySensor.handler.ValuesHandler;

@Scope(value = "singleton")
@Component
public class LuminositySensor implements LuminositySensorInterface {
    RequestHandler request = new RequestHandler();
    ValuesHandler handler = new ValuesHandler();
    private double luminosityValue;

    private LuminositySensor(){
        getCurrentValue();
    }

    public double getCurrentValue() {
        luminosityValue = request.getCurrentValue();
        return luminosityValue;
    }

    public double getLuminosityValue() {
        return luminosityValue;
    }

    public void setLuminosityValue(double newValue) {
        if(handler.luminositySetHandler(newValue)) luminosityValue = newValue;
    }
}
