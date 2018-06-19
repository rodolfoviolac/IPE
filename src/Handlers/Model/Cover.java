package Handlers.Model;

public class Cover{


    private boolean isOpen;
    private double luminosity;
    private double temperature;
    private double airHumidity;


    public Cover(){
        this.isOpen = true;

    }

    public boolean isOpen() {
        return isOpen;
    }

    public double getLuminosity() {
        return luminosity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setLuminosity(double luminosity) {
        this.luminosity = luminosity;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getAirHumidity() {
        return airHumidity;
    }

    public void setAirHumidity(double airHumidity) {
        this.airHumidity = airHumidity;
    }

    public void open() {
        this.isOpen = true;
    }

    public void close() {
        this.isOpen = false;

    }
}
