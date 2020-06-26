package com.car.service;

import java.util.List;
import com.car.model.Car;

public interface CarService {

    Car add(Car carWheel);

    List<Car> getAll();
}
