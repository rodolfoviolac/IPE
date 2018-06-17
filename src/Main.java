import Handlers.FrameWorkUtils.ApplicationContextProvider;
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

//        StockController stock = new StockController();
////        stock.showStockFormWindow();
        PlowController plow = new PlowController();
        plow.showPlowFormWindow();
    }
}
