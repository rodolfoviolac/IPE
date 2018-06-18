package Handlers.Observers.handler;

import Handlers.FrameWorkUtils.ApplicationContextProvider;
import UI.Stock.Controller.StockController;

public class Stock {
    private StockController stockController = ApplicationContextProvider.getApplicationContext().getBean("stockController", StockController.class);

    public void updateStock(){
        stockController.updateTextFields();
    }
}
