import EmulateSensors.Controller.EmulatorSensorController;
import EmulateSensors.View.EmulateSensorForm;
import Login.Controller.LoginController;
import sensors.HttpRequest;
import sensors.humiditySensor.HumiditySensor;
import sensors.luminositySensor.LuminositySensor;
import sensors.moisterSensor.MoisterSensor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sensors.phSensor.PhSensor;
import sensors.pluviometricSensor.PluviometricSensor;
import sensors.temperatureSensor.TemperatureSensor;
import sensors.weatherSensor.WeatherSensor;
import utils.ApplicationContextProvider;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        ApplicationContextProvider contextProvider = new ApplicationContextProvider();
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
