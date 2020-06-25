import car.model.CarDoor;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;

public class CarDoorTest {
    CarDoor doorAndWindow = new CarDoor(true, true);

    @Test
    public void testOpenCloseDoorAutomatic() {
        doorAndWindow.openCloseDoorAutomatic(true);
        Assert.assertFalse(doorAndWindow.isDoorIsOpen());
    }

    @Test
    public void testOpenCloseWindowAutomatic() {
        doorAndWindow.openCloseWindowAutomatic(false);
        Assert.assertTrue(doorAndWindow.isDoorIsOpen());
    }

}
