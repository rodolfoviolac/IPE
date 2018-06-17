package Handlers.Model;

import java.util.Date;

public class Fertilizer {

    private String name;
    private String brand;
    private Date valid;
    private int quantity;

    public Fertilizer(String name, String brand, Date valid, int qnt){
        this.name = name;
        this.brand = brand;
        this.valid = valid;
        this.quantity = qnt;
    }

    public String getName(){
        return this.name;
    }
    public String getBrand(){
        return this.brand;
    }
    public Date getValid(){
        return this.valid;
    }
    public int getQuantity(){
        return this.quantity;
    }

}
