/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innoprenez.apps.solarsyssim.model;

import android.graphics.Color;
import com.innoprenez.apps.solarsyssim.view.IPainter;




/**
 *
 * @author Bonga Nkosi
 */
public class Moon extends CelestialBody{
    private String metalComposition;
    
    public Moon(){
        metalComposition="-";
        setName("Moon");
        setColor(Color.GRAY);
        setCenter(new Coordinate());
    }
    @Override
    public void accept(IPainter painter) {
        painter.paint(this);
    }

    public String getMetalComposition() {
        return metalComposition;
    }

    public void setMetalComposition(String metalComposition) {
        this.metalComposition = metalComposition;
    }
    
    
}
