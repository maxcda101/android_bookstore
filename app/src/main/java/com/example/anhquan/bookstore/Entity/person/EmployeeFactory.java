/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.anhquan.bookstore.Entity.person;

import com.example.anhquan.bookstore.Entity.person.employee.Employee;
import com.example.anhquan.bookstore.Entity.person.employee.StaffStore;
import com.example.anhquan.bookstore.Entity.person.employee.Seller;
import com.example.anhquan.bookstore.Entity.person.employee.StaffManager;
import com.example.anhquan.bookstore.Entity.person.customer.Customer;
import java.io.Serializable;

/**
 *
 * @author zOzDarKzOz
 */
public class EmployeeFactory extends PersonAbstractFactory implements Serializable{

    @Override
    public Customer getCustomer(String cType) {
        return null;
    }

    @Override
    public Employee getEmployee(String eType) {
        try {
            if (eType == null) {
                return null;
            }
            if (eType.equals("staffManager")) {
                return new StaffManager();
            }
            if (eType.equals("staffStore")) {
                return new StaffStore();
            }
            if (eType.equals("seller")) {
                return new Seller();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
