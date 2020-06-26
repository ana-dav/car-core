package com.car.dao.interfaces;

import java.util.List;
import com.car.model.CarWheel;

public interface CarWheelDao {

    CarWheel add(CarWheel carWheel);

    List<CarWheel> getAll();
}
