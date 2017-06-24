/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dexdevs.views;

import com.dexdevs.model.Customer;
import com.vaadin.data.Binder;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author Chaudhary
 */
public class CustomerV extends HorizontalLayout{
    
        private FormLayout form;
        private TextField name;
        private TextField address;
        private TextField phone;
        private TextField email;
        private TextArea description;
        private Button save;
        private Button clear;
        private Customer customer;
        private Grid<Customer> grid;
        
        private Binder<Customer> binder=new Binder<>(Customer.class);
        
    public CustomerV(){
        customer = new Customer();     
        
        form= new FormLayout();
        form.setCaption("<h3>Enter Customer Detail...</h3>");
        form.setCaptionAsHtml(true);
        form.setSizeUndefined();
        
        name=new TextField("Name :");
        name.setIcon(VaadinIcons.USER);
        name.setWidth("30%");
        name.setPlaceholder("Name...");
        
        address=new TextField();
        address.setCaption("Address :");
        address.setWidth("30%");
        address.setIcon(VaadinIcons.HOME);
        address.setPlaceholder("Enter Address");
        
        phone=new TextField();
        phone.setCaption("Phone :");
        phone.setWidth("30%");
        phone.setIcon(VaadinIcons.PHONE);
        phone.setPlaceholder("Phone#...");
        
        email=new TextField();
        email.setWidth("30%");
        email.setCaption("Email :");
        email.setIcon(VaadinIcons.ENVELOPE);
        email.setPlaceholder("Email...");
        
        description = new TextArea();
        description.setStyleName(ValoTheme.TEXTAREA_LARGE);
        description.setCaption("Description :");
        description.setWidth("30%");
        description.setPlaceholder("Description...");
        description.setIcon(VaadinIcons.ALIGN_LEFT);
        
        
        binder.bindInstanceFields(this);
        
        save=new Button("Save");
        save.setWidth("145");
        save.setDescription("This Button saves and Update Customer Detail");
        save.addClickListener((event) -> {
            
            Notification.show(customer.toString(), Notification.Type.HUMANIZED_MESSAGE);
            grid.setItems(customer);
        });
        
        
        
        
        clear=new Button("Clear");
        clear.setWidth("145");
        clear.setDescription("Clear all Field to their Default Values(Empty)");
        clear.addClickListener(e ->{
            clear();
        });
    
        form.addComponents(name, address, phone, email, description,new HorizontalLayout(clear,save));
        
        grid=new Grid(Customer.class);
        grid.setCaption("<h3>Enter Customer Detail...</h3>");
        grid.setCaptionAsHtml(true);
        
        
//        grid.setColumns("name","phone","email","address");
        addComponents(grid,form);
        setExpandRatio(grid,1);
    
    }
    ///Clear all Field to their Default values mean Empty....
    void clear(){
        name.setValue("");
        email.setValue("");
        phone.setValue("");
        description.setValue("");
        address.setValue("");
            
    }
    
    public void setCustomer(Customer customer){
        this.customer=customer;
        binder.setBean(customer);
        
    }
    
    
}
