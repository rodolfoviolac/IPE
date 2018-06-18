package Handlers.DataBase;

import Handlers.DataBase.Data.FertilizerData;
import Handlers.DataBase.Data.UserData;
import Handlers.FrameWorkUtils.ApplicationContextProvider;
import Handlers.Model.Fertilizer;
import Handlers.Model.User;

import java.util.Set;

public class DB implements DBInterface {
    FertilizerData fertilizerDb = ApplicationContextProvider.getApplicationContext().getBean("fertilizerData", FertilizerData.class);
    UserData userDb = ApplicationContextProvider.getApplicationContext().getBean("userData", UserData.class);

    public Set<String> getAllFertilizer() {
        return fertilizerDb.getAllFetilizers();
    }

    public Fertilizer getFertilizerById(String index){
        return fertilizerDb.getFetilizersByIndex(index);
    }

    public void addNewFetilizer(Fertilizer newFertilizer){
        fertilizerDb.addFetilizer(newFertilizer);
    }

    public boolean useFertilizer(String fertilizerName, int quantity){
        return fertilizerDb.useFertilizerQuantity(fertilizerName, quantity);
    }

    public boolean buyFertilizer(String fertilizerName, int quantity){
        return fertilizerDb.addFertilizerQuantity(fertilizerName, quantity);
    }

    public void setLogedUser(User user){
        userDb.setLogedUser(user);
    }

    public User getLogedUser(){
        return userDb.getLogedUser();
    }

}
