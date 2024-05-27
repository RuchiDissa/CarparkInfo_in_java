public class Car {
    private String brand;
    private String gearbox;
    private String model;
    private String color;
    private int year;
    private int speed;

    public Car(String brand, String gearbox, String model, String color, int year, int speed) {
        this.brand = brand;
        this.gearbox = gearbox;
        this.model = model;
        this.color = color;
        this.year = year;
        this.speed = speed;
    }

    public String getBrand() {
        return brand;
    }

    public String getGearbox() {
        return gearbox;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public int getSpeed() {
        return speed;
    }
}
