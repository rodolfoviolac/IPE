package Handlers.Model;

public class Sprinkler {


    private double pluviometricValue;
    private boolean isOn;


    public Sprinkler(){
        pluviometricValue = 0;
        isOn = false;
    }

    public double getPluviometricValue() {
        return pluviometricValue;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void setPluviometricValue(double pluviometricValue) {
        this.pluviometricValue = pluviometricValue;
    }
}
