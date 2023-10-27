/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.dishservice;

import com.btl.application.IShow;

/**
 *
 * @author Admin
 */
public abstract class Dish implements IShow {

    protected String idDish;
    protected String nameDish;
    protected double price;

    public abstract void createInfo();

    public abstract void updateInfo();

    public abstract void showInfo();

    public Dish(String nameDish, double price) {
        this.nameDish = nameDish;
        this.price = price;
    }

    public Dish() {
    }

    public String getIdDish() {
        return idDish;
    }

    public void setIdDish(String idDish) {
        this.idDish = idDish;
    }

    public String getNameDish() {
        return nameDish;
    }

    public void setNameDish(String nameDish) {
        this.nameDish = nameDish;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
