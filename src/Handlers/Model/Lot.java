package Handlers.Model;


import Handlers.Enum.PlantSpecies;
import Handlers.Enum.PlotStatus;
import UI.Emulator.Controller.EmulateSensorController;
import UI.Emulator.Controller.PlotInterface;
import UI.Info.Controller.InfoController;

import java.util.concurrent.TimeUnit;

public class Lot implements PlotInterface {


    private int ID;
    private double area;
    private PlantSpecies plantedSpecie;
    private PlotStatus status;
    private Ground ground;
    private Cover cover;
    private Sprinkler sprinkler;
    private String weather;
    private String forecast;
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

    public Lot(){

        this.ID = 1;
        this.area = 1000;
        this.status = PlotStatus.readyToPlant;
        this.plantedSpecie = PlantSpecies.Nenhum;
        this.weather = "";
        this.forecast = "";
        this.ground = new Ground();
        this.sprinkler = new Sprinkler();
        this.cover = new Cover();

    }

    public String getCoverStatus(){

        if (cover.isOpen()){
            return "Aberto";
        }
        else{
            return "Fechado";
        }
    }

    public String getSprinklerStatus(){
        if (sprinkler.isOn()){
            return "Ligado";
        }
        else{
            return "Desligado";
        }
    }

    public double getLuminosityValue(){

        return this.cover.getLuminosity();
    }

    public double getMoisterValue(){

        return this.ground.getHumidity();
    }

    public double getAirHumidityValue(){


        return this.cover.getAirHumidity();

    }

    public double getPluviometricValue(){

        return this.sprinkler.getPluviometricValue();

    }

    public double getTemperatureValue(){

        return this.cover.getTemperature();
    }

    public String getWeather(){

        return this.weather;
    }

    public double getGroundPHValue(){

        return this.ground.getPh();
    }

    public String getForecast() {
        return forecast;
    }

    public void checkCoverNeed(){

        if (cover.getTemperature() > 25 || cover.getLuminosity() > 16){
            cover.close();
        }
        else{
            if (!cover.isOpen()){
                cover.open();
                this.updateLabels();
            }
        }
    }

    public void checkWaterNeed() throws InterruptedException {

        if (sprinkler.getPluviometricValue() < 100 && cover.getTemperature() > 32){
            this.sprinkler.turnOn();
            this.updateLabels();
            TimeUnit.SECONDS.sleep(5);
            this.sprinkler.setPluviometricValue(250);
            this.sprinkler.turnOff();
            this.updateLabels();

        }

    }

    public void harvest(){

        this.plantedSpecie = PlantSpecies.Nenhum;
        this.status = PlotStatus.readyToPlow;
        this.updateLabels();

    }

    public void plant(PlantSpecies specie){

        this.status = PlotStatus.readyToHarvest;
        this.plantedSpecie = specie;
        this.updateLabels();

    }

    public void plow(Fertilizer usedFertilizer){
        this.status = PlotStatus.readyToPlant;
        this.ground.setFertilizer(usedFertilizer);

    }



    @Override
    public void updateLuminosity(double newValue) {

        this.cover.setLuminosity(newValue);
        this.checkCoverNeed();
    }

    @Override
    public void updatePH(double newValue) {
        this.ground.setPh(newValue);
    }

    @Override
    public void updateHumidity(double newValue) {

        this.cover.setAirHumidity(newValue);

    }

    @Override
    public void updateTemperature(double newValue) {

        this.cover.setTemperature(newValue);
        this.checkCoverNeed();
        try {
            this.checkWaterNeed();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateWeather(String newValue) {

        this.weather = newValue;


    }

    @Override
    public void updateMoister(double newValue) {

        ground.setHumidity(newValue);


    }

    @Override
    public void updatePluviometric(double newValue) {

        this.sprinkler.setPluviometricValue(newValue);
        try {
            this.checkWaterNeed();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateForcast(String newValue) {
        this.forecast = newValue;
    }

    @Override
    public void updateLabels() {

        this.infoDelegate.updateLabels();
    }

    public void setInfoDelegate(InfoInterface infoController) {
        this.infoDelegate = infoController;

    }

}
