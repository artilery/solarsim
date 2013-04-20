
package com.innoprenez.apps.solarsyssim.view;

import android.graphics.Canvas;

import com.innoprenez.apps.solarsyssim.model.Comet;
import com.innoprenez.apps.solarsyssim.model.Moon;
import com.innoprenez.apps.solarsyssim.model.Planet;
import com.innoprenez.apps.solarsyssim.model.Star;


/**
 *
 * @author zinhle
 */
public class CelestialComplexPainter implements IPainter
{
    private Canvas canvas;
    
    @Override
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas; 
    }

    @Override
    public void paint(Planet p) { }

    @Override
    public void paint(Moon m) {}

    @Override
    public void paint(Star s) {}

    @Override
    public void paint(Comet c) {}
    
}
