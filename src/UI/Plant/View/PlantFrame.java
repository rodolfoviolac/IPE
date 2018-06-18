package UI.Plant.View;

import javax.swing.*;
import java.awt.*;




public class PlantFrame extends JFrame {
    private JComboBox comboBox;
    private JPanel panel;
    private JButton confirmButton;



    public PlantFrame() throws HeadlessException {
        setSize(350,350);
        setTitle("Automatic Plow Form");
        setContentPane(panel);
        setLocationRelativeTo(null);
    }


    public JComboBox getComboBox() {
        return comboBox;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }
}
