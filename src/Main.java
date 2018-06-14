import sensors.moisterSensor.MoisterSensor;
import sensors.moisterSensor.MoisterSensorInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sensors.temperatureSensor.TemperatureSensor;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        MoisterSensorInterface moister = (MoisterSensor) context.getBean("MoinsterSensor");
        TemperatureSensor temperature = (TemperatureSensor) context.getBean("TemperatureSensor");
        System.out.println(moister.getCurrentValue());
        System.out.println(temperature.getCurrentValue());
    }
}
