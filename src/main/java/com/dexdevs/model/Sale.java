/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dexdevs.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author mrizwan
 */
@Entity
@Data
public class Sale extends CommonEntity implements Serializable {
    
    @ManyToOne
    private Customer customer;
    
    private Double totalAmount;
    
    private float discount;
    
    
    
    @ElementCollection
    private List<SaleDetail> saleDetail;
    
    
}

@Embeddable
@Data
class SaleDetail
{
    @ManyToOne
    private Product product;
    
    private int quantity;
    
    private float discount;
    
    
}