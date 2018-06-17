package Sensors.pluviometricSensor.handler;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Scope(value = "singleton")
@Component
public class RequestHandler {
    public static final long TTL = 10000; // 10s

    private double pluviometricValue;
    private Date lastRead;
    public PerformRequest request;

    public RequestHandler() {
        this.request = new PerformRequest();
        updatePluviometric();
    }

    private void updatePluviometric() {
        this.pluviometricValue = request.getPluviometric();
        this.lastRead = new Date();
    }

    private boolean isTimeExpired() {
        Date now = new Date();
        return ((now.getTime() - lastRead.getTime()) > TTL);
    }

    public double getCurrentValue() {
        if (isTimeExpired()) {
            updatePluviometric();
        }
        return pluviometricValue;
    }
}
