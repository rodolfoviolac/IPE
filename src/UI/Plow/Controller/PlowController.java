package UI.Plow.Controller;

import Handlers.DataBase.DB;
import Handlers.Model.Fertilizer;
import Handlers.Model.Plot;
import UI.Plow.View.PlowForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class PlowController {
    private JComboBox FertilizerNameComboBox;
    private PlowForm PlowForm;
    private JTextField quantityTextField;
    private JButton startButton;
    private PlowForm plowForm = new PlowForm();
    private Plot plot;

    public PlowController(Plot plot) {
        plowForm.setTitle("Arador Automâtico");
        this.initComponents();
        this.plot = plot;
        updateTextFields();
        initializerListeners();
    }

    public void initComponents(){
        this.startButton = plowForm.getStartButton();
        this.quantityTextField = plowForm.getQuantityTextField();
        this.FertilizerNameComboBox = plowForm.getFertilizerNameComboBox();
    }

    public void updateTextFields(){
        DB db = new DB();
        Set<String> allFertilizer = db.getAllFertilizer();
        int i =0;
        for (String fertilizer : allFertilizer) {
            Fertilizer fert = db.getFertilizerById(fertilizer);
            this.FertilizerNameComboBox.addItem(fert.getName());
        }
    }

    private void initializerListeners(){
        startButton.addActionListener(new startButtonListener());
    }

    private class startButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(Integer.parseInt(quantityTextField.getText()) > 0){
                DB db = new DB();
                boolean transaction = db.useFertilizer((String)FertilizerNameComboBox.getSelectedItem(), Integer.parseInt(quantityTextField.getText()));
                if(transaction){
                    plot.plow(db.getFertilizerById((String) FertilizerNameComboBox.getSelectedItem()));
                    updateTextFields();
                    plowForm.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "This is not possible. You dont have enough on stock! ");
                }
            } else JOptionPane.showMessageDialog(null, "This is not possible.");
        }
    }
    public void showPlowFormWindow(){
        plowForm.setVisible(true);
    }
}
