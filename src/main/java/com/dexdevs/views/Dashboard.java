/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dexdevs.views;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
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

 /*
 * @author Moieen
 */
public class Dashboard extends CustomComponent implements View{
    
        private final HorizontalSplitPanel horizental_SP;
        private final Accordion accordion;
        private HorizontalLayout hlMain;
        
    public Dashboard(){
        Navigator navv = new Navigator(UI.getCurrent(), hlMain);
         navv.addView("", new DashBoardStatistics());
         navv.addView("customerv", new CustomerV());
        horizental_SP = new HorizontalSplitPanel();
        horizental_SP.setSizeFull();
        horizental_SP.setSplitPosition(250, Unit.PIXELS);
        
        UI.getCurrent().setNavigator(navv);
        
        hlMain = new HorizontalLayout();
        
        accordion=new Accordion();
        
        Label label1 = new Label("<a href=\"#\">Click here1</a> ", com.vaadin.shared.ui.ContentMode.HTML);
        Label label2 = new Label("<a href=\"#\">Click here2</a> ", com.vaadin.shared.ui.ContentMode.HTML);
        Label label3 = new Label("<a href=\"#\">Click here3</a> ", com.vaadin.shared.ui.ContentMode.HTML);
        Label label4 = new Label("<a href=\"#\">Click here4</a> ", com.vaadin.shared.ui.ContentMode.HTML);
        VerticalLayout vl=new VerticalLayout();
        vl.addComponents(label1,label2);
        
        VerticalLayout vl2=new VerticalLayout();
        vl2.addComponents(label3,label4);
        
        Button second = new Button("second link"); second.setStyleName(ValoTheme.BUTTON_LINK);
        
        Label secondComponent = new Label("<h2>To be used Navigation</h2>", com.vaadin.shared.ui.ContentMode.HTML);
        secondComponent.setWidth(100, Unit.PERCENTAGE);
        
        accordion.addTab(vl,"Customer Tab");
        accordion.addTab(vl2,"Second tab");
        
        
 
        horizental_SP.setFirstComponent(accordion);
       horizental_SP.setSecondComponent(hlMain);
        
        
        
        
        
        
        setCompositionRoot(horizental_SP);
            
    }
    
    
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
            Notification.show("welcome to Dashboard",Notification.Type.TRAY_NOTIFICATION);
        }

    
    
}
