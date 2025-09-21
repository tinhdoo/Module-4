package com.codegym.entity;

import javax.persistence.*;

@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Integer id;
    @Column(name = "name_product")
    private String name;
    @Column(name= "price_product")
    private Double price;
    @Column(name= "describe_product")
    private String describe;
    @Column(name= "manufacturer")
    private String manufacturer;

    public Product() {
    }

    public Product(int id, String name, double price, String describe, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describe = describe;
        this.manufacturer = manufacturer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
