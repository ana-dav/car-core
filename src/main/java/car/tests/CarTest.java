package car.tests;

import car.model.Car;
import car.model.CarWheel;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    private List<CarWheel> wheels;
    private Car car;

    @BeforeEach
    void init() {
        wheels = new ArrayList<>();
        car = new Car.CarBuilder(80)
                .setPassengers((short) 2)
                .setCurrentSpeed(65)
                .setCarWheels(wheels)
                .build();
    }

    @Test
    public void testPutInOnePassenger() {
        init();
        car.putInOnePassenger();
        Assert.assertEquals(3, car.getPassengers());
    }

    @Test
    public void testTakeOutOnePassenger() {
        car.takeOutOnePassenger();
        Assert.assertEquals(1, car.getPassengers());
    }

    @Test
    public void testTakeOutPassengers() {
        car.takeOutPassengers();
        Assert.assertEquals(0, car.getPassengers());
    }

    @Test
    public void testAddWheels() {
        wheels.add(new CarWheel(1.0));
        wheels.add(new CarWheel(0.9));
        car.addWheels(2);
        Assert.assertEquals(4, car.getCarWheels().size());
    }

    @Test
    public void testTakeOfAllWheels() {
        wheels.add(new CarWheel(1.0));
        wheels.add(new CarWheel(0.9));
        car.takeOfAllWheels();
        Assert.assertEquals(0, car.getCarWheels().size());
    }

    @Test
    public void testGetMaxCurrentSpeed() {
        wheels.add(new CarWheel(1.0));
        wheels.add(new CarWheel(0.4));
        wheels.add(new CarWheel(0.5));
        Assert.assertEquals(0.4 * 80, car.getMaxCurrentSpeed());
        Car car1 = new Car.CarBuilder(80)
                .setPassengers((short) 0)
                .setCarWheels(wheels)
                .build();
        Assert.assertEquals(0.0, car1.getMaxCurrentSpeed());
    }
}
