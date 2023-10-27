/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.dishservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class DishService {

    private List<Dish> dish = new ArrayList<>();

    public void addDish(Dish... d) {
        this.dish.addAll(Arrays.asList(d));
    }

    public void addDish(int choose) {
        switch (choose) {
            case 1 -> {
                Dish f = new Food();
                System.out.println("\t\t== Them thuc an ==");
                f.createInfo();
                this.dish.add(f);
            }
            case 2 -> {
                Dish d = new Drinks();
                System.out.println("\t\t== Them thuc uong ==");
                d.createInfo();
                this.dish.add(d);
            }
            default -> {
                break;
            }
        }
    }

    public void removeDish(Dish d) {
        this.dish.remove(d);
    }

    public void updateDish(Dish d) {
        d.updateInfo();
    }

    public Dish searchDish(String idDish) {
        return this.dish.stream().filter(d -> d.getIdDish().equals(idDish)).findFirst().get();
    }

    public List<Dish> searchTypeDish(String name) throws ClassNotFoundException {
        Class c = Class.forName(name);
        return this.dish.stream().filter(d -> c.isInstance(d) == true).collect(Collectors.toList());
    }

    public boolean isCheckById(String idDish) {
        for (Dish d : dish) {
            if (d.getIdDish().equals(idDish)) {
                return true;
            }
        }
        return false;
    }

    public void showListDish() {
        this.dish.forEach(d -> d.showInfo());
    }

    public List<Dish> getDish() {
        return dish;
    }

    public void setDish(List<Dish> dish) {
        this.dish = dish;
    }

}
