package sensors.humiditySensor.tests;

import org.junit.jupiter.api.Test;
import sensors.humiditySensor.handler.ValuesHandler;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HumiditySensorTest {

    @Test
    void newSensorValue() {
        ValuesHandler handler = new ValuesHandler();
        assertTrue(handler.humiditySetHandler(0));
        assertTrue(handler.humiditySetHandler(100));
        assertFalse(handler.humiditySetHandler(-5));
        assertFalse(handler.humiditySetHandler(155));
    }
}
