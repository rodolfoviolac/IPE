package sensors.temperatureSensor.handler;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Scope(value = "singleton")
@Component
public class RequestHandler {
    public static final long TTL = 10000; // 10s

    private double temperatureValue;
    private Date lastRead;
    private PerformRequest request;

    public RequestHandler() {
        this.request = new PerformRequest();
        updateTemperature();
    }

    private void updateTemperature() {
        this.temperatureValue = request.getTemperature();
        this.lastRead = new Date();
    }

    private boolean isTimeExpired() {
        Date now = new Date();
        return ((now.getTime() - lastRead.getTime()) > TTL);
    }

    public double getCurrentValue() {
        if (isTimeExpired()) {
            updateTemperature();
        }
        return temperatureValue;
    }
}
