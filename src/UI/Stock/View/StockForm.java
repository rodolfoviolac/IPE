package UI.Stock.View;

import javax.swing.*;
import java.awt.*;

public class StockForm extends JFrame {
    private JTable stockTable;
    private JPanel stockFormJpanel;
    private JTextField fertilizerNameTextField;
    private JTextField quantityTextField;
    private JButton addNewButton;
    private JTextField buyValueTextField;
    private JComboBox fertilizerNameComboBox;
    private JButton buyButton;
    private JTextField brandTextField;
    private JTextField validTextField;

    public StockForm() throws HeadlessException {
        setSize(700,700);
        setTitle("Stock Form");
        setContentPane(stockFormJpanel);
        setLocationRelativeTo(null);
    }

    public JTable getStockTable() {
        return stockTable;
    }

    public void setStockTable(JTable stockTable) {
        this.stockTable = stockTable;
    }

    public JPanel getStockFormJpanel() {
        return stockFormJpanel;
    }

    public void setStockFormJpanel(JPanel stockFormJpanel) {
        this.stockFormJpanel = stockFormJpanel;
    }

    public JTextField getFertilizerNameTextField() {
        return fertilizerNameTextField;
    }

    public void setFertilizerNameTextField(JTextField fertilizerNameTextField) {
        this.fertilizerNameTextField = fertilizerNameTextField;
    }

    public JTextField getQuantityTextField() {
        return quantityTextField;
    }

    public void setQuantityTextField(JTextField quantityTextField) {
        this.quantityTextField = quantityTextField;
    }

    public JButton getAddNewButton() {
        return addNewButton;
    }

    public void setAddNewButton(JButton addNewButton) {
        this.addNewButton = addNewButton;
    }

    public JTextField getBuyValueTextField() {
        return buyValueTextField;
    }

    public void setBuyValueTextField(JTextField buyValueTextField) {
        this.buyValueTextField = buyValueTextField;
    }

    public JComboBox getFertilizerNameComboBox() {
        return fertilizerNameComboBox;
    }

    public void setFertilizerNameComboBox(JComboBox fertilizerNameComboBox) {
        this.fertilizerNameComboBox = fertilizerNameComboBox;
    }

    public JButton getBuyButton() {
        return buyButton;
    }

    public void setBuyButton(JButton buyButton) {
        this.buyButton = buyButton;
    }

    public JTextField getBrandTextField() {
        return brandTextField;
    }

    public void setBrandTextField(JTextField brandTextField) {
        this.brandTextField = brandTextField;
    }

    public JTextField getValidTextField() {
        return validTextField;
    }

    public void setValidTextField(JTextField validTextField) {
        this.validTextField = validTextField;
    }
}
