package com.car.service.impl;

import com.car.dao.interfaces.CarDao;
import com.car.lib.Inject;
import com.car.lib.Service;
import com.car.model.Car;
import com.car.service.CarService;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Inject
    CarDao carDao;

    @Override
    public Car add(Car car) {
        return (Car) carDao.add(car);
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }
}
