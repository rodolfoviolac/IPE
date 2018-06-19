package Handlers.Model;


import Handlers.Enum.PlantSpecies;
import Handlers.Enum.PlotStatus;
import UI.Emulator.Controller.EmulateSensorController;
import UI.Emulator.Controller.PlotInterface;
import UI.Info.Controller.InfoController;

public class Plot implements PlotInterface {


    private int ID;
    private double area;
    private PlantSpecies plantedSpecie;
    private PlotStatus status;
    private Ground ground;
    private Cover cover;
    private Sprinkler sprinkler;
    private String weather;
    private InfoInterface infoDelegate;

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
        this.infoDelegate.updateLabels();

    }

    public void plow(Fertilizer usedFertilizer){
        this.status = PlotStatus.readyToPlant;
        this.ground.setFertilizer(usedFertilizer);
    }


    @Override
    public void updateLuminosity(double newValue) {

        this.cover.setLuminosity(newValue);
        this.infoDelegate.updateLabels();
    }

    @Override
    public void updatePH(double newValue) {
        this.ground.setPh(newValue);
        this.infoDelegate.updateLabels();
    }

    @Override
    public void updateHumidity(double newValue) {

        this.cover.setAirHumidity(newValue);
        this.infoDelegate.updateLabels();

    }

    @Override
    public void updateTemperature(double newValue) {

        this.cover.setTemperature(newValue);
        this.infoDelegate.updateLabels();

    }

    @Override
    public void updateWeather(String newValue) {

        this.weather = newValue;
        this.infoDelegate.updateLabels();


    }

    @Override
    public void updateMoister(double newValue) {

        ground.setHumidity(newValue);
        this.infoDelegate.updateLabels();


    }

    @Override
    public void updatePluviometric(double newValue) {

        this.sprinkler.setPluviometricValue(newValue);
        this.infoDelegate.updateLabels();

    }

    public void setInfoDelegate(InfoInterface infoController) {
        this.infoDelegate = infoController;

    }
}
