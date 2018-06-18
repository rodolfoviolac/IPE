package UI.Plant.Controller;

import Handlers.DataBase.DB;
import Handlers.Enum.PlantSpecies;
import Handlers.Model.Fertilizer;
import Handlers.Model.Plot;
import UI.Plant.View.PlantFrame;
import UI.Plow.Controller.PlowController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class PlantController {


    private Plot plot;
    private PlantFrame plantFrame;
    private JButton confirmButton;
    private JComboBox comboBox;



    public PlantController(Plot plot){

        this.plot = plot;
        this.plantFrame = new PlantFrame();
        this.plantFrame.setTitle("Escolha de espécie");
        this.initComponents();
        this.initializerListeners();

    }

    public void showWindow(){

        plantFrame.setVisible(true);
    }


    private void initComponents(){

        this.confirmButton = plantFrame.getConfirmButton();
        this.comboBox = plantFrame.getComboBox();

        comboBox.addItem(PlantSpecies.Milho);
        comboBox.addItem(PlantSpecies.Soja);
        comboBox.addItem(PlantSpecies.Trigo);
        comboBox.addItem(PlantSpecies.Marijuana);



    }
    private void initializerListeners(){
        confirmButton.addActionListener(new confirmButtonListener());

    }


private class confirmButtonListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        plot.plant((PlantSpecies) comboBox.getSelectedItem());

        plantFrame.setVisible(false);

    }
}


}
