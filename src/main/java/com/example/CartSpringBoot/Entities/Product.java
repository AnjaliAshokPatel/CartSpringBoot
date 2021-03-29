package com.example.CartSpringBoot.Entities;

public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;

        if(this.price < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
