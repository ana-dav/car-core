package com.car.service;

import com.car.model.CarWheel;
import java.util.List;

public interface CarWheelService {
    CarWheel add(CarWheel carWheel);

    List<CarWheel> getAll();
}

