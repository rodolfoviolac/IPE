package UI.Emulator.Controller;

public interface PlotInterface {

    void updateLuminosity(double newValue);
    void updatePH(double newValue);
    void updateHumidity(double newValue);
    void updateTemperature(double newValue);
    void updateWeather(String newValue);
    void updateMoister(double newValue);
    void updatePluviometric(double newValue);
    void updateForcast(String newValue);
    void updateLabels();

}
