package Handlers.DataBase.Data;

import Handlers.Model.Fertilizer;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;

@Scope(value = "singleton")
@Component
public class FertilizerData {

    private Map<String, Fertilizer> fertilizerDic;

    public FertilizerData(){
        downLoadFerltilizerFromSource();
    }

    private void downLoadFerltilizerFromSource() {
        fertilizerDic = new HashMap<String, Fertilizer>();
        Fertilizer fertOne = new Fertilizer("FertilizerOne", "Tonin", new Date(),123);
        Fertilizer fertTwo = new Fertilizer("FertilizerTwo", "Eitaa", new Date(),1);
        Fertilizer fert3 = new Fertilizer("Fertilizer3", "aa", new Date(),765);
        Fertilizer fert4 = new Fertilizer("Fertilizer4", "Da", new Date(),54);
        Fertilizer fert5 = new Fertilizer("Fertilizer5", "ZZZZZ", new Date(),17);
        this.fertilizerDic.put(fertOne.getName(), fertOne);
        this.fertilizerDic.put(fertTwo.getName(), fertTwo);
        this.fertilizerDic.put(fert3.getName(), fert3);
        this.fertilizerDic.put(fert4.getName(), fert4);
        this.fertilizerDic.put(fert5.getName(), fert5);
    }

    public Set<String> getAllFetilizers(){
        return fertilizerDic.keySet();
    }

    public Fertilizer getFetilizersByIndex(String index){
        return fertilizerDic.get(index);
    }

    public boolean useFertilizerQuantity(String index, int qntWantedToRemove ){
        boolean shouldReturn = false;
       Fertilizer fer = fertilizerDic.get(index);
       int fertilizerInStock = fer.getQuantity();
       if(fertilizerInStock > qntWantedToRemove){
           int total = fertilizerInStock - qntWantedToRemove;
           Fertilizer fert = new Fertilizer(fer.getName(), fer.getBrand(), fer.getValid(),total);
           fertilizerDic.replace(fert.getName(),fert);
           shouldReturn = true;
       }
        return shouldReturn;

    }
}
