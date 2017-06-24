/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dexdevs.views;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
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
        
    
        private final VerticalLayout layout;
     ///Login Form data..
        private final  FormLayout form;
        private TextField user;
        private PasswordField password;
        private final Button login;
        
        
        public Login(){
            
             layout=new VerticalLayout();
             layout.setSizeFull();
             
                        
             form=new FormLayout();
             form.setCaptionAsHtml(true);
//             form.setSizeFull();
             form.setCaption("<h1>Login...</h1>");
             
             
             user=new TextField("Enter UserName:");
             user.setIcon(VaadinIcons.USER);
             user.setWidth(25,Unit.PERCENTAGE);
             user.setPlaceholder("Username....");
             user.focus();
             password=new PasswordField("Enter Password");
             password.setIcon(VaadinIcons.PASSWORD);
             password.setPlaceholder("******");
             password.setWidth(25, Unit.PERCENTAGE);
             login=new Button("Login");
             login.setWidth(8,Unit.PERCENTAGE);
             login.setClickShortcut(KeyCode.ENTER);
          
             
            
            login.addClickListener((ClickEvent) -> {
                
                    if(user.getValue().equalsIgnoreCase("admin")&&password.getValue().equals("12345")){
                
                    Notification.show("User Creadinatls are correct.",Notification.Type.HUMANIZED_MESSAGE);
                    UI.getCurrent().getNavigator().navigateTo("dashboard");
                    user.clear();
                    password.clear();
                    
            }else{
                
                Notification.show("User Creadinatls are incorrect.\n"
                        + "Pres ESC to proceed",Notification.Type.ERROR_MESSAGE);
            }
        });
        form.addComponents(user,password,login);
//        form.setComponentAlignment(user, Alignment.MIDDLE_CENTER);
//        form.setComponentAlignment(password, Alignment.MIDDLE_CENTER);
//        form.setComponentAlignment(login, Alignment.MIDDLE_RIGHT);
        
        
        layout.addComponent(form);
        layout.setComponentAlignment(form, Alignment.MIDDLE_CENTER);
        
        
        setCompositionRoot(layout);
        
    
        
        }
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        
        Notification.show("Welcome to Login Form",Notification.Type.HUMANIZED_MESSAGE);
        
    }
    
    
    
}
