package Handlers.Model;

public class Ground implements sensorUpdateValues{


    private double ph;
    private double humidity;
    private Fertilizer fertilizer;

    @Override
    public void update(String name, Double newValue) {
        if (name == "ph"){
            this.ph = newValue;
        }
        else if (name == "humidity"){
            this.humidity = newValue;
        }
    }
}