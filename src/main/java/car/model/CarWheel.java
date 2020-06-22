package car.model;

import car.exception.IllegalValueException;

public class CarWheel {
    private double wheelCondition;

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
        if (wheelCondition < 0.3)
            new CarWheel(1.0);
    }

    public void damageWheel(double damage) {
        wheelCondition -= damage;
    }

    @Override
    public String toString() {
        return "CarWheel{" +
                "wheelCondition=" + wheelCondition +
                '}';
    }
}
