/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service;

import com.btl.application.IShow;

/**
 *
 * @author Admin
 */
public abstract class Service implements IShow {

    protected String idService;

    protected String nameService;

    protected double price;

    public abstract void createInfo();

    public abstract void updateInfo();

    public abstract void showInfo();

    public Service(double price) {

        this.price = price;
    }

    public Service() {
    }

    @Override
    public String displayStr() {
        return this.getNameService();
    }

    /**
     * @return the idService
     */
    public String getIdService() {
        return idService;
    }

    /**
     * @param idService the idService to set
     */
    public void setIdService(String idService) {
        this.idService = idService;
    }

    /**
     * @return the nameService
     */
    public String getNameService() {
        return nameService;
    }

    /**
     * @param nameService the nameService to set
     */
    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

}
