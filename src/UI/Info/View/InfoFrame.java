package UI.Info.View;

import javax.swing.*;
import java.awt.*;

public class InfoFrame extends JFrame{

    private JPanel infoPanel;
    private JLabel userNameLabel;
    private JLabel luminosityLabel;
    private JLabel humidityLabel;
    private JLabel temperatureLabel;
    private JLabel phLabel;
    private JLabel weatherLabel;
    private JLabel pluviometricLabel;
    private JButton plowButton;
    private JButton stockButton;


    public InfoFrame() throws HeadlessException {
        setSize(600,600);
        setTitle("UI/Login");
        setContentPane(infoPanel);
        setLocationRelativeTo(null);
    }

    public JButton getPlowButton() {
        return plowButton;
    }

    public JButton getStockButton() {
        return stockButton;
    }

    public void setUserNameLabel(JLabel userNameLabel) {
        this.userNameLabel = userNameLabel;
    }

    public void setLuminosityLabel(JLabel luminosityLabel) {
        this.luminosityLabel = luminosityLabel;
    }

    public void setHumidityLabel(JLabel humidityLabel) {
        this.humidityLabel = humidityLabel;
    }

    public void setTemperatureLabel(JLabel temperatureLabel) {
        this.temperatureLabel = temperatureLabel;
    }

    public void setPhLabel(JLabel phLabel) {
        this.phLabel = phLabel;
    }

    public void setWeatherLabel(JLabel weatherLabel) {
        this.weatherLabel = weatherLabel;
    }

    public void setPluviometricLabel(JLabel pluviometricLabel) {
        this.pluviometricLabel = pluviometricLabel;
    }
}
