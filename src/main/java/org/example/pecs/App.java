package org.example.pecs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        String[] cities = new String[] {"Moscow", "Minsk"};
        Integer[] years = new Integer[] {1990, 1991};

        //foo(years);
        //Object[] objects = cities;
        //objects[1] = 2;

        List<Product> products = new ArrayList<>();
        products.add(new Apple("apple1", 1.0, "red"));
        products.add(new BigApple("apple1", 1.0, "red", 200));
        products.add(new Product("product1", 2.0));
        products.add(new Book("book1", 2.0, LocalDateTime.now()));

        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("apple2", 1.0, "red"));
        apples.add(new BigApple("apple2", 1.0, "red", 200));

        //products = apples;
        List<? extends Product> anyProductList = apples;
        foo2(apples);

    }

    // ? extends T
    // ? super T

    public static void foo3(List<? super Apple> products) {
        products.add(new Apple("apple1", 1.0, "red"));
        products.add(new BigApple("apple1", 1.0, "red", 200));
        // products.add(new Product("product1", 2.0));
        // products.add(new Book("book1", 2.0, LocalDateTime.now()));
    }

    public static void foo2(List<? extends Product> products) {
        for (Product item: products) {
            System.out.println("item name:" + item.getName() + " item: " + item.getPrice());
        }
    }

    public static void foo(Object[] list) {
        for (Object item: list) {
            System.out.println("item: " + item);
        }
    }
}
