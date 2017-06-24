/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dexdevs.views;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

/**
 *
 * @author Chaudhary
 */
public class CustomerV extends CustomComponent{
    
        private FormLayout layout;
    
    public CustomerV(){
        
        layout= new FormLayout();
        layout.setMargin(true);
        layout.setSizeFull();
        
        TextField name=new TextField("Name :");
        name.setIcon(VaadinIcons.USER);
        name.setPlaceholder("Enter Customer Name");
        
        TextField address=new TextField();
        address.setCaption("Address :");
        address.setIcon(VaadinIcons.HOME);
        address.setPlaceholder("Enter Address");
        
        TextField phone=new TextField();
        phone.setCaption("Phone :");
        phone.setIcon(VaadinIcons.PHONE);
        phone.setPlaceholder("Enter Phone NO.");
        
        TextField email=new TextField();
        email.setCaption("Email :");
        email.setIcon(VaadinIcons.ENVELOPE);
        email.setPlaceholder("Enter Email");
        
        TextArea description = new TextArea();
        description.setCaption("Description :");
        description.setPlaceholder("Enter Description :");
        description.setIcon(VaadinIcons.DROP);
    
        layout.addComponents(name, address, phone, email, description);
        
        setCompositionRoot(layout);
    
    }

  
    
}
