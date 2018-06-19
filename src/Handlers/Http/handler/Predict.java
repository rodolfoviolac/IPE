package Handlers.Http.handler;

import Handlers.FrameWorkUtils.ApplicationContextProvider;
import Sensors.humiditySensor.HumiditySensor;
import Sensors.luminositySensor.LuminositySensor;
import Sensors.moisterSensor.MoisterSensor;
import Sensors.phSensor.PhSensor;
import Sensors.pluviometricSensor.PluviometricSensor;
import Sensors.temperatureSensor.TemperatureSensor;
import Sensors.weatherSensor.WeatherSensor;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Predict {
    private MoisterSensor moister = ApplicationContextProvider.getApplicationContext().getBean("moisterSensor", MoisterSensor.class);
    private TemperatureSensor temperature = ApplicationContextProvider.getApplicationContext().getBean("temperatureSensor", TemperatureSensor.class);
    private HumiditySensor humidity = ApplicationContextProvider.getApplicationContext().getBean("humiditySensor", HumiditySensor.class);
    private PhSensor ph = ApplicationContextProvider.getApplicationContext().getBean("phSensor", PhSensor.class);
    private LuminositySensor luminosity = ApplicationContextProvider.getApplicationContext().getBean("luminositySensor", LuminositySensor.class);
    private PluviometricSensor pluviometric = ApplicationContextProvider.getApplicationContext().getBean("pluviometricSensor", PluviometricSensor.class);
    private WeatherSensor weather = ApplicationContextProvider.getApplicationContext().getBean("weatherSensor", WeatherSensor.class);
    int predictResponse;

    public int getPlantingPredict() {
        System.out.print(temperature.getTemperatureValue());
        String query_url = " https://plantingdecision.herokuapp.com/predict";
        String json = "{ " +
                "\"weatherId\" : \""+ weather.getWeatherId() +"\"," +
                "\"forecastId\" : \""+ weather.getForecastId() +"\"," +
                "\"soilMoisture\" :\""+ moister.getMoisterValue() +"\"," +
                "\"soilT0\" :\""+ 7 +"\"," +
                "\"soilT10\" :\""+ 18 +"\"," +
                "\"cloudness\" :\""+ 30 +"\"," +
                "\"pressure\" :\""+ 1000 +"\"," +
                "\"temperature\" : \""+ temperature.getTemperatureValue() +"\"," +
                "\"ph\" : \""+ ph.getPhValue() +"\"," +
                "\"luminosity\" :\""+ luminosity.getLuminosityValue() +"\"," +
                "\"humidity\" : \""+ humidity.getHumidityValue() +"\"," +
                "\"pluviometric\" : " + pluviometric.getPluviometricValue() +" }";

        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            String result = IOUtils.toString(in, "UTF-8");
            System.out.println(result);
            JSONObject myResponse = new JSONObject(result);
            predictResponse = Integer.parseInt(myResponse.getString("resultado"));
            in.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
        return predictResponse;
    }
}
