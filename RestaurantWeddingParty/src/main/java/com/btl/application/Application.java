/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.application;

import com.btl.dishservice.DishService;
import com.btl.dishservice.Drinks;
import com.btl.dishservice.Food;
import com.btl.service.HireSinger;
import com.btl.service.Karaoke;
import com.btl.service.Perspective;
import com.btl.service.ServiceManagement;
import com.btl.weddinghall.WeddingHall;
import com.btl.weddinghall.WeddingHallService;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Application {

    public static void Menu() {
        System.out.println("========== CAC CHUC NANG CHINH =========");
        System.out.println("\t 1.Quan ly sanh thue");
        System.out.println("\t 2.Quan ly danh sach mon an");
        System.out.println("\t 3.Quan ly cac dich vu");
        System.out.println("\t 4.Thue sanh");
        System.out.println("\t 5.Xuat hoa don");
        System.out.println("\t 6.Sap xep sanh");
        System.out.println("\t 7.Bao cao doanh thu");
        System.out.println("\t 8.Thoat chuong trinh");
    }

    public static void MenuHall() {
        System.out.println("=========== Quan ly sanh cuoi =======");
        System.out.println("\t1.Them sanh moi");
        System.out.println("\t2.Sua thong tin sanh.");
        System.out.println("\t3.Xoa sanh");
        System.out.println("\t4.Tim kiem thong tin sanh");
        System.out.println("\t5.Xuat danh sach sanh.");
    }

    public static void MenuDish() {
        System.out.println("=========== Quan ly thuc an =======");
        System.out.println("\t1.Them mon an");
        System.out.println("\t2.Sua thong tin mon an.");
        System.out.println("\t3.Xoa mon an");
        System.out.println("\t4.Tra cuu loai mon an");
        System.out.println("\t5.Xuat danh sach mon an.");
    }

    public static void MenuService() {
        System.out.println("========= Quan ly dich vu =========");
        System.out.println("\t1.Them dich vu");
        System.out.println("\t2.Sua thong tin dich vu");
        System.out.println("\t3.Xoa dich vu");
        System.out.println("\t4.Tra cuu ten dich vu");
        System.out.println("\t5.Xuat danh sach dich vu");
    }

    public static void main(String[] args) throws ParseException, ClassNotFoundException {
        WeddingHallService HALL = new WeddingHallService();
        HALL.addHall(new WeddingHall("Sanh 1", 3, 50, 1000000),
                new WeddingHall("Sanh 2", 4, 100, 1200000),
                new WeddingHall("Sanh 3", 4, 250, 1550000),
                new WeddingHall("Sanh 4", 1, 300, 2000000),
                new WeddingHall("Sanh 5", 2, 120, 3000000));
//        for (WeddingHall h : HALL.getHall()) {
//            h.setTimes((int) (Math.random() * 10));
//        }
        DishService DISH = new DishService();
        DISH.addDish(new Food("Thit", 55000, true),
                new Food("Cha nem", 65000, true),
                new Drinks("Bia", 12000, "Viet Nam"),
                new Drinks("Pessi", 15000, "Pessi"),
                new Food("Banh mi", 20000, true),
                new Drinks("Coca", 15000, "Coca"));
        ServiceManagement SERVICE = new ServiceManagement();
        SERVICE.addService(new Karaoke(20000, 2.5),
                new HireSinger(60000, "Son Tung", 3),
                new HireSinger(32000, "My Tam", 2),
                new Karaoke(45000, 3.5),
                new Perspective(15000));
        OrderManagement order = new OrderManagement();
        order.addOrder(new OrderService("Buoi tiec 1", HALL.searchByHall("S001"), DISH.getDish(), SERVICE.getService(), "12/12/2022", Time.NIGHT),
                new OrderService("Buoi tiec 2", HALL.searchByHall("S002"), DISH.getDish(), SERVICE.getService(), "12/4/2022", Time.AFTERNOON),
                new OrderService("Buoi tiec 3", HALL.searchByHall("S003"), DISH.getDish(), SERVICE.getService(), "05/1/2022", Time.MORNING),
                new OrderService("Buoi tiec 4", HALL.searchByHall("S001"), DISH.getDish(), SERVICE.getService(), "05/7/2022", Time.NIGHT));

        int choose = 0;
        do {
            Scanner input = new Scanner(System.in);
            Application.Menu();
            try {
                System.out.print("Nhap luc chon: ");
                choose = Integer.parseInt(input.nextLine());
                switch (choose) {
                    case 1 -> {
                        Application.MenuHall();
                        System.out.print("Nhap luc chon: ");
                        int choose1 = Integer.parseInt(Configure.sc.nextLine());
                        switch (choose1) {
                            case 1 -> {
                                System.out.println("== Them sanh moi ==");
                                WeddingHall w = new WeddingHall();
                                w.creatHall();
                                HALL.addHall(w);
                                System.out.println("Them thanh cong.");
                            }
                            case 2 -> {
                                System.out.print("Nhap ma sanh can cap nhat: ");
                                String idHall = Configure.sc.nextLine();
                                if (HALL.isCheckById(idHall) == true) {
                                    HALL.updateHall(HALL.searchByHall(idHall));
                                    System.out.println("Chinh sua thanh cong.");
                                } else {
                                    System.out.println("Ma sanh khong ton tai!");
                                }
                            }
                            case 3 -> {
                                System.out.print("Nhap ma sanh can xoa: ");
                                String idHall = Configure.sc.nextLine();
                                if (HALL.isCheckById(idHall) == true) {
                                    HALL.removeHall(HALL.searchByHall(idHall));
                                    System.out.println("Xoa thanh cong.");
                                } else {
                                    System.out.println("Ma sanh khong ton tai!");
                                }
                            }
                            case 4 -> {
                                System.out.println("== Tra cuu ==");
                                System.out.print("1.Tra cuu theo suc chua\n"
                                        + "2.Tra cuu theo vi tri\n"
                                        + "3.Tra cuu theo ten\nNhap luc chon: ");
                                int traCuu = Integer.parseInt(Configure.sc.nextLine());
                                switch (traCuu) {
                                    case 1 -> {
                                        System.out.println("Nhap so luong suc chua(n->m): ");
                                        int n = Integer.parseInt(Configure.sc.nextLine());
                                        int m = Integer.parseInt(Configure.sc.nextLine());
                                        System.out.printf("Tra cuu cac sanh co sua chua tu %d -> %d ban\n%s\n", n, m, HALL.formatStr());
                                        HALL.searchHall(n, m).forEach(h -> h.display());
                                    }
                                    case 2 -> {
                                        System.out.print("Nhap vi tri sanh can tim: ");
                                        int floor = Integer.parseInt(Configure.sc.nextLine());
                                        System.out.printf("Tra cuu cac sanh co vi tri tang %d\n%s\n", floor, HALL.formatStr());
                                        HALL.searchHall(floor).forEach(h -> h.display());
                                    }
                                    case 3 -> {
                                        System.out.print("Nhap ten sanh can tim kiem: ");
                                        String nameHall = Configure.sc.nextLine();
                                        System.out.printf("Tra cuu sanh co ten la %s\n%s\n", nameHall, HALL.formatStr());
                                        HALL.searchHall(nameHall).display();
                                    }
                                    default -> {
                                        break;
                                    }
                                }
                            }
                            case 5 -> {
                                System.out.println("\t\t\t== Danh sach sanh cuoi ==");
                                HALL.showListHall();
                            }
                            default -> {
                                break;
                            }
                        }
                    }
                    case 2 -> {
                        Application.MenuDish();
                        System.out.print("Nhap luc chon: ");
                        int choose2 = Integer.parseInt(Configure.sc.nextLine());
                        switch (choose2) {
                            case 1 -> {
                                System.out.println("== Them mon an ==");
                                System.out.print("\t1.Them thuc an\n"
                                        + "\t2.Them thuc uong\n"
                                        + "Nhap luc chon: ");
                                int t = Integer.parseInt(Configure.sc.nextLine());
                                DISH.addDish(t);
                                System.out.println("Them thong cong.");
                            }
                            case 2 -> {
                                System.out.println("== Chinh sua thong tin mon an ==");
                                System.out.print("Nhap ma mon an can chinh sua: ");
                                String idHall = Configure.sc.nextLine();
                                if (DISH.isCheckById(idHall) == true) {
                                    DISH.updateDish(DISH.searchDish(idHall));
                                    System.out.println("Chinh sua thanh cong.");
                                } else {
                                    System.out.println("Ma mon an khong ton tai!");
                                }
                            }
                            case 3 -> {
                                System.out.println("== Xoa mon an ==");
                                System.out.println("Nhap ma mon an can xoa: ");
                                String idDish = Configure.sc.nextLine();
                                if (DISH.isCheckById(idDish) == true) {
                                    DISH.removeDish(DISH.searchDish(idDish));
                                    System.out.println("Xoa mon an thanh cong.");
                                } else {
                                    System.out.println("Ma mon an nay khong ton tai!");
                                }
                            }
                            case 4 -> {
                                System.out.println("== Tim kiem theo loai ==");
                                System.out.println("\t1.Tim kiem cac thuc an\n"
                                        + "\t2.Tim kiem cac thuc uong");
                                System.out.print("Nhap luc chon: ");
                                int k = Integer.parseInt(Configure.sc.nextLine());
                                if (k == 1) {
                                    System.out.println("\t\t== Danh sach cac thuc an ==");
                                    DISH.searchTypeDish("com.btl.dishservice.Food").forEach(d -> d.showInfo());
                                } else if (k == 2) {
                                    System.out.println("\t\t== Danh sach cac thuc uong ==");
                                    DISH.searchTypeDish("com.btl.dishservice.Drinks").forEach(d -> d.showInfo());
                                }
                            }
                            case 5 -> {
                                System.out.println("\t\t\t== Danh sach mon an ==");
                                DISH.showListDish();
                            }
                            default -> {
                                break;
                            }
                        }
                    }
                    case 3 -> {
                        Application.MenuService();
                        System.out.print("Nhap lua chon:");
                        int choose3 = Integer.parseInt(Configure.sc.nextLine());
                        switch (choose3) {
                            case 1 -> {
                                System.out.println("== Them dich vu ==");
                                System.out.println("\t1.Dich vu karaoke");
                                System.out.println("\t2.Dich vu thue ca si");
                                System.out.println("\t3.Dich vu trang tri phoi canh");
                                System.out.print("Nhap luc chon: ");
                                int input1 = Integer.parseInt(Configure.sc.nextLine());
                                SERVICE.addService(input1);
                                System.out.println("Them thanh cong.");
                            }
                            case 2 -> {
                                System.out.println("== Chinh sua thong tin dich vu ==");
                                System.out.print("Nhap ma dich vu can chinh sua: ");
                                String idService = Configure.sc.nextLine();
                                if (SERVICE.isCheckById(idService) == true) {
                                    SERVICE.updateService(SERVICE.searchByService(idService));
                                    System.out.println("Chinh sua thanh cong.");
                                } else {
                                    System.out.println("Ma dich vu khong ton tai!");
                                }
                            }
                            case 3 -> {
                                System.out.println("== Xoa dich vu ==");
                                System.out.println("Nhap ma dich vu can xoa: ");
                                String idService = Configure.sc.nextLine();
                                if (SERVICE.isCheckById(idService) == true) {
                                    SERVICE.removeService(SERVICE.searchByService(idService));
                                    System.out.println("Xoa dich vu thanh cong.");
                                } else {
                                    System.out.println("Ma dich vu nay khong ton tai!");
                                }
                            }
                            case 4 -> {
                                System.out.println("== Tim kiem theo ten dich vu ==");
                                System.out.print("Nhap ten dich vu can tim kiem: ");
                                String nameService = Configure.sc.nextLine();
                                SERVICE.searchService(nameService).forEach(s -> s.showInfo());
                            }
                            case 5 -> {
                                System.out.println("\t\t\t== Danh sach dich vu ==");
                                SERVICE.showListService();
                            }
                            default -> {
                                break;
                            }
                        }
                    }
                    case 4 -> {
                        System.out.println("== Nhap thong tin thue tiec cuoi ==");
                        order.addOrder(HALL, DISH, SERVICE);
                    }
                    case 5 -> {
                        System.out.println("== Xuat hoa don ==");
                        System.out.print("Nhap ma khach hang: ");
                        String idCutomer = Configure.sc.nextLine();
                        order.invoice(idCutomer);
                    }
                    case 6 -> {

                        System.out.println("== Sap xep sanh ==");
                        //Collections.sort(HALL.getHall());
                        HALL.sort();
                        for (WeddingHall w : HALL.getHall()) {
                            System.out.printf("Ten sanh: %s -- So lan thue:%d\n", w.getNameHall(), w.getTimes());
                        }
                    }
                    case 7 -> {

                        System.out.println("== Doanh thu ==");
                        System.out.println("\t1.Tinh doanh thu theo thang.\n\t2.Tinh doanh thu theo cac quy trong nam.");
                        System.out.print("Nhap lua chon: ");
                        int input3 = Integer.parseInt(Configure.sc.nextLine());
                        if (input3 == 1) {
                            System.out.print("Nhap thang: ");
                            int month = Integer.parseInt(Configure.sc.nextLine());
                            System.out.print("Nhap nam: ");
                            int year = Integer.parseInt(Configure.sc.nextLine());
                            for (OrderService o : order.getOrder()) {
                                if (o.getMonth() == month && o.getYear() == year) {
                                    System.out.println(o.getIdCutomer() + "--" + o.getNameWedding()
                                            + "--" + Configure.f.format(o.getBookingDate()));
                                }
                            }
                            System.out.printf("Tong doanh thu theo thang %d nam %d la: %.2f VND\n ", month, year, order.totalRevenueByMonth(month, year));

                        } else if (input3 == 2) {
                            System.out.print("Nhap nam: ");
                            int year = Integer.parseInt(Configure.sc.nextLine());
                            int i = 1;
                            for (double a : order.totalRevenueByQuarter(year)) {
                                System.out.printf("Quy %d =%.2f VND \n", i, a);
                                i++;
                            }
                        }
                    }
                }
            } catch (InputMismatchException ei) {
                System.out.println("Ban da nhap sai , xin nhap lai!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (choose != 8);
        System.out.println("Tam biet!");
    }
}
