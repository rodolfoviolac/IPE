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
    private JProgressBar progressBar1;
    private JLabel forecastLabel;
    private JLabel coverLabel;
    private JLabel irrigacaoLabel;
    private JLabel moisterLabel;
    private JButton colherButton;
    private JButton plantarButton;
    private JLabel plantedSpecie;

    public InfoFrame() throws HeadlessException {
        setSize(850,400);
        setTitle("Lote");
        setContentPane(infoPanel);
        setLocationRelativeTo(null);
    }

    public JButton getColherButton() {
        return colherButton;
    }

    public JButton getPlantarButton() {
        return plantarButton;
    }

    public JButton getPlowButton() {
        return plowButton;
    }

    public JButton getStockButton() {
        return stockButton;
    }

    public void setUserNameLabelText(String userName) {
        this.userNameLabel.setText(userName);
    }

    public void setPlantedSpecieLabelText(String plantedSpecie) {
        this.plantedSpecie.setText(plantedSpecie);
    }

    public void setLuminosityLabelText(String luminosity) {
        this.luminosityLabel.setText(luminosity);
    }

    public void setHumidityLabelText(String humidity) {
        this.humidityLabel.setText(humidity);
    }

    public void setTemperatureLabelText(String temperature) {
        this.temperatureLabel.setText(temperature);
    }

    public void setPhLabelLabelText(String ph) {
        this.phLabel.setText(ph);
    }

    public void setWeatherLabelText(String weather) {
        this.weatherLabel.setText(weather);
    }

    public void setPluviometricLabelText(String pluviometric) {
        this.pluviometricLabel.setText(pluviometric);
    }

    public void setProgressBar(int val) {
        this.progressBar1.setValue(val);
    }

    public void setForecastLabel(String forecast) {
        this.forecastLabel.setText(forecast);
    }

    public void setCoverLabel(String cover) {
        this.coverLabel.setText(cover);
    }

    public void setIrrigacaoLabel(String irrigacao) {
        this.irrigacaoLabel.setText(irrigacao);
    }

    public void setMoisterLabel(String moister) {
        this.moisterLabel.setText(moister);
    }

}
