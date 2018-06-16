package sensors.humiditySensor;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sensors.humiditySensor.handler.RequestHandler;
import sensors.humiditySensor.handler.ValuesHandler;
@Scope(value = "singleton")
@Component
public class HumiditySensor implements HumiditySensorInterface {
    RequestHandler request = new RequestHandler();
    ValuesHandler handler = new ValuesHandler();
    private double humidityValue;

    private HumiditySensor(){
        getCurrentValue();
    }

    public double getCurrentValue() {
        humidityValue = request.getCurrentValue();
        return humidityValue;
    }

    public double getHumidityValue() {
        return humidityValue;
    }

    public void setHumidityValue(double newValue) {
        if(handler.humiditySetHandler(newValue)) humidityValue = newValue;
    }
}
