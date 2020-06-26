package com.car.dao.interfaces;

import com.car.model.Car;
import java.util.List;

public interface CarDao {
    Car add(Car car);

    List<Car> getAll();
}
