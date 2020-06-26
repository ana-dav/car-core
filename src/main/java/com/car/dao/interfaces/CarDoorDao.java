package com.car.dao.interfaces;

import java.util.List;
import com.car.model.CarDoor;

public interface CarDoorDao {
    CarDoor add(CarDoor carDoor);

    List<CarDoor> getAll();
}
