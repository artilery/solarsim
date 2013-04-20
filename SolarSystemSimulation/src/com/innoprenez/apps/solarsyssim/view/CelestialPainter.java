
package com.innoprenez.apps.solarsyssim.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;

import com.innoprenez.apps.solarsyssim.model.Comet;
import com.innoprenez.apps.solarsyssim.model.Moon;
import com.innoprenez.apps.solarsyssim.model.Planet;
import com.innoprenez.apps.solarsyssim.model.Star;



/**
 *
 * @author Bonga Nkosi
 */
public class CelestialPainter implements IPainter
{
    private Canvas canvas;
    
    public static final int PLANET_SIZE=20;
    public static final int MOON_SIZE=15;
    public static final int STAR_SIZE=50;
    public static final int COMET_SIZE=10;
    
    @Override
    public void setCanvas(Canvas canvas) 
    {
        this.canvas = canvas;
    }
    
    

    @Override
    public void paint(Planet p) 
    {
        p.setSize(PLANET_SIZE);
        //use graphics to draw planet
       
        Paint painter =  new Paint();
        painter.setColor(Color.GRAY);
        painter.setStyle(Paint.Style.STROKE);
        
        //draw line of orbit
        int orbit_x1 = (int) (p.getParent().getCenter().getX() - p.getOrbitDistance()); 
        int orbit_y1 = (int) (p.getParent().getCenter().getY() - p.getOrbitDistance());
        int orbit_x2 = (int) (p.getParent().getCenter().getX() + p.getOrbitDistance()); 
        int orbit_y2 = (int) (p.getParent().getCenter().getY() + p.getOrbitDistance()); 
        RectF planet_orbit =  new RectF(orbit_x1,orbit_y1,orbit_x2,orbit_y2); 
        canvas.drawOval(planet_orbit, painter);
        
        //Draws the planet
        int offset = PLANET_SIZE/2;
        int planet_x1 = (int)p.getCenter().getX() - offset;
        int planet_y1 = (int)p.getCenter().getY() - offset;
        int planet_x2 = (int)p.getCenter().getX() + offset;
        int planet_y2 = (int)p.getCenter().getY() + offset;
        RectF planetOval = new RectF(planet_x1,planet_y1,planet_x2,planet_y2); 
        
        //Draws the filled planet
        painter.setColor(p.getColor());
        painter.setStyle(Paint.Style.FILL);
        canvas.drawOval(planetOval, painter);
        
        //Draws the outline color
        painter.setColor(Color.BLACK);
        painter.setStyle(Paint.Style.STROKE);
        canvas.drawOval(planetOval,  painter);
        
        //draw body name
        painter.setColor(Color.WHITE);
        painter.setStyle(Paint.Style.FILL);
        canvas.drawText(p.getName(), planet_x1 + PLANET_SIZE, planet_y1 + PLANET_SIZE, painter);
        
        //draw lines
        painter.setColor(Color.BLACK);
        canvas.drawLine(planet_x1 + offset, planet_y1, planet_x1  + offset, planet_y1 + PLANET_SIZE,painter);
        canvas.drawLine(planet_x1, planet_y1 + offset, planet_x1 + PLANET_SIZE, planet_y1 + offset ,painter);
        
        //link to parent
        painter.setColor(Color.RED);
        canvas.drawLine((int)p.getCenter().getX(),(int)p.getCenter().getY()
                ,(int)p.getParent().getCenter().getX(),
                (int)p.getParent().getCenter().getY(), painter);
    }

    @Override
    public void paint(Moon m) 
    {
        Paint painter =  new Paint();
        
        m.setSize(MOON_SIZE);
       
       
        //draw line of orbit
        painter.setColor(Color.GRAY);
        painter.setStyle(Paint.Style.STROKE); 
      
        int orbit_x1 = (int) (m.getParent().getCenter().getX() - m.getOrbitDistance());
        int orbit_y1 = (int) (m.getParent().getCenter().getY()- m.getOrbitDistance());
        int orbit_x2 = (int) (m.getParent().getCenter().getX() + m.getOrbitDistance());
        int orbit_y2 = (int) (m.getParent().getCenter().getY() + m.getOrbitDistance());
        
        RectF moon_orbit = new RectF(orbit_x1,orbit_y1,orbit_x2, orbit_y2);
        canvas.drawOval(moon_orbit, painter);
        
        //Paints the moon
        int offset=MOON_SIZE/2;
        int moon_x1 = (int)m.getCenter().getX()-offset;
        int moon_y1 = (int)m.getCenter().getY()-offset;
        int moon_x2 = (int)m.getCenter().getX()+offset;
        int moon_y2 = (int)m.getCenter().getY()+offset;
        RectF moonOval =  new RectF(moon_x1, moon_y1, moon_x2, moon_y2);
        
        //Draw a filled body 
        painter.setColor(m.getColor());
        painter.setStyle(Paint.Style.FILL);
        canvas.drawOval(moonOval, painter);
        
        //Draw the black outline for the filled body
        painter.setColor(Color.BLACK);
        painter.setStyle(Paint.Style.STROKE); 
        canvas.drawOval(moonOval, painter);
        
        //Draw body name
        painter.setColor(Color.WHITE);
        painter.setStyle(Paint.Style.FILL);
        canvas.drawText(m.getName(), moon_x1+MOON_SIZE, moon_y1+MOON_SIZE, painter);
        
        //link to parent
        painter.setColor(Color.RED);
        canvas.drawLine((int)m.getCenter().getX(),(int)m.getCenter().getY()
                ,(int)m.getParent().getCenter().getX(),
                (int)m.getParent().getCenter().getY(), painter);
        
    }

