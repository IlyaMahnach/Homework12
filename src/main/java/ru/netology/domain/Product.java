package ru.netology.domain;

import lombok.Getter;

public class Product {

    @Getter
    private int id;
    @Getter
    private String name;
    private int price;


    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}


