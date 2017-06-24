/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dexdevs.views;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateTimeField;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import java.time.LocalDateTime;

/**
 *
 * @author Moieen
 */
public class ProductView extends CustomComponent{
    
    
    public  VerticalLayout vl;
//    private
    public ProductView(){
         
        vl=new VerticalLayout();
         
         Button b=new Button("Refresh");
         DateTimeField d=new DateTimeField("Pick a date", LocalDateTime.now());
         b.addClickListener((event) -> {
             
             Notification.show(d.getValue().toString(), Notification.Type.HUMANIZED_MESSAGE);
         });
         
         vl.addComponents(b,d,new Label("Demo Label"));
         
        setCompositionRoot(vl);
 
    }

   
              
      }
    
    

           
    
    

