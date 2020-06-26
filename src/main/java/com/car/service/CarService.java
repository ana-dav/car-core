package com.car.service;

import com.car.model.Car;
import java.util.List;

public interface CarService {

    Car add(Car carWheel);

    List<Car> getAll();
}
