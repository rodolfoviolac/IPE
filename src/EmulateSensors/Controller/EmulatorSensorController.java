package EmulateSensors.Controller;

import EmulateSensors.View.EmulateSensorForm;
import org.springframework.stereotype.Component;
import sensors.humiditySensor.HumiditySensor;
import sensors.luminositySensor.LuminositySensor;
import sensors.moisterSensor.MoisterSensor;
import sensors.phSensor.PhSensor;
import sensors.pluviometricSensor.PluviometricSensor;
import sensors.temperatureSensor.TemperatureSensor;
import sensors.weatherSensor.WeatherSensor;
import utils.ApplicationContextProvider;


import javax.swing.*;

@Component
public class EmulatorSensorController {
    MoisterSensor moister = ApplicationContextProvider.getApplicationContext().getBean("moisterSensor", MoisterSensor.class);
    TemperatureSensor temperature = ApplicationContextProvider.getApplicationContext().getBean("temperatureSensor", TemperatureSensor.class);
    HumiditySensor humidity = ApplicationContextProvider.getApplicationContext().getBean("humiditySensor", HumiditySensor.class);
    PhSensor ph = ApplicationContextProvider.getApplicationContext().getBean("phSensor", PhSensor.class);
    LuminositySensor luminosity = ApplicationContextProvider.getApplicationContext().getBean("luminositySensor", LuminositySensor.class);
    PluviometricSensor pluviometric = ApplicationContextProvider.getApplicationContext().getBean("pluviometricSensor", PluviometricSensor.class);
    WeatherSensor weather = ApplicationContextProvider.getApplicationContext().getBean("weatherSensor", WeatherSensor.class);
    private EmulateSensorForm EmulateSensorsJPanel;
    private JTextField luminosityTextField;
    private JTextField humidityTextField;
    private JTextField moisterTextField;
    private JTextField phTextField;
    private JTextField pluviometricTextField;
    private JTextField temperatureTextField;
    private JButton updateButton;
    private JComboBox forecastComboBox;
    private JComboBox weatherComboBox;


    public EmulatorSensorController() {
        EmulateSensorsJPanel = new EmulateSensorForm();
        this.initComponents();
        updateSensorsTextFields();
    }

    private void initComponents(){
        this.luminosityTextField = EmulateSensorsJPanel.getLuminosityTextField();
        this.humidityTextField = EmulateSensorsJPanel.getHumidityTextField();
        this.moisterTextField = EmulateSensorsJPanel.getMoisterTextField();
        this.phTextField = EmulateSensorsJPanel.getPhTextField();
        this.pluviometricTextField = EmulateSensorsJPanel.getPluviometricTextField();
        this.temperatureTextField = EmulateSensorsJPanel.getTemperatureTextField();
        this.forecastComboBox = EmulateSensorsJPanel.getForecastComboBox();
        this.weatherComboBox = EmulateSensorsJPanel.getWeatherComboBox();
        this.updateButton = EmulateSensorsJPanel.getUpdateButton();
    }

    private void updateSensorsTextFields() {
        this.luminosityTextField.setText(Double.toString(luminosity.getLuminosityValue()));
        this.humidityTextField.setText(Double.toString(humidity.getHumidityValue()));
        this.moisterTextField.setText(Double.toString(moister.getMoisterValue()));
        this.phTextField.setText(Double.toString(ph.getPhValue()));
        this.pluviometricTextField.setText(Double.toString(pluviometric.getPluviometricValue()));
        this.temperatureTextField.setText(Double.toString(temperature.getTemperatureValue()));
    }

    public void showEmulatorSensorWindow(){
        EmulateSensorsJPanel.setVisible(true);
    }
}
