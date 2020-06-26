package com.car.dao.interfaces;

import com.car.model.CarDoor;
import java.util.List;

public interface CarDoorDao {
    CarDoor add(CarDoor carDoor);

    List<CarDoor> getAll();
}
