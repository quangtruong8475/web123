/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.weddinghall;

import com.btl.application.Configure;
import com.btl.application.IShow;

/**
 *
 * @author Admin
 */
public class WeddingHall implements IShow, Comparable<WeddingHall> {

    private static int id;
    private String idHall;
    private String nameHall;
    private int floor;
    private int capacity;
    private double initialPrice;
    private int times;

    {
        idHall = String.format("S%03d", ++id);
    }

    public WeddingHall() {
    }

    public WeddingHall(String nameHall, int floor, int capacity, double initialPrice) {

        this.nameHall = nameHall;
        this.floor = floor;
        this.capacity = capacity;
        this.initialPrice = initialPrice;
    }

    public void creatHall() {
        System.out.print("Nhap ten sanh: ");
        this.nameHall = Configure.sc.nextLine();
        System.out.print("Nhap vi tri sanh: ");
        this.floor = Integer.parseInt(Configure.sc.nextLine());
        System.out.print("Nhap so luong ban tiec: ");
        this.capacity = Integer.parseInt(Configure.sc.nextLine());
        System.out.print("Nhap gia sanh: ");
        this.initialPrice = Double.parseDouble(Configure.sc.nextLine());
    }

    public void updateHall() {
        System.out.print("Cap nhat ten sanh: ");
        this.nameHall = Configure.sc.nextLine();
        System.out.print("Cap nhat vi tri sanh: ");
        this.floor = Integer.parseInt(Configure.sc.nextLine());
        System.out.print("Cap nhat so luong ban tiec: ");
        this.capacity = Integer.parseInt(Configure.sc.nextLine());
        System.out.print("Cap nhat gia sanh: ");
        this.initialPrice = Double.parseDouble(Configure.sc.nextLine());
    }

    public void display() {
        System.out.println(String.format("%3s%20s%16d%15d%19.2f",
                this.idHall, this.nameHall, this.floor, this.capacity,
                this.initialPrice));
    }

    @Override
    public String toString() {
        return String.format("\t-Ten sanh:%s\n\t-Vi tri: %d\n\t-So luong ban: %d",
                this.nameHall, this.floor, this.capacity);
    }

    @Override
    public String displayStr() {
        return "== Sanh cuoi ==";
    }

    @Override
    public int compareTo(WeddingHall o) {
        return o.getTimes() - this.getTimes();
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        WeddingHall.id = id;
    }

    public String getIdHall() {
        return idHall;
    }

    public void setIdHall(String idHall) {
        this.idHall = idHall;
    }

    public String getNameHall() {
        return nameHall;
    }

    public void setNameHall(String nameHall) {
        this.nameHall = nameHall;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

}
