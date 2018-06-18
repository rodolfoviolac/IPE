import Handlers.FrameWorkUtils.ApplicationContextProvider;
import Handlers.Http.handler.Predict;
import Handlers.Model.Plot;
import Sensors.humiditySensor.HumiditySensor;
import Sensors.luminositySensor.LuminositySensor;
import Sensors.moisterSensor.MoisterSensor;
import Sensors.phSensor.PhSensor;
import Sensors.pluviometricSensor.PluviometricSensor;
import Sensors.temperatureSensor.TemperatureSensor;
import Sensors.weatherSensor.WeatherSensor;
import UI.Login.Controller.LoginController;
import UI.Plow.Controller.PlowController;
import UI.Plow.View.PlowForm;
import UI.Stock.Controller.StockController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Handlers/FrameWorkUtils/config.xml");
        ApplicationContextProvider contextProvider = new ApplicationContextProvider();


        Plot plot = new Plot();

        contextProvider.setApplicationContext(context);
        MoisterSensor moister = (MoisterSensor) context.getBean("MoisterSensor");
        TemperatureSensor temperature = (TemperatureSensor) context.getBean("TemperatureSensor");
        HumiditySensor humidity = (HumiditySensor) context.getBean("HumiditySensor");
        PhSensor ph = (PhSensor) context.getBean("PhSensor");
        LuminositySensor luminosity = (LuminositySensor) context.getBean("LuminositySensor");
        PluviometricSensor pluviometric = (PluviometricSensor) context.getBean("PluviometricSensor");
        WeatherSensor weather = (WeatherSensor) context.getBean("WeatherSensor");


        System.out.print(plot.getLuminosity());
        LoginController login =  new LoginController();
        login.showLoginWindow();

        Predict result = new Predict();
        System.out.println(result.getPlantingPredict());


    }
}
