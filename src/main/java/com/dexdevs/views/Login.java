/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dexdevs.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author Moieen
 */
public class Login extends CustomComponent implements View{
        
        final VerticalLayout layout;
     ///Login Form data..
        private FormLayout form;
        private TextField user;
        private PasswordField password;
        private Button login;
        
        public Login(){
            
             layout= new VerticalLayout();
             layout.setSizeFull();   
            
             form=new FormLayout();
             user=new TextField("Enter UserName:");
             password=new PasswordField("Enter Password");
             login=new Button("Login");
            
        login.addClickListener((event) -> {
            if(user.getValue().equalsIgnoreCase("admin")&&password.getValue().equals("12345")){
                
                Notification.show("User Creadinatls are correct.",Notification.Type.HUMANIZED_MESSAGE);
                UI.getCurrent().getNavigator().navigateTo("dashboard");
            }else{
                
                Notification.show("User Creadinatls are incorrect.",Notification.Type.ERROR_MESSAGE);
            }
        });
        form.addComponents(user,password,login);
//        form.setComponentAlignment(user, Alignment.MIDDLE_CENTER);
//        form.setComponentAlignment(password, Alignment.MIDDLE_CENTER);
//        form.setComponentAlignment(login, Alignment.MIDDLE_CENTER);
        
        layout.addComponents(form);
        layout.setComponentAlignment(form, Alignment.MIDDLE_CENTER);
        
        setCompositionRoot(layout);
    
        
        }
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        
        Notification.show("Welcome to Login Form",Notification.Type.HUMANIZED_MESSAGE);
        
    }
    
    
    
}
