package Sensors.weatherSensor;

public interface WeatherSensorInterface {
    String getWeatherCurrentValue();
    String getForecastCurrentValue();
    String getWeatherValue();
    String getForecastValue();
    void setWeatherValue(String newValue);
    void setForecastValue(String newValue);
    int getWeatherId();
    void setWeatherId(int newValue);
    int getForecastId();
    void setForecastId(int newValue);
}
