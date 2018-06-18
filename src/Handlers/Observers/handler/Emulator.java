package Handlers.Observers.handler;

import Handlers.FrameWorkUtils.ApplicationContextProvider;
import UI.Emulator.Controller.EmulateSensorController;

public class Emulator {
    private EmulateSensorController emulateController = ApplicationContextProvider.getApplicationContext().getBean("emulateSensorController", EmulateSensorController.class);

    public void updateEmulator(){
        emulateController.updateSensorsTextFields();
    }
}
