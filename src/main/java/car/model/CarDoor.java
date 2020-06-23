package car.model;

public class CarDoor {
    private String door;
    private String window;
    private boolean doorIsOpen;
    private boolean windowIsOpen;

    public CarDoor(boolean doorIsOpen, boolean windowIsOpen) {
        this.doorIsOpen = doorIsOpen;
        this.windowIsOpen = windowIsOpen;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public boolean isDoorIsOpen() {
        return doorIsOpen;
    }

    public void setDoorIsOpen(boolean doorIsOpen) {
        this.doorIsOpen = doorIsOpen;
    }

    public boolean isWindowIsOpen() {
        return windowIsOpen;
    }

    public void setWindowIsOpen(boolean windowIsOpen) {
        this.windowIsOpen = windowIsOpen;
    }

    public void openDoor() {
        doorIsOpen = true;
    }

    public void closeDoor() {
        doorIsOpen = false;
    }

    public void openCloseDoorAutomatic(boolean doorIsOpen) {
        if (doorIsOpen) {
            closeDoor();
        } else {
            openDoor();
        }
    }

    public void openWindow() {
        windowIsOpen = true;
    }

    public void closeWindow() {
        windowIsOpen = false;
    }

    public void openCloseWindowAutomatic(boolean windowIsOpen) {
        if (windowIsOpen) {
            closeWindow();
        } else {
            openWindow();
        }
    }

    @Override
    public String toString() {
        return "CarDoor{"
                + "door='" + door + '\''
                + ", window='" + window + '\''
                + '}';
    }
}
