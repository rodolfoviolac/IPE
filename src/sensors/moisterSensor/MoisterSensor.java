package sensors.moisterSensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import sensors.moisterSensor.handler.RequestHandler;
import sensors.moisterSensor.handler.ValuesHandler;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "singleton")
@Component
public class MoisterSensor implements MoisterSensorInterface {
    RequestHandler request = new RequestHandler();
    ValuesHandler handler = new ValuesHandler();
    @Value("0")
    private double moisterValue;

    private MoisterSensor(){
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
