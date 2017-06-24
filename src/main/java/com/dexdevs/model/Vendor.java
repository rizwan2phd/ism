/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dexdevs.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 *
 * @author mrizwan
 */
@Entity
@Data
public class Vendor extends CommonEntity implements Serializable {

    private String name;
    
    private String phoneNumber;

    private String email;

    private String address;

    private String descriptin;
}
