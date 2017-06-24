/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dexdevs.views;

import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author Moieen
 */
public class DesktopDemo extends CustomComponent{
    private HorizontalSplitPanel layout;
    private VerticalLayout vl;
    private Accordion accordion;

    public DesktopDemo(){
        layout=new HorizontalSplitPanel();
        vl=new VerticalLayout();
        accordion=new Accordion();
        layout.addComponents(accordion,vl);
        
        layout.setSizeFull();
        layout.setSplitPosition(250, Unit.PIXELS);
       
        ///////End of login in form code
        
        ////accordion////////
        Button first = new Button("customer"); first.setStyleName(ValoTheme.BUTTON_LINK);
        accordion.addTab(first,"Customer Tab");
         first.addClickListener(e ->{
             
             vl.removeAllComponents();
             vl.addComponent(new CustomerV());
         });
        Button second = new Button("Dashbaord"); second.setStyleName(ValoTheme.BUTTON_LINK);
        accordion.addTab(second,"Tab Product");
         second.addClickListener(e ->{
             vl.removeAllComponents();
             vl.addComponent(new ProductView());
             
         });

         setCompositionRoot(layout);
        
    }
    
    
    
}
