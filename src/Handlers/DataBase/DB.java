package Handlers.DataBase;

import Handlers.DataBase.Data.FertilizerData;
import Handlers.FrameWorkUtils.ApplicationContextProvider;
import Handlers.Model.Fertilizer;

import java.util.Set;

public class DB implements DBInterface {
    FertilizerData fertilizerDb = ApplicationContextProvider.getApplicationContext().getBean("fertilizerData", FertilizerData.class);

    public Set<String> getAllFertilizer() {
        return fertilizerDb.getAllFetilizers();
    }

    public Fertilizer getFertilizerById(String index){
        return fertilizerDb.getFetilizersByIndex(index);
    }

    public boolean useFertilizer(String fertilizerName, int quantity){
        return fertilizerDb.useFertilizerQuantity(fertilizerName, quantity);
    }

}
