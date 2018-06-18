package UI.Info.Controller;

import Handlers.DataBase.DB;
import Handlers.DataBase.Data.UserData;
import Handlers.Enum.PlotStatus;
import Handlers.FrameWorkUtils.ApplicationContextProvider;
import Handlers.Http.HttpRequest;
import Handlers.Model.Plot;
import Handlers.Model.User;
import Sensors.humiditySensor.HumiditySensor;
import Sensors.luminositySensor.LuminositySensor;
import Sensors.moisterSensor.MoisterSensor;
import Sensors.phSensor.PhSensor;
import Sensors.pluviometricSensor.PluviometricSensor;
import Sensors.temperatureSensor.TemperatureSensor;
import Sensors.weatherSensor.WeatherSensor;
import UI.Info.View.InfoFrame;
import UI.Plant.Controller.PlantController;
import UI.Plow.Controller.PlowController;
import UI.Stock.Controller.StockController;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@Scope(value = "singleton")
@Component
public class InfoController {
    private MoisterSensor moister = ApplicationContextProvider.getApplicationContext().getBean("moisterSensor", MoisterSensor.class);
    private TemperatureSensor temperature = ApplicationContextProvider.getApplicationContext().getBean("temperatureSensor", TemperatureSensor.class);
    private HumiditySensor humidity = ApplicationContextProvider.getApplicationContext().getBean("humiditySensor", HumiditySensor.class);
    private PhSensor ph = ApplicationContextProvider.getApplicationContext().getBean("phSensor", PhSensor.class);
    private LuminositySensor luminosity = ApplicationContextProvider.getApplicationContext().getBean("luminositySensor", LuminositySensor.class);
    private PluviometricSensor pluviometric = ApplicationContextProvider.getApplicationContext().getBean("pluviometricSensor", PluviometricSensor.class);
    private WeatherSensor weather = ApplicationContextProvider.getApplicationContext().getBean("weatherSensor", WeatherSensor.class);
    HttpRequest request = ApplicationContextProvider.getApplicationContext().getBean("httpRequest", HttpRequest.class);
    private InfoFrame infoFrame;
    private StockController stockController = ApplicationContextProvider.getApplicationContext().getBean("stockController", StockController.class);
    private JButton plowButton;
    private JButton stockButton;
    private JButton plantButton;
    private JButton harvestButton;
    private Plot plot = new Plot();


    public InfoController() {
        infoFrame = new InfoFrame();
        infoFrame.setTitle("Informações");
        this.initComponents();
        this.initializerListeners();
    }

    public void showLoginWindow(){
        updater();
        infoFrame.setVisible(true);
    }

    public void updater(){
        DB db = new DB();
        this.infoFrame.setPlantedSpecieLabelText(this.plot.getPlantedSpecie().name());
        this.infoFrame.setUserNameLabelText(db.getLogedUser().getName());
        this.infoFrame.setHumidityLabelText(String.valueOf(humidity.getHumidityValue()));
        this.infoFrame.setLuminosityLabelText(String.valueOf(luminosity.getLuminosityValue()));
        this.infoFrame.setProgressBar(request.requestPredict());
        this.infoFrame.setForecastLabel(weather.getForecastValue());
        this.infoFrame.setWeatherLabelText(weather.getWeatherValue());
        this.infoFrame.setMoisterLabel(String.valueOf(moister.getMoisterValue()));
        this.infoFrame.setPhLabelLabelText(String.valueOf(ph.getPhValue()));
        this.infoFrame.setPluviometricLabelText(String.valueOf(pluviometric.getPluviometricValue()));
        this.infoFrame.setTemperatureLabelText(String.valueOf(temperature.getTemperatureValue()));


    }


    private void initComponents(){
        DB db = new DB();
        this.plowButton = infoFrame.getPlowButton();
        this.stockButton = infoFrame.getStockButton();
        this.harvestButton = infoFrame.getColherButton();
        this.plantButton = infoFrame.getPlantarButton();
        this.infoFrame.setPlantedSpecieLabelText(this.plot.getPlantedSpecie().name());
        this.infoFrame.setUserNameLabelText(db.getLogedUser().getName());

    }
    private void initializerListeners(){
        stockButton.addActionListener(new stockButtonListener());
        plowButton.addActionListener(new plowButtonListener());
        plantButton.addActionListener(new plantButtonListener());
        harvestButton.addActionListener(new harvestButtonListener());

    }


    private class plowButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {


            if (plot.getStatus() != PlotStatus.readyToPlow){

                JOptionPane.showMessageDialog(null, "Lote não está pronto para ser arado.");

            }

            else{
                PlowController plow = new PlowController(plot);
                plow.showPlowFormWindow();
            }

        }
    }

    private class stockButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            stockController.showStockFormWindow();
        }
    }
    private class harvestButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {


            if (plot.getStatus() != PlotStatus.readyToHarvest){

                JOptionPane.showMessageDialog(null, "Lote não está pronto para colheita.");

            }

            else{

                plot.harvest();

            }



        }
    }
    private class plantButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            if (plot.getStatus() != PlotStatus.readyToPlant){

                JOptionPane.showMessageDialog(null, "Lote não está pronto para plantio.");

            }

            else{

                new PlantController(plot).showWindow();

            }

        }
    }

}
