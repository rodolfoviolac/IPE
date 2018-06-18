package UI.Info.Controller;

import Handlers.DataBase.DB;
import Handlers.DataBase.Data.UserData;
import Handlers.Enum.PlotStatus;
import Handlers.FrameWorkUtils.ApplicationContextProvider;
import Handlers.Model.Plot;
import Handlers.Model.User;
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
