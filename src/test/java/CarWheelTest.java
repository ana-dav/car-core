import static org.junit.jupiter.api.Assertions.assertThrows;

import car.exception.IllegalValueException;
import car.model.CarWheel;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class CarWheelTest {
    CarWheel wheel = new CarWheel(1.0);

    @Test
    public void testSetWheelCondition() {
        wheel.setWheelCondition(0.3);
        Assert.assertEquals(0.3, wheel.getWheelCondition());
    }

    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {
        assertThrows(IllegalValueException.class, () -> wheel.setWheelCondition(1.3));
    }

    @Test
    public void testDamageWheel() {
        wheel.setWheelCondition(0.7);
        wheel.damageWheel(0.1);
        Assert.assertEquals(0.6, wheel.getWheelCondition());
    }
}
