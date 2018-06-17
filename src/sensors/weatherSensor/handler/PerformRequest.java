package sensors.weatherSensor.handler;

import org.json.JSONObject;
import sensors.HttpRequest;
import utils.ApplicationContextProvider;

public class PerformRequest {
    HttpRequest request = ApplicationContextProvider.getApplicationContext().getBean("httpRequest", HttpRequest.class);
    public PerformRequest() {}
    public String getWeather() {
        String weatherValue = "";
        try {
            weatherValue = performRequest().getString("weather");
        } catch (Exception e) {
            System.out.println(e);
        }
        return weatherValue;
    }

    public int getWeatherId(){
        int weatherId = 0;
        try {
            weatherId = performRequest().getInt("weatherId");
        } catch (Exception e) {
            System.out.println(e);
        }
        return weatherId;
    }

    public int getForecastId(){
        int forecastId = 0;
        try {
            forecastId = performRequest().getInt("forecastId");
        } catch (Exception e) {
            System.out.println(e);
        }
        return forecastId;
    }

    public String getForecast(){
        String forecast = "";
        try {
            forecast = performRequest().getString("forecast");
        } catch (Exception e) {
            System.out.println(e);
        }
        return forecast;
    }


    private JSONObject performRequest(){
        JSONObject responseObjct = new JSONObject();
        try {
            responseObjct = request.requestSensors();
        }catch (Exception e) {
            System.out.println(e);
        }
        return responseObjct;
    }

}