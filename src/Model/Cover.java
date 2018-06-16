package Model;

public class Cover {


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
