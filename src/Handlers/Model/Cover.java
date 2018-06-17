package Handlers.Model;

public class Cover implements sensorUpdateValues{


    private boolean isOpen;
    private double luminosity;
    private double temperature;


    @Override
    public void update(String name, Double newValue) {
        if (name == "luminosity"){
            this.luminosity = newValue;
        }
        else if (name == "temperature"){
            this.temperature = newValue;
        }
    }

}
