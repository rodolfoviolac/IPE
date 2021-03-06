package Sensors.moisterSensor.tests;
import Sensors.moisterSensor.handler.ValuesHandler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoisterSensorTest {

    @Test
    void newSensorValue() {
        ValuesHandler handler = new ValuesHandler();
        assertTrue(handler.moisterSetHandler(0));
        assertTrue(handler.moisterSetHandler(100));
        assertFalse(handler.moisterSetHandler(-5));
        assertFalse(handler.moisterSetHandler(155));
    }
}
