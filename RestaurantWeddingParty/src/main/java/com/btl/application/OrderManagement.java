/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.application;

import com.btl.dishservice.Dish;
import com.btl.dishservice.DishService;
import com.btl.service.Service;
import com.btl.service.ServiceManagement;
import com.btl.weddinghall.WeddingHallService;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderManagement {

    private List<OrderService> order = new ArrayList<>();

    public void addOrder(OrderService... a) {
        this.order.addAll(Arrays.asList(a));
    }

    public void addOrder(WeddingHallService hall, DishService dish, ServiceManagement service) throws ParseException {
        OrderService o = new OrderService();
        o.orderWedding(hall, dish, service);
        this.order.add(o);
    }

    public OrderService searchName(String nameParty) {
        return this.order.stream().filter(o -> o.getNameWedding().equals(nameParty)).findFirst().get();
    }

    public void invoice(String idCutomer) throws IOException {
        for (OrderService o : order) {
            if (o.getIdCutomer().equals(idCutomer)) {
                try ( FileWriter fw = new FileWriter("src/main/resources/hoadon.txt")) {
                    fw.write("\t\t=== Hoa don thanh toan ===\n");
                    fw.write(String.format("Ma khach hang: %s\n"
                            + "Ten buoi tiec:%s\nNgay thue:%s\nThoi gian thue: %s",
                            o.getIdCutomer(), o.getNameWedding(),
                            Configure.f.format(o.getBookingDate()), o.getTime().getName()));
                    fw.write("Thong tin thue tiec\n-Sanh thue:\n");
                    fw.write(o.getHall().toString());
                    fw.write("\n-Menu cho tung ban\n");
                    for (Dish d : o.getMenu()) {
                        fw.write(d.toString() + "\n");
                    }
                    fw.write("-Cac dich vu di kem\n");
                    for (Service s : o.getService()) {
                        fw.write("+" + s.displayStr() + "\n" + s.toString() + "\n");
                    }
                    fw.write("=====> Tong tien thanh toan la :" + o.money() + "VND");
                    System.out.println("Xuat hoa don thanh cong.");
                    break;
                }
            }
        }
    }

    public double totalRevenueByMonth(int month, int year) {
        double total = 0;
        for (OrderService o : order) {

            if (o.getMonth() == month && o.getYear() == year) {
                total += o.money();
            }
        }
        return total;
    }

    public List<Double> totalRevenueByQuarter(int year) {
        List<Double> a = new ArrayList<>();
        double total = 0;
        for (int i = 1; i <= 12; i++) {
            total += this.totalRevenueByMonth(i, year);
            if (i == 3 || i == 6 || i == 9 || i == 12) {
                a.add(total);
                total = 0;
            }
        }
        return a;
    }

    public List<OrderService> getOrder() {
        return order;
    }

    public void setOrder(List<OrderService> order) {
        this.order = order;
    }

}
