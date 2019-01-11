package com.spring.dao;

import javax.persistence.*;


@Entity
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "universal_product_code",unique = true)
    private String upc;

    @Column(name = "price")
    private int price;

    @Column(name = "amounts")
    private int amounts;

    public Items() {
    }

    public Items(String name, String upc, int price, int amounts) {
        this.name = name;
        this.upc = upc;
        this.price = price;
        this.amounts = amounts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmounts() {
        return amounts;
    }

    public void setAmounts(int amounts) {
        this.amounts = amounts;
    }
}
