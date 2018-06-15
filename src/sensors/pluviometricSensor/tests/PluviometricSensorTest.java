package sensors.pluviometricSensor.tests;

import org.junit.jupiter.api.Test;
import sensors.pluviometricSensor.handler.ValuesHandler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PluviometricSensorTest {

    @Test
    void newSensorValue() {
        ValuesHandler handler = new ValuesHandler();
        assertTrue(handler.pluviometricSetHandler(0));
        assertTrue(handler.pluviometricSetHandler(300));
        assertFalse(handler.pluviometricSetHandler(-1));
        assertFalse(handler.pluviometricSetHandler(301));
    }
}
