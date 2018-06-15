package sensors.temperatureSensor.tests;

import org.junit.jupiter.api.Test;
import sensors.temperatureSensor.handler.ValuesHandler;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TemperatureSensorTest {

    @Test
    void newSensorValue() {
        ValuesHandler handler = new ValuesHandler();
        assertTrue(handler.temperatureSetHandler(0));
        assertTrue(handler.temperatureSetHandler(100));
        assertFalse(handler.temperatureSetHandler(-8));
        assertFalse(handler.temperatureSetHandler(124));
    }
}
