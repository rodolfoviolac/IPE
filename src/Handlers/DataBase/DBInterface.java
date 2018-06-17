package Handlers.DataBase;

import Handlers.Model.Fertilizer;

import java.util.Set;

public interface DBInterface {
    Set<String> getAllFertilizer();
    Fertilizer getFertilizerById(String index);
    boolean useFertilizer(String fertilizerName, int quantity);
    void addNewFetilizer(Fertilizer newFertilizer);
    boolean buyFertilizer(String fertilizerName, int quantity);
}