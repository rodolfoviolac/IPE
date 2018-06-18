package UI.Info.Controller;

import Handlers.Enum.PlotStatus;
import Handlers.Model.Plot;
import Handlers.Model.User;
import UI.Info.View.InfoFrame;
import UI.Plant.Controller.PlantController;
import UI.Plow.Controller.PlowController;
import UI.Stock.Controller.StockController;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class InfoController {

    private InfoFrame infoFrame;
    private User currentUser;
    private JButton plowButton;
    private JButton stockButton;
    private JButton plantButton;
    private JButton harvestButton;
    private Plot plot = new Plot();


    public InfoController(User currentUser) {
        infoFrame = new InfoFrame();
        this.currentUser = currentUser;
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

        this.infoFrame.setPlantedSpecieLabelText(this.plot.getPlantedSpecie().name());
        this.infoFrame.setUserNameLabelText(currentUser.getName());


        System.out.print(plot.getLuminosity());


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

            StockController stock = new StockController();
            stock.showStockFormWindow();
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
