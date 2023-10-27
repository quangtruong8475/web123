/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.weddinghall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class WeddingHallService {

    private List<WeddingHall> hall = new ArrayList<>();

    public void addHall(WeddingHall... w) {
        this.hall.addAll(Arrays.asList(w));
    }

    public void removeHall(WeddingHall w) {
        this.hall.remove(w);
    }

    public void updateHall(WeddingHall w) {
        w.updateHall();
    }

    public WeddingHall searchByHall(String idHall) {
        return this.hall.stream().filter(s -> s.getIdHall().equals(idHall)).findFirst().get();
    }

    public WeddingHall searchHall(String nameHall) {
        return this.hall.stream().filter(s -> s.getNameHall().equals(nameHall)).findFirst().get();
    }

    public List<WeddingHall> searchHall(double n, double m) {
        return this.hall.stream().filter(s -> s.getCapacity() <= m && s.getCapacity() >= n).collect(Collectors.toList());
    }

    public List<WeddingHall> searchHall(int floor) {
        return this.hall.stream().filter(h -> h.getFloor() == floor).collect(Collectors.toList());
    }

    public void sort() {
        Collections.sort(this.hall);
    }

    public boolean isCheckById(String idHall) {
        for (WeddingHall w : hall) {
            if (w.getIdHall().equals(idHall)) {
                return true;
            }
        }
        return false;
    }

    public String formatStr() {
        return String.format("%3s%20s%15s%18s%15s", "Ma sanh", "Ten sanh",
                "Tang", "So ban tiec", "Gia goc(VND)");
    }

    public void showListHall() {
        System.out.println(formatStr());
        this.hall.forEach(w -> w.display());
    }

    public List<WeddingHall> getHall() {
        return hall;
    }

    public void setHall(List<WeddingHall> hall) {
        this.hall = hall;
    }

}
