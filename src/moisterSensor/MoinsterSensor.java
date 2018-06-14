package moisterSensor;

import moisterSensor.handler.RequestHandler;
import moisterSensor.handler.SetHandler;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "singleton")
@Component
public class MoinsterSensor implements MoisterSensor {
    RequestHandler request = new RequestHandler();
    SetHandler handler = new SetHandler();
    private double moisterValue;

    public MoinsterSensor(){
        getCurrentValue();
    }

    public double getCurrentValue() {
        moisterValue = request.getCurrentValue();
        return moisterValue;
    }

    public double getMoisterValue() {
        return moisterValue;
    }

    public void setMoisterValue(double newValue) {
        if(handler.moisterSetHandler(newValue)) moisterValue = newValue;
    }
}
