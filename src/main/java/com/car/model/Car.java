package com.car.model;

import com.car.exception.IllegalValueException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true, length = 11)
    private Long id;
    private String dateCreated;
    private int maxSpeed;
    private int accelerateSpeed;
    private String engine;
    private short passengersCapacity;
    private short passengers;
    private int currentSpeed;
    @OneToMany
    private List<CarWheel> carWheels;
    @OneToMany
    private List<CarDoor> carDoors;

    private Car(CarBuilder carBuilder) {
        this.dateCreated = carBuilder.dateCreated;
        this.maxSpeed = carBuilder.maxSpeed;
        this.accelerateSpeed = carBuilder.accelerateSpeed;
        this.engine = carBuilder.engine;
        this.passengersCapacity = carBuilder.passengersCapacity;
        this.passengers = carBuilder.passengers;
        this.currentSpeed = carBuilder.currentSpeed;
        this.carWheels = carBuilder.carWheels;
        this.carDoors = carBuilder.carDoors;
    }

    public static class CarBuilder {
        private Long id;
        private LocalDateTime producedDate = LocalDateTime.now();
        String dateCreated = producedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        private int maxSpeed;
        private int accelerateSpeed;
        private String engine;
        private short passengersCapacity;
        private short passengers;
        private int currentSpeed;
        private List<CarWheel> carWheels;
        private ArrayList<CarDoor> carDoors;

        public CarBuilder(int maxSpeed) {
            setDateCreated(dateCreated);
            this.maxSpeed = maxSpeed;
            this.id = id;
        }

        private CarBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        private CarBuilder setDateCreated(String dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public CarBuilder setAccelerateSpeed(int accelerateSpeed) {
            this.accelerateSpeed = accelerateSpeed;
            if (accelerateSpeed < 0 || accelerateSpeed > 100) {
                throw new IllegalValueException("Please insert correct speed");
            }
            return this;
        }

        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder setPassengersCapacity(short passengersCapacity) {
            this.passengersCapacity = passengersCapacity;
            return this;
        }

        public CarBuilder setPassengers(short passengers) {
            this.passengers = passengers;
            return this;
        }

        public CarBuilder setCurrentSpeed(int currentSpeed) {
            this.currentSpeed = currentSpeed;
            return this;
        }

        public CarBuilder setCarWheels(List<CarWheel> carWheels) {
            this.carWheels = carWheels;
            return this;
        }

        public CarBuilder setCarDoors(ArrayList<CarDoor> carDoors) {
            this.carDoors = carDoors;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getAccelerateSpeed() {
        return accelerateSpeed;
    }

    public String getEngine() {
        return engine;
    }

    public short getPassengersCapacity() {
        return passengersCapacity;
    }

    public short getPassengers() {
        return passengers;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public List<CarWheel> getCarWheels() {
        return carWheels;
    }

    public List<CarDoor> getCarDoors() {
        return carDoors;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void putInOnePassenger() {
        this.passengers++;
    }

    public void takeOutOnePassenger() {
        this.passengers--;
    }

    public void takeOutPassengers() {
        this.passengers = 0;
    }

    public CarDoor getCarDoorByIndex(int index) {
        return carDoors.get(index);
    }

    public CarWheel getCarWheelByIndex(int index) {
        return carWheels.get(index);
    }

    public void takeOfAllWheels() {
        carWheels.clear();
    }

    public void addWheels(int wheelsNumber) {
        for (int i = 0; i < wheelsNumber; i++) {
            carWheels.add(new CarWheel(1));
        }
    }

    public double getMaxCurrentSpeed() {
        var worseWheelCondition = carWheels.get(0).getWheelCondition();
        for (CarWheel carWheel : carWheels) {
            worseWheelCondition = Math.min(worseWheelCondition, carWheel.getWheelCondition());
        }
        return passengers > 0 ? maxSpeed * worseWheelCondition : 0;
    }

    @Override
    public String toString() {
        return "Car{" 
                + "dateCreated='" + dateCreated + '\''
                + ", maxSpeed=" + maxSpeed 
                + ", accelerateSpeed=" + accelerateSpeed 
                + ", engine='" + engine + '\'' 
                + ", passengersCapacity=" + passengersCapacity 
                + ", passengers=" + passengers 
                + ", currentSpeed=" + currentSpeed 
                + ", carWheels=" + carWheels 
                + ", carDoors=" + carDoors 
                + ", MaxCurrentSpeed=" + getMaxCurrentSpeed() 
                + '}';
    }
}
