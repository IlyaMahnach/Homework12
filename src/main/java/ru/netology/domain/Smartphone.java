package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Smartphone extends Product {
    private String Manufacturer;

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        Manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }
}