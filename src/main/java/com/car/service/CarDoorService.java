package com.car.service;

import com.car.model.CarDoor;
import java.util.List;

public interface CarDoorService {
    CarDoor add(CarDoor carDoor);

    List<CarDoor> getAll();
}
