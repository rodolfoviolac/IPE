package Handlers.Model;

public class Cover implements sensorUpdateValues{


    private boolean isOpen;
    private double luminosity;
    private double temperature;


    public Cover(){
        this.isOpen = true;

    }
    @Override
    public void update(String name, Double newValue) {

        if (name == "luminosity"){
            this.luminosity = newValue;
        }
        else if (name == "temperature"){
            this.temperature = newValue;
        }
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
}
