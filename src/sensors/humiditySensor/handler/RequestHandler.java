package sensors.humiditySensor.handler;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Scope(value = "singleton")
@Component
public class RequestHandler {
    private static final long TTL = 3000; // 10s
    private double humidityValue;
    private Date lastRead;
    private PerfomRequest request;

    public RequestHandler() {
        this.request = new PerfomRequest();
        updateHumidity();
    }

    private void updateHumidity() {
        this.humidityValue = request.getHumidity();
        this.lastRead = new Date();
    }

    private boolean isTimeExpired() {
        Date now = new Date();
        return ((now.getTime() - lastRead.getTime()) > TTL);
    }

    public double getCurrentValue() {
        if (isTimeExpired()) {
            updateHumidity();
        }
        return humidityValue;
    }
}
