package com.dexdevs.model;

import java.io.Serializable;
import javax.persistence.Entity;
import lombok.Data;

/**
 *
 * @author mrizwan
 */
@Entity
@Data
public class User extends CommonEntity implements Serializable {

    private String userName;
    
    private String password;
    
    private String role;
    
    private String description;
    
}

