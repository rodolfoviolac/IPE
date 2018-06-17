package UI.Plow.View;

import javax.swing.*;
import java.awt.*;

public class PlowForm extends JFrame {
    private JComboBox FertilizerNameComboBox;
    private JPanel PlowPanel;
    private JTextField QuantityTextField;
    private JButton startButton;

    public PlowForm() throws HeadlessException {
        setSize(350,350);
        setTitle("Automatic Plow Form");
        setContentPane(PlowPanel);
        setLocationRelativeTo(null);
    }

    public JComboBox getFertilizerNameComboBox() {
        return FertilizerNameComboBox;
    }

    public void setFertilizerNameComboBox(JComboBox fertilizerNameComboBox) {
        FertilizerNameComboBox = fertilizerNameComboBox;
    }

    public JPanel getPlowPanel() {
        return PlowPanel;
    }

    public void setPlowPanel(JPanel plowPanel) {
        PlowPanel = plowPanel;
    }

    public JTextField getQuantityTextField() {
        return QuantityTextField;
    }

    public void setQuantityTextField(JTextField quantityTextField) {
        QuantityTextField = quantityTextField;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }
}
