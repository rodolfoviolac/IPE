package sensors.humiditySensor;

public interface HumiditySensorInterface {
    double getCurrentValue();
    double getHumidityValue();
    void setHumidityValue(double newValue);
}
