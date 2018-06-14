import moisterSensor.MoinsterSensor;
import moisterSensor.MoisterSensor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        MoisterSensor moister = (MoinsterSensor) context.getBean("MoinsterSensor");
        System.out.println(moister.getCurrentValue());
    }

}
