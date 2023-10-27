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
public class Food extends Dish {

    private static int id;

    private boolean isVegetarian;

    {
        idDish = String.format("F%03d", ++id);
    }

    public Food(String nameDish, double price, boolean isVegetarian) {
        super(nameDish, price);
        this.isVegetarian = isVegetarian;
    }

    public Food() {

    }

    @Override
    public void createInfo() {
        System.out.print("Nhap ten thuc an: ");
        this.nameDish = Configure.sc.nextLine();
        System.out.print("Nhap gia thuc an: ");
        this.price = Double.parseDouble(Configure.sc.nextLine());
        System.out.print("Co phai mon chay(1:0)");
        int choose = Integer.parseInt(Configure.sc.nextLine());
        this.isVegetarian = choose == 1;

    }

    @Override
    public void updateInfo() {
        System.out.print("Nhap ten thuc an: ");
        this.nameDish = Configure.sc.nextLine();
        System.out.print("Nhap gia thuc an: ");
        this.price = Double.parseDouble(Configure.sc.nextLine());
        System.out.print("Co phai mon chay(1:0)");
        int choose = Integer.parseInt(Configure.sc.nextLine());
        this.isVegetarian = choose == 1;
        //System.out.println("Chinh sua mon an thanh cong.");

    }

    @Override
    public void showInfo() {
        System.out.printf("Ma mon an: %s - Ten mon an: %s - "
                + "Gia mon an: %.2f -" + " Mo ta : %s\n", this.idDish,
                this.nameDish, this.price, this.isVegetarian);

    }

    @Override
    public String displayStr() {
        return "== Thuc an ==";
    }

    @Override
    public String toString() {
        return "\t-" + this.nameDish;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Food.id = id;
    }

    public boolean isIsVegetarian() {
        return isVegetarian;
    }

    public void setIsVegetarian(boolean isVegetarian) {
        this.isVegetarian = isVegetarian;
    }

}
