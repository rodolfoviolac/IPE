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

    public int getID() {
        return ID;
    }

    public double getArea() {
        return area;
    }

    public PlantSpecies getPlantedSpecie() {
        return plantedSpecie;
    }

    public PlotStatus getStatus() {
        return status;
    }

    public Plot(){

        this.ID = 1;
        this.area = 1000;
        this.status = PlotStatus.readyToPlant;
        this.plantedSpecie = PlantSpecies.Nenhum;
        this.ground = new Ground();
        this.cover = new Cover();

    }

    public double getLuminosity(){

        return cover.getLuminosity();
    }

    public void cover(){


    }

    public void prepareGround(){


    }

    public void harvest(){

        this.plantedSpecie = PlantSpecies.Nenhum;
        this.status = PlotStatus.readyToPlow;
    }

    public void plant(PlantSpecies specie){

        this.status = PlotStatus.readyToHarvest;
        this.plantedSpecie = specie;
    }

    public void plow(Fertilizer usedFertilizer){
        this.status = PlotStatus.readyToPlant;
        this.ground.setFertilizer(usedFertilizer);
    }


}
