package sensors.pluviometricSensor;

public interface PluviometricSensorInterface {
    double getCurrentValue();
    double getPluviometricValue();
    void setPluviometricValue(double newValue);
}
