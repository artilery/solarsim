/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innoprenez.apps.solarsyssim.model;

import android.graphics.Color;
import com.innoprenez.apps.solarsyssim.view.IPainter;




/**
 *
 * @author zinhle
 */
public class Planet extends CelestialBody{
    private double habitable;

    public Planet(){
        habitable=0.0;
        setName("Planet");
        setColor(Color.BLUE);
        //Coordinate center = getParent().getCenter(); 
        setCenter(new Coordinate());
    }
    @Override
    public void accept(IPainter painter) {
        painter.paint(this);
    }

    public double getHabitable() {
        return habitable;
    }

    public void setHabitable(double habitable) {
        this.habitable = habitable;
    }
    
}
