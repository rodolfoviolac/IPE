package sensors.luminositySensor;

public interface LuminositySensorInterface {
    double getCurrentValue();
    double getLuminosityValue();
    void setLuminosityValue(double newValue);
}
