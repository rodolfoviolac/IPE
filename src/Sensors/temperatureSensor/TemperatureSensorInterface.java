package Sensors.temperatureSensor;

public interface TemperatureSensorInterface {
    double getCurrentValue();
    double getTemperatureValue();
    void setTemperatureValue(double newValue);
}
