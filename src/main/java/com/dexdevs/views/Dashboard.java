/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dexdevs.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.AbstractErrorMessage.ContentMode;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;

 /*
 * @author Moieen
 */
public class Dashboard extends CustomComponent implements View{
    
        private HorizontalSplitPanel horizental_SP;
        private Accordion accordion;
        
    public Dashboard(){
        
        horizental_SP = new HorizontalSplitPanel();
        horizental_SP.setSizeFull();
        horizental_SP.setSplitPosition(150, Unit.PIXELS);
        
        accordion=new Accordion();
        
        Label first = new Label("<a href=\"#\">Click here</a> ", com.vaadin.shared.ui.ContentMode.HTML);
        
        
        Label secondComponent = new Label("<h2>Second Label</h2>", com.vaadin.shared.ui.ContentMode.HTML);
        secondComponent.setWidth(100, Unit.PERCENTAGE);
        
        accordion.addTab(first,"Customer Tab");
        
        
 
        horizental_SP.setFirstComponent(accordion);
        horizental_SP.setSecondComponent(secondComponent);
        
        
        
        
        
        
        setCompositionRoot(horizental_SP);
            
    }
    
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
            Notification.show("welcome to Dashboard",Notification.Type.TRAY_NOTIFICATION);
        }

    
    
}
