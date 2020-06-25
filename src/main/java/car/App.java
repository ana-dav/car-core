package car;

import java.util.ArrayList;
import java.util.List;
import car.model.Car;
import car.model.CarWheel;

public class App {
    public static void main(String[] args) {
        CarWheel carWheel = new CarWheel(0.9);
        List<CarWheel> wheels = new ArrayList();
        wheels.add(carWheel);
        Car car = new Car.CarBuilder(80)
                .setPassengers((short) 2)
                .setCurrentSpeed(65)
                .setCarWheels(wheels)
                .build();
        System.out.println(car);
    }
}
