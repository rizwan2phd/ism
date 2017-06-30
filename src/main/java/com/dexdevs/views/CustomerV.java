/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dexdevs.views;

import com.sun.java.accessibility.util.AWTEventMonitor;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

/**
 *
 * @author Chaudhary
 */
public class CustomerV extends CustomComponent implements View{
    
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
        address.setIcon(VaadinIcons.AMBULANCE);
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

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    private void addComponenet(TextField name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
