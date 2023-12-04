package org.example.pecs;

public class BigApple extends Apple{

    private int weight;

    public BigApple(String name, double price, String color, int weight) {
        super(name, price, color);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "BigApple{" +
                "name='" + getName() + '\'' +
                "price='" + getPrice() + '\'' +
                "weight=" + weight +
                '}';
    }
}
