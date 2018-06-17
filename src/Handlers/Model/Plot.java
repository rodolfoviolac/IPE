package Handlers.Model;


import Handlers.Enum.PlantSpecies;
import Handlers.Enum.PlotStatus;

public class Plot {


    private int ID;
    private double area;
    private PlantSpecies plantedSpecie;
    private PlotStatus status;
    private Ground ground;
    private Cover cover;


    public Plot(){

        this.ID = 1;
        this.area = 1000;
        this.plantedSpecie = PlantSpecies.none;
        this.ground = new Ground();
        this.cover = new Cover();

    }

    public void cover(){


    }

    public void prepareGround(){


    }

}
