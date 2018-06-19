package UI.Emulator.Controller;

import Handlers.FrameWorkUtils.ApplicationContextProvider;
import Handlers.Model.Lot;
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
    private PlotInterface plotDelegate;


    public EmulateSensorController(Lot main_lot) {
        this.plotDelegate = main_lot;
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
        plotDelegate.updateHumidity(Double.parseDouble(humidityTextField.getText()));
        plotDelegate.updateLuminosity(Double.parseDouble(luminosityTextField.getText()));
        plotDelegate.updateMoister(Double.parseDouble(moisterTextField.getText()));
        plotDelegate.updatePH(Double.parseDouble(phTextField.getText()));
        plotDelegate.updateTemperature(Double.parseDouble(temperatureTextField.getText()));
        plotDelegate.updatePluviometric(Double.parseDouble(pluviometricTextField.getText()));
        plotDelegate.updateWeather(this.weather.getWeatherValue());
        plotDelegate.updateForcast(this.weather.getForecastValue());
        plotDelegate.updateLabels();
    }

    private void initializerListeners(){
        updateButton.addActionListener(new updateButtonListener());
    }
    private class updateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(validSensors()){
                luminosity.setLuminosityValue(Double.parseDouble(luminosityTextField.getText()));
                temperature.setTemperatureValue(Double.parseDouble(temperatureTextField.getText()));
                moister.setMoisterValue(Double.parseDouble(moisterTextField.getText()));
                ph.setPhValue(Double.parseDouble(phTextField.getText()));
                pluviometric.setPluviometricValue(Double.parseDouble(pluviometricTextField.getText()));
                humidity.setHumidityValue(Double.parseDouble(humidityTextField.getText()));
                weather.setWeatherValue((String) weatherComboBox.getSelectedItem());
                weather.setForecastValue((String) forecastComboBox.getSelectedItem());
                plotDelegate.updateHumidity(Double.parseDouble(humidityTextField.getText()));
                plotDelegate.updateLuminosity(Double.parseDouble(luminosityTextField.getText()));
                plotDelegate.updateMoister(Double.parseDouble(moisterTextField.getText()));
                plotDelegate.updatePH(Double.parseDouble(phTextField.getText()));
                plotDelegate.updateTemperature(Double.parseDouble(temperatureTextField.getText()));
                plotDelegate.updatePluviometric(Double.parseDouble(pluviometricTextField.getText()));
                plotDelegate.updateWeather((String) weatherComboBox.getSelectedItem());
                plotDelegate.updateForcast((String) forecastComboBox.getSelectedItem());
                plotDelegate.updateLabels();
            } else  JOptionPane.showMessageDialog(null, "Novos Valores de Sensores não Permitidos.");
        }
    }

    private boolean validSensors() {
        boolean shouldReturn = false;
        if(isSensorValueValid(Double.parseDouble(luminosityTextField.getText()), "luminosity") &&
        isSensorValueValid(Double.parseDouble(temperatureTextField.getText()), "temperature") &&
        isSensorValueValid(Double.parseDouble(moisterTextField.getText()), "moister") &&
        isSensorValueValid(Double.parseDouble(phTextField.getText()), "ph") &&
        isSensorValueValid(Double.parseDouble(pluviometricTextField.getText()), "pluviometric")&&
        isSensorValueValid(Double.parseDouble(humidityTextField.getText()), "humidity")) shouldReturn = true ;
        return shouldReturn;
    }

    private static boolean isSensorValueValid(double value, String sensorType){
        boolean shouldReturn = false;
        switch (sensorType) {
            case "humidity": if (value >= 0 && value <= 100) shouldReturn = true; break;
            case "moister": if (value >= 0 && value <= 100) shouldReturn = true; break;
            case "pluviometric": if (value >= 0 && value <= 200) shouldReturn = true; break;
            case "temperature": if (value >= -30 && value <= 50) shouldReturn = true; break;
            case "ph": if (value >= 0 && value <= 14) shouldReturn = true; break;
            case "luminosity": if (value >= 0 && value <= 24) shouldReturn = true; break;
        }
        return shouldReturn;
    }

    public void showEmulatorSensorWindow(){
        EmulateSensorsJPanel.setVisible(true);
    }
}
