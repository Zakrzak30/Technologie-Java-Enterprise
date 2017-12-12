package com.example.bikeshop.domain;

public class Bike {

    private String Name;
    private int Wheel;
    private String Frame;
    private double Price;

    public Bike () {

    }

    public Bike(String Name, int Wheel, String Frame, double Price) {
        this.Name = Name;
        this.Wheel = Wheel;
        this.Frame = Frame;
        this.Price = Price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getWheel() {
        return Wheel;
    }

    public void setWheel(int Wheel) {
        this.Wheel = Wheel;
    }

    public String getFrame() {
        return Frame;
    }

    public void setFrame(String Frame) {
        this.Frame = Frame;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bike bike = (Bike) o;

        if (Wheel != bike.Wheel) return false;
        if (Name != null ? !Name.equals(bike.Name) : bike.Name != null) return false;
        return Frame != null ? !Frame.equals(bike.Frame) : bike.Frame != null;
    }

    @Override
    public int hashCode() {
        int result = Name != null ? Name.hashCode() : 0;
        result = 31 * result + Wheel;
        result = 31 * result + (Frame != null ? Frame.hashCode() : 0);
        return result;
    }
}