    @Override
    public void paint(Star s) 
    {
        s.setSize(STAR_SIZE);
        Paint painter =  new Paint();
        painter.setColor(s.getColor());
        painter.setStyle(Paint.Style.FILL);
        
        int offset=STAR_SIZE/2;
        
        int star_x1=(int)s.getCenter().getX()-offset;
        int star_y1=(int)s.getCenter().getY()-offset;
        int star_x2= (int)s.getCenter().getX()+offset;
        int star_y2= (int)s.getCenter().getY()+offset;
        
        RectF starOval =  new RectF(star_x1,star_y1, star_x2, star_y2);
        canvas.drawOval(starOval, painter);
        
        painter.setColor(Color.BLACK);
        painter.setStyle(Paint.Style.STROKE);
        canvas.drawOval(starOval, painter);
        
        //draw body name
        painter.setColor(Color.WHITE);
        painter.setStyle(Paint.Style.FILL);
        canvas.drawText(s.getName(), star_x1+STAR_SIZE, star_y1+STAR_SIZE, painter);
    }

    @Override
    public void paint(Comet c) 
    {
       c.setSize(COMET_SIZE);
        
        
        //draw line of orbit
        Paint painter =  new Paint();
        painter.setColor(Color.CYAN);
        painter.setStyle(Paint.Style.STROKE);
        
        int orbit_x1 = (int) (c.getParent().getCenter().getX() - c.getOrbitDistance());
        int orbit_y1 = (int) (c.getParent().getCenter().getY() - c.getOrbitDistance());
        int orbit_x2 = (int) (c.getParent().getCenter().getX() + c.getOrbitDistance());
        int orbit_y2 = (int) (c.getParent().getCenter().getY() + c.getOrbitDistance());
        
        RectF comet_orbit = new RectF(orbit_x1,orbit_y1,orbit_x2,orbit_y2);
        canvas.drawOval(comet_orbit, painter);
        
        
        int offset=COMET_SIZE/2;
        int comet_x1=(int)c.getCenter().getX() - offset;
        int comet_y1=(int)c.getCenter().getY() - offset;
        int comet_x2=(int)c.getCenter().getX() + offset;
        int comet_y2=(int)c.getCenter().getY() + offset;
        RectF cometOval =  new RectF(comet_x1,comet_y1, comet_x2, comet_y2);
        
       //comet
        painter.setColor(c.getColor());
        painter.setStyle(Paint.Style.FILL);
        canvas.drawOval(cometOval, painter);
        
        painter.setColor(Color.BLACK);
        painter.setStyle(Paint.Style.STROKE);
        canvas.drawOval(cometOval, painter);
        
        //draws a flair
       /* int [] xVals={x+(COMET_SIZE/2),x+COMET_SIZE+(int)c.getTrailLength(),x+(COMET_SIZE/2)};
        int [] yVals={y,y+(COMET_SIZE/2),y+COMET_SIZE};
        
        Path path =  new Path();
        painter.setColor(Color.rgb(255,102, 0));
        painter.setStyle(Paint.Style.FILL);
        
        path.moveTo(xVals[0], yVals[0]);
        path.lineTo(xVals[1], yVals[1]);
        path.lineTo(xVals[2], yVals[2]);
        
       // canvas.dPolygon(xVals, yVals, 3);
        canvas.drawPath(path, painter);
        
        int [] xvals={x+(COMET_SIZE/2),x+COMET_SIZE+(int)c.getTrailLength(),x+(COMET_SIZE/2),
            (int)c.getCenter().getX(),x+COMET_SIZE+(int)c.getTrailLength()};
        int [] yvals={y,y+(COMET_SIZE/2),y+COMET_SIZE,(int)c.getCenter().getY(),y+COMET_SIZE/2};
        
        painter.setColor(Color.BLACK);
        painter.setStyle(Paint.Style.STROKE);
        Path outline =  new Path();
        outline.moveTo(xvals[0], yvals[0]);
        outline.lineTo(xvals[1], yvals[1]);
        outline.lineTo(xvals[2], yvals[2]);
        outline.lineTo(xvals[3], yvals[3]);
        outline.lineTo(xvals[4], yvals[4]);
        
        //graphics.drawPolyline(xvals, yvals, 5);
       
        canvas.drawPath(outline, painter);*/
        
        
        
        //draw body name
        painter.setColor(Color.WHITE);
        painter.setStyle(Paint.Style.FILL);
        canvas.drawText(c.getName(), comet_x1+COMET_SIZE*2, comet_y1+COMET_SIZE, painter);
    }
    
}
