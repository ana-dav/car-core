package com.car;

import com.car.lib.Injector;
import com.car.model.Car;
import com.car.model.CarDoor;
import com.car.model.CarWheel;
import com.car.service.CarDoorService;
import com.car.service.CarService;
import com.car.service.CarWheelService;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final Injector INJECTOR = Injector.getInstance("com.car");
    private static final CarDoorService carDoorService =
            (CarDoorService) INJECTOR.getInstance(CarDoorService.class);
    private static final CarWheelService carWheelService =
            (CarWheelService) INJECTOR.getInstance(CarWheelService.class);
    private static final CarService carService =
            (CarService) INJECTOR.getInstance(CarService.class);

    public static void main(String[] args) {
        final var door1 = new CarDoor();
        final var door2 = new CarDoor();
        final var window1 = new CarDoor();
        door2.closeDoor();
        window1.openCloseWindowAutomatic(false);
        door1.openCloseWindowAutomatic(true);
        carDoorService.add(door1);
        carDoorService.add(door2);
        carDoorService.add(window1);
        carDoorService.getAll().forEach(System.out::println);

        final var carWheel1 = new CarWheel();
        final var carWheel2 = new CarWheel();
        carWheel1.setWheelCondition(0.9);
        carWheel2.setWheelCondition(1.0);
        carWheel1.damageWheel(0.3);
        carWheel2.changeWheel(0.7);
        carWheelService.add(carWheel1);
        carWheelService.add(carWheel2);
        carWheelService.getAll().forEach(System.out::println);

        List<CarWheel> wheels = new ArrayList();
        wheels.add(carWheel1);
        wheels.add(carWheel2);
        Car car = new Car.CarBuilder(80)
                .setPassengers((short) 2)
                .setCurrentSpeed(65)
                .setCarWheels(wheels)
                .build();
        System.out.println(car);
        carService.add(car);
    }
}
