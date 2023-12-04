package org.example.pecs;

public class Apple extends Product{

    private String color;

    public Apple(String name, double price, String color) {
        super(name, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + getName() + '\'' +
                "price='" + getPrice() + '\'' +
                "color='" + color + '\'' +
                '}';
    }
}
