package ui.util;

public class Car {

    public String reg;
    public  String make;
    public String model;
    public String colour;
    public String year;

    public Car(String reg, String make, String model, String colour, String year) {
        this.reg = reg;
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.year = year;
    }

    public String getReg() {
        return reg;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public String getYear() {
        return year;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
