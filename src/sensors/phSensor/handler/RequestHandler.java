package sensors.phSensor.handler;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Scope(value = "singleton")
@Component
public class RequestHandler {
    public static final long TTL = 10000; // 10s

    private double phValue;
    private Date lastRead;
    public PerformRequest request;

    public RequestHandler() {
        this.request = new PerformRequest();
        updatePh();
    }

    private void updatePh() {
        this.phValue = request.getPh();
        this.lastRead = new Date();
    }

    private boolean isTimeExpired() {
        Date now = new Date();
        return ((now.getTime() - lastRead.getTime()) > TTL);
    }

    public double getCurrentValue() {
        if (isTimeExpired()) {
            updatePh();
        }
        return phValue;
    }
}
