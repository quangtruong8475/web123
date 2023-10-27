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
public class Perspective extends Service {

    private static int id;

    {
        idService = String.format("P%03d", ++id);
        nameService = "Dich vu trang tri phoi canh";
    }

    public Perspective(double price) {
        super(price);
    }

    public Perspective() {
    }

    @Override
    public void createInfo() {
        System.out.print("Nhap gia dich vu trang tri");
        this.price = Double.parseDouble(Configure.sc.nextLine());
    }

    @Override
    public void updateInfo() {

        System.out.print("Cap nhat gia san pham trang tri: ");
        this.price = Double.parseDouble(Configure.sc.nextLine());
    }

    @Override
    public void showInfo() {
        System.out.printf("Ma trang tri: %s - Ten dich vu: %s - "
                + "Gia san pham: %.2f -\n", this.idService,
                this.nameService, this.price);
    }

//    @Override
//    public String displayStr() {
//        return "== Dich vu trang tri phoi canh ==";
//    }
    @Override
    public String toString() {
        return "";
    }

}
