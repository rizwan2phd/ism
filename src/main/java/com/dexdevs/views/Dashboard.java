/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dexdevs.views;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.AbstractErrorMessage.ContentMode;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

 /*
 * @author Moieen
 */
public class Dashboard extends CustomComponent implements View{
    
        private HorizontalSplitPanel horizental_SP;
        private Accordion accordion;
        private HorizontalLayout hlMain;
        
    public Dashboard(){
        Navigator navv = new Navigator(UI.getCurrent(), hlMain);
         navv.addView("", new DashBoardStatistics());
         navv.addView("customerv", new CustomerV());
        horizental_SP = new HorizontalSplitPanel();
        horizental_SP.setSizeFull();
        horizental_SP.setSplitPosition(150, Unit.PIXELS);
        
        UI.getCurrent().setNavigator(navv);
        
        hlMain = new HorizontalLayout();
        
        accordion=new Accordion();
        
        Button first = new Button("first link"); first.setStyleName(ValoTheme.BUTTON_LINK);
        first.addClickListener(e -> navv.navigateTo("customerv"));
        
        Button second = new Button("second link"); second.setStyleName(ValoTheme.BUTTON_LINK);
        
        VerticalLayout tab1 = new VerticalLayout(); tab1.addComponents(first, second);
        
        accordion.addTab(tab1,"Customer Tab"); 
        
        
 
        horizental_SP.setFirstComponent(accordion);
       horizental_SP.setSecondComponent(hlMain);
        
        
        
        
        
        
        setCompositionRoot(horizental_SP);
            
    }
    
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
            Notification.show("welcome to Dashboard",Notification.Type.TRAY_NOTIFICATION);
        }

    
    
}
