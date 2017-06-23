/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dexdevs.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;

/**
 *
 * @author mrizwan
 */
public class DashBoardStatistics extends CustomComponent implements View{
    
    
    public DashBoardStatistics()
    {
        setCompositionRoot(new Label("Hiiiiiiiiiiiiiiiiiiiiiii"));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
