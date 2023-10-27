/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service;

import com.btl.application.Configure;

/**
 *
 * @author Admin
 */
public class Karaoke extends Service {

    private static int id;
    private double rentalPeriod;

    {
        idService = String.format("K%03d", ++id);
        nameService = "Dich vu Karaoke";
    }

    public Karaoke(double price, double rentalPeriod) {
        super(price);
        this.rentalPeriod = rentalPeriod;
    }

    public Karaoke() {
    }

    @Override
    public void createInfo() {     
        System.out.print("Nhap  thoi gian  hat: ");
        this.rentalPeriod = Double.parseDouble(Configure.sc.nextLine());
        System.out.print("Nhap gia dich vu Karaoke ");
        this.price = Double.parseDouble(Configure.sc.nextLine());
    }

    @Override
    public void updateInfo() {

        System.out.print("Cap nhat gia cho thue: ");
        this.price = Double.parseDouble(Configure.sc.nextLine());
        System.out.print("cap nhat thoi gian cho thue: ");
        this.rentalPeriod = Double.parseDouble(Configure.sc.nextLine());

    }

    @Override
    public void showInfo() {
        System.out.printf("Ma Phong:%s-Ten Dich Vu:%s-Gia Bai Hat"
                + ":%.2f-Gio Thue:%f\n", this.idService,
                this.nameService, this.price, this.rentalPeriod);
    }

//    @Override
//    public String displayStr() {
//        return "== Dich vu Karaoke ==";
//    }

    @Override
    public String toString() {
        return "\t-So gio hat: " + this.rentalPeriod;
    }

}
