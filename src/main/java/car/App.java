package car;

import java.util.ArrayList;
import car.model.Car;
import car.model.CarWheel;

public class App {
    public static void main(String[] args) {
        CarWheel wheel1 = new CarWheel(0.8);
        CarWheel wheel2 = new CarWheel(0.9);
        CarWheel wheel3 = new CarWheel(1);
        ArrayList<CarWheel> wheels = new ArrayList<>();
        wheels.add(wheel1);
        wheels.add(wheel2);
        wheels.add(wheel3);
        Car car = new Car.CarBuilder(80)
                .setPassengers((short) 4)
                .setPassengers((short) 2)
                .setCurrentSpeed(65)
                .setCarWheels(wheels)
                .build();
        car.addWheels(1);
        car.getMaxCurrentSpeed();
        System.out.println(car.toString());
    }
}
