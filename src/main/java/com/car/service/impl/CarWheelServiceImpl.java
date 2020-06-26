package com.car.service.impl;

import com.car.dao.interfaces.CarWheelDao;
import com.car.lib.Inject;
import com.car.lib.Service;
import com.car.model.CarWheel;
import com.car.service.CarWheelService;
import java.util.List;

@Service
public class CarWheelServiceImpl implements CarWheelService {
    @Inject
    CarWheelDao carWheelDao;

    @Override
    public CarWheel add(CarWheel carWheel) {
        return (CarWheel) carWheelDao.add(carWheel);
    }

    @Override
    public List<CarWheel> getAll() {
        return carWheelDao.getAll();
    }
}
