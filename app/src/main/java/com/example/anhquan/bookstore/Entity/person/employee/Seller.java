/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.anhquan.bookstore.Entity.person.employee;

import java.io.Serializable;

/**
 *
 * @author zOzDarKzOz
 */
public class Seller extends Employee implements Serializable {

    @Override
    public String getEmployeeType() {
        return "seller";
    }

//    @Override
//    public Seller createSeller() {
//        return new Seller();
//    }
//
//    @Override
//    public StaffManager createStaffManager() {
//        return null;
//    }
//
//    @Override
//    public StaffStore createStaffStore() {
//        return null;
//    }

}
