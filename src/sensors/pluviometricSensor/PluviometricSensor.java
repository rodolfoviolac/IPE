package sensors.pluviometricSensor;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sensors.pluviometricSensor.handler.RequestHandler;
import sensors.pluviometricSensor.handler.ValuesHandler;

@Scope(value = "singleton")
@Component
public class PluviometricSensor {
    RequestHandler request = new RequestHandler();
    ValuesHandler handler = new ValuesHandler();
    private double pluviometricValue;

    private PluviometricSensor(){
        getCurrentValue();
    }

    public double getCurrentValue() {
        pluviometricValue = request.getCurrentValue();
        return pluviometricValue;
    }

    public double getPluviometricValue() {
        return pluviometricValue;
    }

    public void setPluviometricValue(double newValue) {
        if(handler.pluviometricSetHandler(newValue)) pluviometricValue = newValue;
    }
}
