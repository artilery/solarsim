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
public class Comet extends CelestialBody{
    private double trailLength;

    public Comet(){
        trailLength=2;
        setName("Comet");
        setColor(Color.YELLOW);
        setCenter(new Coordinate());
    }
    
    public double getTrailLength() {
        return trailLength;
    }

    public void setTrailLength(double trailLength) {
        this.trailLength = trailLength;
    }
    
    @Override
    public void accept(IPainter painter) {
        painter.paint(this);
    }
}
