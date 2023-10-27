/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btl.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class ServiceManagement {

    private List<Service> service = new ArrayList<>();

    public void addService(Service... s) {
        this.service.addAll(Arrays.asList(s));
    }

    public void addService(int choose) {
        switch (choose) {
            case 1 -> {
                Service k = new Karaoke();
                k.createInfo();
                this.service.add(k);
            }
            case 2 -> {
                Service h = new HireSinger();
                h.createInfo();
                this.service.add(h);
            }
            case 3 -> {
                Service p = new Perspective();
                p.createInfo();
                this.service.add(p);
            }
            default -> {
                break;
            }
        }
    }

    public void removeService(Service s) {
        this.service.remove(s);
    }
     public void updateService(Service s) {
       s.updateInfo();
    }

    public Service searchByService(String idService) {
        return this.service.stream().filter(d -> d.getIdService().equals(idService)).findFirst().get();
    }

    public List<Service> searchService(String nameService) {
        return this.service.stream().filter(d -> d.getNameService().equals(nameService)).collect(Collectors.toList());
    }

    public boolean isCheckById(String idService) {
        for (Service s : service) {
            if (s.getIdService().equals(idService)) {
                return true;
            }
        }
        return false;
    }

    public void showListService() {
        this.service.forEach(s -> s.showInfo());
    }

    /**
     * @return the service
     */
    public List<Service> getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(List<Service> service) {
        this.service = service;
    }

   

}
