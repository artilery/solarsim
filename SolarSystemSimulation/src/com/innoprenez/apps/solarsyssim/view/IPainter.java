/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innoprenez.apps.solarsyssim.view;



import android.graphics.Canvas;

import com.innoprenez.apps.solarsyssim.model.Comet;
import com.innoprenez.apps.solarsyssim.model.Moon;
import com.innoprenez.apps.solarsyssim.model.Planet;
import com.innoprenez.apps.solarsyssim.model.Star;

/**
 *
 * @author Bonga Nkosi
 */
public interface IPainter {
    public void setCanvas(Canvas canvas);
    public void paint(Planet p);
    public void paint(Moon m);
    public void paint(Star s);
    public void paint(Comet c);
}
