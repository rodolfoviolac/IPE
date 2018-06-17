package Sensors.phSensor.tests;

import org.junit.jupiter.api.Test;
import Sensors.phSensor.handler.ValuesHandler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhSensorTest {

    @Test
    void newSensorValue() {
        ValuesHandler handler = new ValuesHandler();
        assertTrue(handler.phSetHandler(0));
        assertTrue(handler.phSetHandler(14));
        assertFalse(handler.phSetHandler(-1));
        assertFalse(handler.phSetHandler(15));
    }
}
