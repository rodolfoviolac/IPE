package UI.EmulateSensors.View;

import javax.swing.*;
import java.awt.*;

public class EmulateSensorForm extends JFrame{
    private JPanel EmulateSensorsJPanel;
    private JTextField luminosityTextField;
    private JTextField humidityTextField;
    private JTextField moisterTextField;
    private JTextField phTextField;
    private JTextField pluviometricTextField;
    private JTextField temperatureTextField;
    private JButton updateButton;
    private JComboBox forecastComboBox;
    private JComboBox weatherComboBox;
    String[] wheatherList = new String[]{"thunderstorm with light rain",
            "thunderstorm with rain",
            "thunderstorm with heavy rain",
            "light thunderstorm",
            "thunderstorm",
            "heavy thunderstorm",
            "ragged thunderstorm",
            "thunderstorm with light drizzle",
            "thunderstorm with drizzle",
            "thunderstorm with heavy drizzle",
            "light intensity drizzle",
            "drizzle",
            "heavy intensity drizzle",
            "light intensity drizzle rain",
            "drizzle rain",
            "heavy intensity drizzle rain",
            "shower rain and drizzle",
            "heavy shower rain and drizzle",
            "shower drizzle",
            "light rain",
            "moderate rain",
            "heavy intensity rain",
            "very heavy rain",
            "extreme rain",
            "freezing rain",
            "light intensity shower rain",
            "shower rain",
            "heavy intensity shower rain",
            "ragged shower rain",
            "light snow",
            "snow",
            "heavy snow",
            "sleet",
            "shower sleet",
            "light rain and snow",
            "rain and snow",
            "light shower snow",
            "shower snow",
            "heavy shower snow",
            "mist",
            "smoke",
            "haze",
            "sand, dust whirls",
            "fog",
            "sand",
            "dust",
            "volcanic ash",
            "squalls",
            "tornado",
            "clear sky",
            "few clouds",
            "scattered clouds",
            "broken clouds",
            "overcast clouds"
    };

    public EmulateSensorForm() throws HeadlessException {
        setSize(500,500);
        setTitle("Emulator");
        setContentPane(EmulateSensorsJPanel);
        setLocationRelativeTo(null);
        handleInitComboBox();
    }

    private void handleInitComboBox() {
        for (String wheather : wheatherList) {
            weatherComboBox.addItem(wheather);
            forecastComboBox.addItem(wheather);
        }
    }

    public JTextField getLuminosityTextField() {
        return luminosityTextField;
    }

    public void setLuminosityTextField(JTextField luminosityTextField) {
        this.luminosityTextField = luminosityTextField;
    }

    public JTextField getHumidityTextField() {
        return humidityTextField;
    }

    public void setHumidityTextField(JTextField humidityTextField) {
        this.humidityTextField = humidityTextField;
    }

    public JTextField getMoisterTextField() {
        return moisterTextField;
    }

    public void setMoisterTextField(JTextField moisterTextField) {
        this.moisterTextField = moisterTextField;
    }

    public JTextField getPhTextField() {
        return phTextField;
    }

    public void setPhTextField(JTextField phTextField) {
        this.phTextField = phTextField;
    }

    public JTextField getPluviometricTextField() {
        return pluviometricTextField;
    }

    public void setPluviometricTextField(JTextField pluviometricTextField) {
        this.pluviometricTextField = pluviometricTextField;
    }

    public JTextField getTemperatureTextField() {
        return temperatureTextField;
    }

    public void setTemperatureTextField(JTextField temperatureTextField) {
        this.temperatureTextField = temperatureTextField;
    }

    public JComboBox getForecastComboBox() {
        return forecastComboBox;
    }

    public void setForecastComboBox(JComboBox forecastComboBox) {
        this.forecastComboBox = forecastComboBox;
    }

    public JComboBox getWeatherComboBox() {
        return weatherComboBox;
    }

    public void setWeatherComboBox(JComboBox weatherComboBox) {
        this.weatherComboBox = weatherComboBox;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }
}
