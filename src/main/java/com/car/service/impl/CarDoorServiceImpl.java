package com.car.service.impl;

import com.car.dao.interfaces.CarDoorDao;
import com.car.lib.Inject;
import com.car.lib.Service;
import com.car.model.CarDoor;
import com.car.service.CarDoorService;
import java.util.List;

@Service
public class CarDoorServiceImpl implements CarDoorService {
    @Inject
    CarDoorDao carDoorDao;

    @Override
    public CarDoor add(CarDoor carDoor) {
        return (CarDoor) carDoorDao.add(carDoor);
    }

    @Override
    public List<CarDoor> getAll() {
        return carDoorDao.getAll();
    }
}
