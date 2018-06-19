package UI.Info.Controller;

import Handlers.DataBase.DB;
import Handlers.Enum.PlotStatus;
import Handlers.FrameWorkUtils.ApplicationContextProvider;
import Handlers.Model.InfoInterface;
import Handlers.Model.Lot;
import UI.Info.View.InfoFrame;
import UI.Plant.Controller.PlantController;
import UI.Plow.Controller.PlowController;
import UI.Stock.Controller.StockController;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InfoController implements InfoInterface {
    private InfoFrame infoFrame;
    private StockController stockController = ApplicationContextProvider.getApplicationContext().getBean("stockController", StockController.class);
    private JButton plowButton;
    private JButton stockButton;
    private JButton plantButton;
    private JButton harvestButton;
    private Lot lot;


    public InfoController(Lot lot) {
        this.lot = lot;
        lot.setInfoDelegate(this);
        infoFrame = new InfoFrame();
        infoFrame.setTitle("Informações");
        this.initComponents();
        this.initializerListeners();
    }

    public void showLoginWindow(){
        infoFrame.setVisible(true);
    }


    private void initComponents(){
        this.plowButton = infoFrame.getPlowButton();
        this.stockButton = infoFrame.getStockButton();
        this.harvestButton = infoFrame.getColherButton();
        this.plantButton = infoFrame.getPlantarButton();
        this.updateLabels();
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


            if (lot.getStatus() != PlotStatus.readyToPlow){

                JOptionPane.showMessageDialog(null, "Lote não está pronto para ser arado.");

            }

            else{
                PlowController plow = new PlowController(lot);
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


            if (lot.getStatus() != PlotStatus.readyToHarvest){

                JOptionPane.showMessageDialog(null, "Lote não está pronto para colheita.");

            }

            else{

                lot.harvest();

            }



        }
    }
    private class plantButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            if (lot.getStatus() != PlotStatus.readyToPlant){

                JOptionPane.showMessageDialog(null, "Lote não está pronto para plantio.");

            }

            else{

                new PlantController(lot).showWindow();

            }

        }
    }


    @Override
    public void updateLabels() {


        infoFrame.setPlantedSpecieLabelText(lot.getPlantedSpecie().name());
        infoFrame.setLuminosityLabelText(String.valueOf(lot.getLuminosityValue()));
        infoFrame.setHumidityLabelText(String.valueOf(lot.getAirHumidityValue()));
        infoFrame.setMoisterLabel(String.valueOf(lot.getMoisterValue()));
        infoFrame.setPhLabelLabelText(String.valueOf(lot.getGroundPHValue()));
        infoFrame.setWeatherLabelText(lot.getWeather());
        infoFrame.setTemperatureLabelText(String.valueOf(lot.getTemperatureValue()));
        infoFrame.setForecastLabel(lot.getForecast());
        infoFrame.setCoverLabel(lot.getCoverStatus());
        infoFrame.setPluviometricLabelText(String.valueOf(lot.getPluviometricValue()));
        infoFrame.setUserNameLabelText(new DB().getLogedUser().getName());
        infoFrame.setIrrigacaoLabel(lot.getSprinklerStatus());

    }
}
