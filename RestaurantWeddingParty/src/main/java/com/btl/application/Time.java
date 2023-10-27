/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.btl.application;

/**
 *
 * @author Admin
 */
public enum Time {

    MORNING(0),
    AFTERNOON(5),
    NIGHT(15);
    private int value;

    private Time(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static Time chooseTime() {
        System.out.println("1.Buoi sang\n2.Buoi chieu\n3.Buoi toi");
        System.out.print("Moi chon thoi gian: ");
        int choose = Integer.parseInt(Configure.sc.nextLine());
        switch (choose) {
            case 1 -> {
                return Time.MORNING;
            }
            case 2 -> {
                return Time.AFTERNOON;
            }
            case 3 -> {
                return Time.NIGHT;
            }
        }
        return null;
    }

    public String getName() {
        switch (this) {
            case MORNING -> {
                return "Buoi sang\n";
            }
                case AFTERNOON -> {
                    return "Buoi chieu\n";
            }
                case NIGHT -> {
                    return "Buoi toi\n";
            }
        }
        return null;
    }

}
