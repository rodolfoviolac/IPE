package Handlers.Observers;

import Handlers.Observers.handler.Stock;

public class Observers implements ObserversInterface {

    public void updateStockFormTextFields(){
        Stock stock = new Stock();
        stock.updateStock();
    }

}
