/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dexdevs.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 *
 * @author mrizwan
 */
@Entity
@Data
public class Customer extends CommonEntity implements Serializable {

    private String name;
    
    private String phone;

    private String email;

    private String address;

    private String description;
    
    @OneToMany(fetch = FetchType.LAZY)
    private List<Sale> sales;

    public Customer() {
    }
    
    

    public Customer(String name, String phone, String email, String address, String description) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.description = description;
        
    }
    
    
}
