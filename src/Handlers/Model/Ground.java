package Handlers.Model;

public class Ground{


    private double ph;
    private double humidity;
    private Fertilizer fertilizer;


    public Ground(){

        this.fertilizer = null;


    }

    public void setFertilizer(Fertilizer fertilizer) {
        this.fertilizer = fertilizer;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPh() {
        return ph;
    }

    public double getHumidity() {
        return humidity;
    }

    public Fertilizer getFertilizer() {
        return fertilizer;
    }
}
