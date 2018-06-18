package Handlers.Observers;

import Handlers.Observers.handler.Emulator;
import Handlers.Observers.handler.Info;
import Handlers.Observers.handler.Stock;

public class Observers implements ObserversInterface {

    public void updateInfoFormTextFields(){
        Info info = new Info();
        info.updateInfo();
    }

    public void updateStockFormTextFields(){
        Stock stock = new Stock();
        stock.updateStock();
    }

    public void updateEmulateFormTextFields(){
        Emulator emulator = new Emulator();
        emulator.updateEmulator();
    }

    public void syncAllTextFields(){
        updateEmulateFormTextFields();
        updateStockFormTextFields();
        updateInfoFormTextFields();
    }
}
