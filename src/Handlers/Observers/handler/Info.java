package Handlers.Observers.handler;

import Handlers.FrameWorkUtils.ApplicationContextProvider;
import UI.Info.Controller.InfoController;

public class Info {
    private InfoController infoController = ApplicationContextProvider.getApplicationContext().getBean("infoController", InfoController.class);

    public void updateInfo(){
        infoController.updater();
    }

}
