package Sensors.weatherSensor.handler;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Scope(value = "singleton")
@Component
public class RequestHandler {
    public static final long TTL = 10000; // 10s

    private String weatherValue;
    private int weatherIdValue;
    private String forecastValue;
    private int forecastIdValue;
    private Date lastRead;
    private PerformRequest request;

    public RequestHandler() {
        this.request = new PerformRequest();
        updateWeather();
    }

    private void updateWeather() {
        this.weatherValue = request.getWeather();
        this.weatherIdValue = request.getWeatherId();
        this.forecastValue = request.getForecast();
        this.forecastIdValue = request.getForecastId();
        this.lastRead = new Date();
    }

    private boolean isTimeExpired() {
        Date now = new Date();
        return ((now.getTime() - lastRead.getTime()) > TTL);
    }

    public String getWeatherCurrentValue() {
        if (isTimeExpired()) {
            updateWeather();
        }
        return weatherValue;
    }

    public int getWeatherIdValue() {
        return this.weatherIdValue;
    }

    public int getForecastIdValue() {
        return this.forecastIdValue;
    }

    public String getForecastCurrentValue() {
        if (isTimeExpired()) {
            updateWeather();
        }
        return forecastValue;
    }
}
