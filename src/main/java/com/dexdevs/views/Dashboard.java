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
import com.vaadin.ui.DateTimeField;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import java.time.LocalDateTime;

 /*
 * @author Moieen
 */
public class Dashboard extends VerticalLayout implements View{
    
        
    public Dashboard(){
        
        
        Button b=new Button("Refresh");
        DateTimeField d=new DateTimeField("Pick a date", LocalDateTime.now());
        b.addClickListener((event) -> {
            
            Notification.show(d.getValue().toString(), Notification.Type.HUMANIZED_MESSAGE);
        });
        
        addComponents(b,d);
        setComponentAlignment(b, Alignment.MIDDLE_CENTER);
        setComponentAlignment(d, Alignment.MIDDLE_CENTER);
        
            
    }
    
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
            Notification.show("welcome to Dashboard",Notification.Type.TRAY_NOTIFICATION);
        }

    
    
}
