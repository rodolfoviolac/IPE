package sensors.luminositySensor.tests;

import org.junit.jupiter.api.Test;
import sensors.luminositySensor.handler.ValuesHandler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LuminositySensorTest {

    @Test
    void newSensorValue() {
        ValuesHandler handler = new ValuesHandler();
        assertTrue(handler.luminositySetHandler(0));
        assertTrue(handler.luminositySetHandler(24));
        assertFalse(handler.luminositySetHandler(-1));
        assertFalse(handler.luminositySetHandler(25));
    }
}
