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
public class HireSinger extends Service {

    private static int id;

    private String nameSinger;

    private int amountSongs;

    {
        idService = String.format("H%03d", ++id);
        nameService = "Dich vu thue ca si";
    }

    public HireSinger(double price, String nameSinger, int amountSongs) {
        super(price);
        this.nameSinger = nameSinger;
        this.amountSongs = amountSongs;
    }

    public HireSinger() {
    }

    @Override
    public void createInfo() {
        
        System.out.print("Nhap ten ca si:");
        this.nameSinger = Configure.sc.nextLine();
        System.out.print("Nhap so luong bai hat: ");
        this.amountSongs = Integer.parseInt(Configure.sc.nextLine());
        System.out.print("Nhap gia dich vu thue ca si ");
        this.price = Double.parseDouble(Configure.sc.nextLine());

    }

    @Override
    public void showInfo() {
        System.out.printf("Ma dich vu: %s- ten dich vu:%s- Gia: %.2f-"
                + " Ten ca si:%s-So luong bai hat: %d\n", this.idService,
                this.nameService, this.price, this.nameSinger,
                this.amountSongs);
    }

    @Override
    public void updateInfo() {

        System.out.print("Cap nhat gia bai hat: ");
        this.price = Double.parseDouble(Configure.sc.nextLine());
        System.out.print("cap nhat ten ca si:");
        this.nameSinger = Configure.sc.nextLine();
        System.out.print("Cap nhat so luong bai hat: ");
        this.amountSongs = Integer.parseInt(Configure.sc.nextLine());

    }

//    @Override
//    public String displayStr() {
//        return "== Dich vu thue ca si ==";
//    }

    @Override
    public String toString() {
        return String.format("\t-Ten ca si:%s\n\t-So bai hat: %d", this.nameSinger, this.amountSongs);
    }

    /**
     * @return the id
     */
    public static int getId() {
        return id;
    }

    /**
     * @param aId the id to set
     */
    public static void setId(int aId) {
        id = aId;
    }

    /**
     * @return the nameSinger
     */
    public String getNameSinger() {
        return nameSinger;
    }

    /**
     * @param nameSinger the nameSinger to set
     */
    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    /**
     * @return the amountSongs
     */
    public int getAmountSongs() {
        return amountSongs;
    }

    /**
     * @param amountSongs the amountSongs to set
     */
    public void setAmountSongs(int amountSongs) {
        this.amountSongs = amountSongs;
    }

}
