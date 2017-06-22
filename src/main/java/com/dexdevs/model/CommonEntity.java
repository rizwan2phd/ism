/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dexdevs.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import lombok.Data;

/**
 *
 * @author mrizwan
 */
@Entity
@Data
public abstract class CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();
    
     @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt = new Date();
    
    private Long createdBy;
    
    private Long updatedBy;
    
    @Version
    private int version;

    
}
