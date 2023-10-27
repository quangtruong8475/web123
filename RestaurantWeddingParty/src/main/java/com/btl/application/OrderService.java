/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.application;

import com.btl.dishservice.Dish;
import com.btl.dishservice.DishService;
import com.btl.service.Service;
import com.btl.service.ServiceManagement;
import com.btl.weddinghall.WeddingHall;
import com.btl.weddinghall.WeddingHallService;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderService {

    private static int id;
    private String idCutomer;
    private String nameWedding;
    private List<Dish> menu = new ArrayList<>();
    private List<Service> service = new ArrayList<>();
    private WeddingHall hall;
    private Date bookingDate;
    private Time time;

    {
        idCutomer = String.format("KH%03d", ++id);
    }

    public OrderService() {
    }

    public OrderService(String nameWedding, WeddingHall hall, List<Dish> menu,
            List<Service> service, String bookingDate, Time time) throws ParseException {
        this.nameWedding = nameWedding;
        this.hall = hall;
        hall.setTimes(hall.getTimes() + 1);
        this.menu = menu;
        this.service = service;
        this.bookingDate = Configure.f.parse(bookingDate);
        this.time = time;
    }

    public int getMonth() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.bookingDate);
        return c.get((Calendar.MONTH)) + 1;
    }

    public int getYear() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.bookingDate);
        return c.get(Calendar.YEAR);
    }

    public static String inputDate() throws ParseException {
        Calendar dayNow = new GregorianCalendar();
        String bookingDate;
        int check = 0;
        do {
            System.out.print("Nhap ngay thue(dd/MM/yyyy):");
            bookingDate = Configure.sc.nextLine();
            Date c = Configure.f.parse(bookingDate);
            check = c.compareTo(dayNow.getTime());
            if (check < 0) {
                System.out.printf("Vui long nhap sau ngay hien tai(%s)\n",
                        Configure.f.format(dayNow.getTime()));
            }
        } while (check < 0);
        return bookingDate;
    }

    public void orderWedding(WeddingHallService hall, DishService dish, ServiceManagement service) throws ParseException {
        System.out.print("Nhap ten buoi tiec: ");
        this.nameWedding = Configure.sc.nextLine();
        //Chon sanh cuoi
        hall.showListHall();
        String idHall;
        do {
            System.out.print("Nhap ma sanh cuoi: ");
            idHall = Configure.sc.nextLine();
            if (hall.isCheckById(idHall) == true) {
                WeddingHall h = hall.searchByHall(idHall);
                h.setTimes(h.getTimes() + 1);
                this.hall = h;
            } else {
                System.out.println("Ma sanh khong ton tai!");
            }
        } while (hall.isCheckById(idHall) != true);
        //Nhap ngay
        this.bookingDate= Configure.f.parse(OrderService.inputDate());
//        String bookingDate = ;
//        this.bookingDate = Configure.f.parse(bookingDate);
        //Chon thoi gian
        System.out.println("Chon thoi gian thue tiec");
        this.time = Time.chooseTime();
        //Lua chon menu
        dish.showListDish();
        int c;
        String idDish;
        do {
            System.out.print("Luc chon menu cho moi ban(ma mon an):");
            idDish = Configure.sc.nextLine();
            if (dish.isCheckById(idDish) == true) {
                this.getMenu().add(dish.searchDish(idDish));
            } else {
                System.out.println("Ma mon an nay khong ton tai!");
            }
            System.out.print("Tiep tuc(1:0): ");
            c = Integer.parseInt(Configure.sc.nextLine());
        } while (c != 0);

        //Lua chon dich vu
        service.showListService();
        String idService;
        do {
            System.out.print("Luc chon cac dich vu(ma dich vu): ");
            idService = Configure.sc.nextLine();
            if (service.isCheckById(idService) == true) {
                this.getService().add(service.searchByService(idService));
            } else {
                System.out.println("Ma dich vu nay khong ton tai!");
            }
            System.out.print("Tiep tuc(1:0): ");
            c = Integer.parseInt(Configure.sc.nextLine());
        } while (c != 0);
        System.out.println("\t== THONG TIN THUE TIEC ==");
        this.display();

        System.out.println("Dat tiec cuoi thanh cong.");
    }

    public double money() {
        double bill = 0;
        double priceHall = this.hall.getInitialPrice();
        bill += priceHall + priceHall * this.time.getValue() * 0.01;
        for (Dish d : this.menu) {
            bill += d.getPrice();
        }
        for (Service s : this.service) {
            bill += s.getPrice();
        }
        return bill;
    }

    public void display() {
        System.out.printf("Ma thue tiec: %s\n", this.idCutomer);
        System.out.printf("Ten buoi tiec: %s\n", this.nameWedding);
        System.out.printf("Ngay dat tiec: %s\n", Configure.f.format(this.bookingDate));
        System.out.printf("Thoi gian thue:%s\n", this.getTime().getName());
        this.hall.show();
        System.out.println("Danh sach thuc don cho moi ban: ");
        this.menu.forEach(d -> d.show());
        System.out.println("Cac dich vu: ");
        this.service.forEach(s -> s.show());
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        OrderService.id = id;
    }

    public String getIdCutomer() {
        return idCutomer;
    }

    public void setIdCutomer(String idCutomer) {
        this.idCutomer = idCutomer;
    }

    public String getNameWedding() {
        return nameWedding;
    }

    public void setNameWedding(String nameWedding) {
        this.nameWedding = nameWedding;
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

    public WeddingHall getHall() {
        return hall;
    }

    public void setHall(WeddingHall hall) {
        this.hall = hall;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}
