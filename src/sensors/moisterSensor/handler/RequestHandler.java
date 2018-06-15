package sensors.moisterSensor.handler;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.Date;

@Scope(value = "singleton")
@Component
public class RequestHandler {
    private static final long TTL = 3000; // 10s
    private double moisterValue;
    private Date lastRead;
    private PerfomRequest request;

    public RequestHandler() {
        this.request = new PerfomRequest();
        updateMoister();
    }

    private void updateMoister() {
        this.moisterValue = request.getSoilMoisture();
        this.lastRead = new Date();
    }

    private boolean isTimeExpired() {
        Date now = new Date();
        return ((now.getTime() - lastRead.getTime()) > TTL);
    }

    public double getCurrentValue() {
        if (isTimeExpired()) {
            updateMoister();
        }
        return moisterValue;
    }
}
