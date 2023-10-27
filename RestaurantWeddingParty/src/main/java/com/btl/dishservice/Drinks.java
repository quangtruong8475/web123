/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.dishservice;

import com.btl.application.Configure;

/**
 *
 * @author Admin
 */
public class Drinks extends Dish {

    private static int id;
    private String producer;

    {
        idDish = String.format("D%03d", ++id);
    }

    public Drinks(String nameDish, double price, String producer) {
        super(nameDish, price);
        this.producer = producer;
    }

    public Drinks() {
    }
    

    @Override
    public void createInfo() {
        System.out.print("Nhap ten thuc uong: ");
        this.nameDish = Configure.sc.nextLine();
        System.out.print("Nhap gia thuc uong: ");
        this.price = Double.parseDouble(Configure.sc.nextLine());
        System.out.print("Nhap nha san xuat: ");
        this.producer = Configure.sc.nextLine();
       
    }

    @Override
    public void updateInfo() {
        System.out.print("Nhap ten thuc uong: ");
        this.nameDish = Configure.sc.nextLine();
        System.out.print("Nhap gia thuc uong: ");
        this.price = Double.parseDouble(Configure.sc.nextLine());
        System.out.print("Nhap nha san xuat: ");
        this.producer = Configure.sc.nextLine();
    }

    @Override
    public void showInfo() {
        System.out.printf("Ma thuc uong: %s - Ten thuc uong: %s - "
                + "Gia thuc uong: %.2f - " + "Nha san xuat : %s\n", this.idDish,
                this.nameDish, this.price, this.producer);

    }

    @Override
    public String toString() {
        return "\t-" + this.nameDish;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Drinks.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public String displayStr() {
        return "== Thuc uong ==";
    }

}
