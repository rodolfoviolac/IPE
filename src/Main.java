import Handlers.FrameWorkUtils.ApplicationContextProvider;
import Handlers.Model.Lot;
import Sensors.humiditySensor.HumiditySensor;
import Sensors.luminositySensor.LuminositySensor;
import Sensors.moisterSensor.MoisterSensor;
import Sensors.phSensor.PhSensor;
import Sensors.pluviometricSensor.PluviometricSensor;
import Sensors.temperatureSensor.TemperatureSensor;
import Sensors.weatherSensor.WeatherSensor;
import UI.Login.Controller.LoginController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Handlers/FrameWorkUtils/config.xml");
        ApplicationContextProvider contextProvider = new ApplicationContextProvider();


        Lot lot = new Lot();

        contextProvider.setApplicationContext(context);
        MoisterSensor moister = (MoisterSensor) context.getBean("MoisterSensor");
        TemperatureSensor temperature = (TemperatureSensor) context.getBean("TemperatureSensor");
        HumiditySensor humidity = (HumiditySensor) context.getBean("HumiditySensor");
        PhSensor ph = (PhSensor) context.getBean("PhSensor");
        LuminositySensor luminosity = (LuminositySensor) context.getBean("LuminositySensor");
        PluviometricSensor pluviometric = (PluviometricSensor) context.getBean("PluviometricSensor");
        WeatherSensor weather = (WeatherSensor) context.getBean("WeatherSensor");


        LoginController login =  new LoginController();
        login.showLoginWindow();


    }
}
