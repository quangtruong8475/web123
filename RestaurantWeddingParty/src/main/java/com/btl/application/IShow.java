/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.btl.application;

/**
 *
 * @author Admin
 */
public interface IShow {
    String displayStr();
    default void show(){
        System.out.println(displayStr());
        System.out.println(this);
    }
    
}
