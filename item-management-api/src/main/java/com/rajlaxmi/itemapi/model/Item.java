package com.rajlaxmi.itemapi.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Item {

    private int id;

    @NotBlank(message = "Name is required")
    private String name;

    @Min(value = 1, message = "Price must be greater than 0")
    private double price;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
