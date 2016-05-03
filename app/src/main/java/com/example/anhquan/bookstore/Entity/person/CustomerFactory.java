/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.anhquan.bookstore.Entity.person;

import com.example.anhquan.bookstore.Entity.person.employee.Employee;
import com.example.anhquan.bookstore.Entity.person.customer.Customer;
import com.example.anhquan.bookstore.Entity.person.customer.CustomerMember;
import com.example.anhquan.bookstore.Entity.person.customer.CustomerNotMember;
import java.io.Serializable;

/**
 *
 * @author zOzDarKzOz
 */
public class CustomerFactory extends PersonAbstractFactory implements Serializable {

    @Override
    public Customer getCustomer(String cType) {
        try {
            if (cType == null) {
                return null;
            }
            if (cType.equals("customerMember")) {
                return new CustomerMember();
            }
            if (cType.equals("customerNotMember")) {
                return new CustomerNotMember();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getEmployee(String eType) {
        return null;
    }
}
