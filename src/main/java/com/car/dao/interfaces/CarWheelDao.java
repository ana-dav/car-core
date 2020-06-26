package com.car.dao.interfaces;

import com.car.model.CarWheel;
import java.util.List;

public interface CarWheelDao {

    CarWheel add(CarWheel carWheel);

    List<CarWheel> getAll();
}
