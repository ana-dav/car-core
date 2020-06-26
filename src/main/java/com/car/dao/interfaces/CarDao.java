package com.car.dao.interfaces;

import java.util.List;
import com.car.model.Car;

public interface CarDao {
    Car add(Car car);

    List<Car> getAll();
}
