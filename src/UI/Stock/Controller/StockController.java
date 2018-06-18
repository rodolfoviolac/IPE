package UI.Stock.Controller;

import Handlers.DataBase.DB;
import Handlers.Model.Fertilizer;
import UI.Stock.View.StockForm;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Scope(value = "singleton")
@Component
public class StockController {
    private JTable stockTable;
    private StockForm StockFormJpanel;
    private JTextField fertilizerNameTextField;
    private JTextField quantityTextField;
    private JButton addNewButton;
    private JTextField buyValueTextField;
    private JComboBox fertilizerNameComboBox;
    private JButton buyButton;
    private JTextField brandTextField;
    private JTextField validTextField;

    public StockController(){
        StockFormJpanel = new StockForm();
        this.initComponents();
        this.StockFormJpanel.setTitle("Estoque");
        updateTextFields();
        initializerListeners();
    }

    private void initComponents(){
        this.stockTable = StockFormJpanel.getStockTable();
        this.fertilizerNameTextField = StockFormJpanel.getFertilizerNameTextField();
        this.brandTextField = StockFormJpanel.getBrandTextField();
        this.quantityTextField = StockFormJpanel.getQuantityTextField();
        this.validTextField = StockFormJpanel.getValidTextField();
        this.buyValueTextField = StockFormJpanel.getBuyValueTextField();
        this.addNewButton = StockFormJpanel.getAddNewButton();
        this.buyButton = StockFormJpanel.getBuyButton();
        this.fertilizerNameComboBox = StockFormJpanel.getFertilizerNameComboBox();
    }

    private void updateTextFields(){
        DB db = new DB();
        Set<String> allFertilizer = db.getAllFertilizer();
        String[] columnNames = {"Name", "Brand", "Valid", "Quantity in Stock"};
        String[][] data = new String[allFertilizer.size()][];
        int i =0;
        for (String fertilizer : allFertilizer) {
            Fertilizer fert = db.getFertilizerById(fertilizer);
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String date = df.format(fert.getValid()).toString();
            data[i] = new String[] { fert.getName(), fert.getBrand(),date, Integer.toString(fert.getQuantity())};
            this.fertilizerNameComboBox.addItem(fert.getName());
            i++;
        }
        DefaultTableModel mod = new DefaultTableModel(data, columnNames);
        this.stockTable.setModel(mod);
    }

    private void initializerListeners(){
        buyButton.addActionListener(new buyFertilizerButtonListener());
        addNewButton.addActionListener(new addNewFertilizerButtonListener());
    }

    private class buyFertilizerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(Integer.parseInt(buyValueTextField.getText()) > 0){
                DB db = new DB();
                boolean transaction = db.buyFertilizer((String)fertilizerNameComboBox.getSelectedItem(), Integer.parseInt(buyValueTextField.getText()));
                if(transaction){
                    updateTextFields();
                    cleanFields();
                }
                else {
                    JOptionPane.showMessageDialog(null, "This is not possible.");
                }
            } else JOptionPane.showMessageDialog(null, "This is not possible.");
        }
    }

    private class addNewFertilizerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(isValidNumber(validTextField.getText(), quantityTextField.getText())){
                Date today = new Date();
                DB db = new DB();
                Fertilizer fert = new Fertilizer(fertilizerNameTextField.getText(), brandTextField.getText(),  new Date(today.getTime() + (86400000 * Integer.parseInt(validTextField.getText()))),Integer.parseInt(quantityTextField.getText()));
                db.addNewFetilizer(fert);
                updateTextFields();
                cleanFields();
                JOptionPane.showMessageDialog(null, "Fertilizer Added Successfully!");
            } else JOptionPane.showMessageDialog(null, "This is not possible.");
        }
    }

    private boolean isValidNumber(String days, String qnt){
        boolean shouldReturn;
        try {
            Integer.parseInt(days);
            Integer.parseInt(qnt);
            shouldReturn = true;
        } catch (NumberFormatException nfe) {
            shouldReturn = false;
        }
        return shouldReturn;
    }

    private void cleanFields(){
        fertilizerNameTextField.setText("");
        brandTextField.setText("");
        quantityTextField.setText("");
        validTextField.setText("");
        buyValueTextField.setText("");
    }

    public void showStockFormWindow(){
        StockFormJpanel.setVisible(true);
    }
}
