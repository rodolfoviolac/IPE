package sensors.temperatureSensor;

public interface TemperatureSensorInterface {
    double getCurrentValue();
    double getMoisterValue();
    void setTemperatureValue(double newValue);
}
