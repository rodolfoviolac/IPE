package Sensors.weatherSensor;

import Sensors.weatherSensor.handler.RequestHandler;
import Sensors.weatherSensor.handler.ValuesHandler;

public class WeatherSensor implements WeatherSensorInterface {
    RequestHandler request = new RequestHandler();
    ValuesHandler handler = new ValuesHandler();
    private String weatherValue;
    private int weatherId;
    private String forecastValue;
    private int forecastId;

    private WeatherSensor(){
        updateSensors();
    }

    private void updateSensors(){
        getWeatherCurrentValue();
        getForecastCurrentValue();
    }

    public String getWeatherCurrentValue() {
        weatherValue = request.getWeatherCurrentValue();
        return weatherValue;
    }

    public String getForecastCurrentValue() {
        forecastValue = request.getForecastCurrentValue();
        return forecastValue;
    }

    public String getWeatherValue() {
        return weatherValue;
    }
    public String getForecastValue() {
        return forecastValue;
    }

    public void setWeatherValue(String newValue) {
        int weatherId = handler.weatherSetHandler(newValue);
        if(weatherId>1){
          this.setWeatherId(weatherId);
          weatherValue = newValue;
        }
    }

    public void setForecastValue(String newValue) {
        int forecastId = handler.forecastSetHandler(newValue);
        if(forecastId>1){
            this.setForecastId(forecastId);
            forecastValue = newValue;
        }
    }

    public int getWeatherId() {
        weatherId = request.getWeatherIdValue();
        return weatherId;
    }

    public int getForecastId() {
        forecastId = request.getForecastIdValue();
        return forecastId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public void setForecastId(int weatherId) {
        this.forecastId = forecastId;
    }
}
