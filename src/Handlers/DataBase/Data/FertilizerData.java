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
        Date today = new Date();
        fertilizerDic = new HashMap<String, Fertilizer>();
        Fertilizer fertOne = new Fertilizer("FertilizerOne", "Tonin", new Date(),123);
        Fertilizer fertTwo = new Fertilizer("FertilizerTwo", "Eitaa",  new Date(today.getTime() + (1000 * 60 * 60 * 24)),22);
        Fertilizer fert3 = new Fertilizer("Fertilizer3", "aa", new Date(today.getTime() + (1000 * 60 * 60 * 180)),62);
        Fertilizer fert4 = new Fertilizer("Fertilizer4", "Da",  new Date(today.getTime() + (1000 * 60 * 60 * 64)),54);
        Fertilizer fert5 = new Fertilizer("Fertilizer7", "ZZZZZ",  new Date(today.getTime() + (1000 * 60 * 60 * 6)),24);
        Fertilizer fert6 = new Fertilizer("Fertilizer8", "adaff", new Date(today.getTime() + (1000 * 60 * 60 * 5)),79);
        Fertilizer fert7 = new Fertilizer("Fertilizer9", "oyuttt",  new Date(today.getTime() + (1000 * 60 * 60 * 64)),45);
        Fertilizer fert8= new Fertilizer("Fertilizer10", "asdqqqq",  new Date(today.getTime() + (1000 * 60 * 60 * 7)),3);
        Fertilizer fert9 = new Fertilizer("Fertilizer11", "ertert",  new Date(today.getTime() + (1000 * 60 * 60 * 154)),14);
        Fertilizer fert10 = new Fertilizer("Fertilizer12", "poipoi",  new Date(today.getTime() + (1000 * 60 * 60 * 360)),7);
        Fertilizer fert11 = new Fertilizer("Fertilizer13", "qweqwe",  new Date(today.getTime() + (1000 * 60 * 60 * 16)),5);
        Fertilizer fert12 = new Fertilizer("Fertilizer14", "zxcczxc",  new Date(today.getTime() + (1000 * 60 * 60 * 50)),88);
        Fertilizer fert13 = new Fertilizer("Fertilizer15", "bgrbgrg",  new Date(today.getTime() + (1000 * 60 * 60 * 69)),74);
        Fertilizer fert14 = new Fertilizer("Fertilizer16", "uiuiui",  new Date(today.getTime() + (1000 * 60 * 60 * 77)),45);
        Fertilizer fert15 = new Fertilizer("Fertilizer17", "12qwe", new Date(today.getTime() + (1000 * 60 * 60 * 125)),36);
        Fertilizer fert16 = new Fertilizer("Fertilizer18", "123123", new Date(today.getTime() + (1000 * 60 * 60 * 365)),34);
        Fertilizer fert17 = new Fertilizer("Fertilizer19", "aseqq651",  new Date(today.getTime() + (1000 * 60 * 60 * 9)),38);
        Fertilizer fert18 = new Fertilizer("Fertilizer20", "hgdhdfgh", new Date(today.getTime() + (1000 * 60 * 60 * 221)),4);
        Fertilizer fert19 = new Fertilizer("Fertilizer21", "tttttttttt",  new Date(today.getTime() + (1000 * 60 * 60 * 4)),2);
        this.fertilizerDic.put(fertOne.getName(), fertOne);
        this.fertilizerDic.put(fertTwo.getName(), fertTwo);
        this.fertilizerDic.put(fert3.getName(), fert3);
        this.fertilizerDic.put(fert4.getName(), fert4);
        this.fertilizerDic.put(fert5.getName(), fert5);
        this.fertilizerDic.put(fert6.getName(), fert6);
        this.fertilizerDic.put(fert7.getName(), fert7);
        this.fertilizerDic.put(fert8.getName(), fert8);
        this.fertilizerDic.put(fert9.getName(), fert9);
        this.fertilizerDic.put(fert10.getName(), fert10);
        this.fertilizerDic.put(fert11.getName(), fert11);
        this.fertilizerDic.put(fert12.getName(), fert12);
        this.fertilizerDic.put(fert13.getName(), fert13);
        this.fertilizerDic.put(fert14.getName(), fert14);
        this.fertilizerDic.put(fert15.getName(), fert15);
        this.fertilizerDic.put(fert16.getName(), fert16);
        this.fertilizerDic.put(fert17.getName(), fert17);
        this.fertilizerDic.put(fert18.getName(), fert18);
        this.fertilizerDic.put(fert19.getName(), fert19);

    }

    public Set<String> getAllFetilizers(){
        return fertilizerDic.keySet();
    }

    public Fertilizer getFetilizersByIndex(String index){
        return fertilizerDic.get(index);
    }

    public void addFetilizer(Fertilizer newFertilizer){
        this.fertilizerDic.put(newFertilizer.getName(), newFertilizer);
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

    public boolean addFertilizerQuantity(String index, int qntWantedToAdd ){
        boolean shouldReturn = false;
        if(qntWantedToAdd > 0) {
            Fertilizer fer = fertilizerDic.get(index);
            int fertilizerInStock = fer.getQuantity();
            int total = fertilizerInStock + qntWantedToAdd;
            Fertilizer fert = new Fertilizer(fer.getName(), fer.getBrand(), fer.getValid(),total);
            fertilizerDic.replace(fert.getName(),fert);
            shouldReturn = true;
        }
        return shouldReturn;
    }
}
