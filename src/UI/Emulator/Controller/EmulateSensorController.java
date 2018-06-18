package UI.Emulator.Controller;

import Handlers.FrameWorkUtils.ApplicationContextProvider;
import Handlers.Observers.Observers;
import UI.Emulator.View.EmulateSensorForm;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import Sensors.humiditySensor.HumiditySensor;
import Sensors.luminositySensor.LuminositySensor;
import Sensors.moisterSensor.MoisterSensor;
import Sensors.phSensor.PhSensor;
import Sensors.pluviometricSensor.PluviometricSensor;
import Sensors.temperatureSensor.TemperatureSensor;
import Sensors.weatherSensor.WeatherSensor;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Scope(value = "singleton")
@Component
public class EmulateSensorController {
    private MoisterSensor moister = ApplicationContextProvider.getApplicationContext().getBean("moisterSensor", MoisterSensor.class);
    private TemperatureSensor temperature = ApplicationContextProvider.getApplicationContext().getBean("temperatureSensor", TemperatureSensor.class);
    private HumiditySensor humidity = ApplicationContextProvider.getApplicationContext().getBean("humiditySensor", HumiditySensor.class);
    private PhSensor ph = ApplicationContextProvider.getApplicationContext().getBean("phSensor", PhSensor.class);
    private LuminositySensor luminosity = ApplicationContextProvider.getApplicationContext().getBean("luminositySensor", LuminositySensor.class);
    private PluviometricSensor pluviometric = ApplicationContextProvider.getApplicationContext().getBean("pluviometricSensor", PluviometricSensor.class);
    private WeatherSensor weather = ApplicationContextProvider.getApplicationContext().getBean("weatherSensor", WeatherSensor.class);
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


    public EmulateSensorController() {
        EmulateSensorsJPanel = new EmulateSensorForm();
        this.initComponents();
        this.initializerListeners();
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

    public void updateSensorsTextFields() {
        this.luminosityTextField.setText(Double.toString(luminosity.getLuminosityValue()));
        this.humidityTextField.setText(Double.toString(humidity.getHumidityValue()));
        this.moisterTextField.setText(Double.toString(moister.getMoisterValue()));
        this.phTextField.setText(Double.toString(ph.getPhValue()));
        this.pluviometricTextField.setText(Double.toString(pluviometric.getPluviometricValue()));
        this.temperatureTextField.setText(Double.toString(temperature.getTemperatureValue()));
    }

    private void initializerListeners(){
        updateButton.addActionListener(new updateButtonListener());
    }
    private class updateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            luminosity.setLuminosityValue(Double.parseDouble(luminosityTextField.getText()));
            temperature.setTemperatureValue(Double.parseDouble(temperatureTextField.getText()));
            moister.setMoisterValue(Double.parseDouble(moisterTextField.getText()));
            ph.setPhValue(Double.parseDouble(phTextField.getText()));
            pluviometric.setPluviometricValue(Double.parseDouble(pluviometricTextField.getText()));
            humidity.setHumidityValue(Double.parseDouble(humidityTextField.getText()));
            weather.setWeatherValue((String) weatherComboBox.getSelectedItem());
            weather.setForecastValue((String) forecastComboBox.getSelectedItem());
            Observers ob = new Observers();
            ob.syncAllTextFields();
        }
    }

    public void showEmulatorSensorWindow(){
        EmulateSensorsJPanel.setVisible(true);
    }
}
