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
public class Star extends CelestialBody{
    private double brightness;

    public Star(){
        brightness=0.5;
        setName("Sun");
        setColor(Color.YELLOW);
        setCenter(new Coordinate());
    }
    @Override
    public void accept(IPainter painter) {
        painter.paint(this);
    }

    public double getBrightness() {
        return brightness;
    }

    public void setBrightness(double brightness) {
        this.brightness = brightness;
    }
    
}
