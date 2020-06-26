package com.car.model;

import com.car.exception.IllegalValueException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CarWheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true, length = 11)
    private Long id;
    private double wheelCondition;

    public CarWheel() {

    }

    public CarWheel(double wheelCondition) {
        this.wheelCondition = wheelCondition;
    }

    public double getWheelCondition() {
        return wheelCondition;
    }

    public void setWheelCondition(double wheelCondition) {
        this.wheelCondition = wheelCondition;
        if (wheelCondition < 0 || wheelCondition > 1) {
            throw new IllegalValueException("The value should be between 0 and 1");
        }
    }

    public void changeWheel(double wheelCondition) {
        if (wheelCondition < 0.3) {
            new CarWheel(1.0);
        }
    }

    public void damageWheel(double damage) {
        wheelCondition -= damage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CarWheel{"
                + "wheelCondition=" + wheelCondition
                + '}';
    }
}
