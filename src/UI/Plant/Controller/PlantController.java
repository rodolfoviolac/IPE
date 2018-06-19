package UI.Plant.Controller;

import Handlers.Enum.PlantSpecies;
import Handlers.Model.Lot;
import Handlers.Observers.Observers;
import UI.Plant.View.PlantFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlantController {


    private Lot lot;
    private PlantFrame plantFrame;
    private JButton confirmButton;
    private JComboBox comboBox;



    public PlantController(Lot lot){

        this.lot = lot;
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
        lot.plant((PlantSpecies) comboBox.getSelectedItem());
        plantFrame.setVisible(false);

    }
}


}
