/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innoprenez.apps.solarsyssim.view;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.innoprenez.apps.solarsyssim.R;
import com.innoprenez.apps.solarsyssim.model.CelestialBody;
import com.innoprenez.apps.solarsyssim.model.Comet;
import com.innoprenez.apps.solarsyssim.model.Coordinate;
import com.innoprenez.apps.solarsyssim.model.Moon;
import com.innoprenez.apps.solarsyssim.model.Planet;
import com.innoprenez.apps.solarsyssim.model.Star;

/**
 *
 * @author Bonga Nkosi
 */
public class CelestialRenderView extends SurfaceView implements Runnable
{
    private ArrayList<CelestialBody> bodies;
    private IPainter celestialPainter;
    private Thread animationThread;
    private SurfaceHolder mHolder;
    volatile boolean running = false;
    private static int tries =  0; 
    
    public CelestialRenderView(Context context, AttributeSet attrs)
    {
    	super(context, attrs); 
    	init();
    }
    public CelestialRenderView(Context context, AttributeSet attrs, int defStyle)
    {
    	super(context, attrs, defStyle); 
    	init();
    }
    
    public void init()
    {
    	//this.setBackgroundResource(R.drawable.fragment_background);
    	bodies = new ArrayList<CelestialBody>();
        celestialPainter=new CelestialPainter();
        mHolder = getHolder();
    }
    
    public void resume() 
    { 
    	running = true;
    	animationThread = new Thread(this);
    	animationThread.start();
    }
    
    public void pause() 
    { 
    	running = false;
    	while(true) 
    	{ 
    		try 
    		{
    			animationThread.join();
    		} 
    		catch (InterruptedException e) 
    		{
    			
    		}
    	}
    }
    
    
    //
   /* public void startSimulation()
    {
        try
        {
            animationThread.start();
        }
        catch(IllegalThreadStateException e)
        {
            animationThread.resume();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }*/
    
   /* public void stopSimulation(){
        animationThread.suspend();
    }*/
    
   
    public void renderSimulation(Canvas canvas)
    {
        
    	canvas.drawARGB(255, 0, 0, 0);
    	
        //star field
        Paint painter =  new Paint();
        painter.setColor(Color.LTGRAY);
        
        for(int i=0;i<50;i++)
        {
           canvas.drawText("*",(int) (Math.random()*canvas.getWidth()), (int)(Math.random()*canvas.getHeight()), painter);
        }
        //first give painter the graphics
        celestialPainter.setCanvas(canvas);
        for(CelestialBody b:bodies){
            b.accept(celestialPainter);
        }
    }

    //@Override
    /*public void mouseClicked(MouseEvent e) 
    {
        for (CelestialBody b:bodies){
            if(b.isSelected(e.getX(), e.getY()))
                updatable.update(b);
        }
    }*/
    
   
    
    public void run()
    {
    	while(running) 
    	{
    		if(!mHolder.getSurface().isValid()) 
    			continue;
    		
    		 for(CelestialBody b:bodies)
             {
                 b.move();
             }
    		Canvas canvas = mHolder.lockCanvas(); 
    		
    		if(tries == 0){
    			initializeBodies(canvas.getWidth(), canvas.getHeight());
    			tries++;
    		}
    		renderSimulation(canvas);
    		mHolder.unlockCanvasAndPost(canvas);
    		
    		//invalidate();
    		
    		/* try
    		 {
    			 //Sleeps for 40 ms
                 Thread.sleep(20);
             }
             catch(InterruptedException e)
             {
                 e.printStackTrace();
             }*/
    	}
    	
    }
    private void initializeBodies(int width, int height){
        //setting up our solar system
        //sun
        Star sun=new Star();
       // int width  = canvas.getWidth();
        //int height =  canvas.getHeight();
        
        Log.i("Dimensions", "h:" + height + "w:" + width); 
        
        sun.setCenter(new Coordinate(width/2, height/2));
        bodies.add(sun);
        //mercury
        Planet mercury=new Planet();
        mercury.setName("Mercury");
        mercury.setHabitable(Math.random());
        mercury.setParent(sun);
        mercury.setOrbitDistance(60);
        mercury.move(Math.random());
        mercury.setSpeed(0.018);
        bodies.add(mercury);
        //venus
        Planet venus=new Planet();
        venus.setName("Venus");
        venus.setHabitable(Math.random());
        venus.setParent(sun);
        venus.setOrbitDistance(90);
        venus.move(Math.random());
        venus.setSpeed(0.017);
        bodies.add(venus);
        //earth
        Planet earth=new Planet();
        earth.setName("Earth");
        earth.setHabitable(Math.random());
        earth.setParent(sun);
        earth.setOrbitDistance(120);
        earth.move(Math.random());
        earth.setSpeed(0.016);
        bodies.add(earth);
        //mars
        Planet mars=new Planet();
        mars.setName("Mars");
        mars.setHabitable(Math.random());
        mars.setParent(sun);
        mars.setOrbitDistance(150);
        mars.move(Math.random());
        mars.setSpeed(0.015);
        bodies.add(mars);
        
        Moon phobos=new Moon();
        phobos.setName("Phobos");
        phobos.setParent(mars);
        phobos.setOrbitDistance(35);
        phobos.setSpeed(0.054);
        phobos.move(Math.random());
        bodies.add(phobos);
        
        Moon deimos=new Moon();
        deimos.setName("Deimos");
        deimos.setParent(mars);
        deimos.setOrbitDistance(35);
        deimos.setSpeed(0.058);
        deimos.move(Math.random());
        bodies.add(deimos);
        //jupiter
        Planet jupiter=new Planet();
        jupiter.setName("Jupiter");
        jupiter.setHabitable(Math.random());
        jupiter.setParent(sun);
        jupiter.setOrbitDistance(180);
        jupiter.move(Math.random());
        jupiter.setSpeed(0.014);
        bodies.add(jupiter);
        
        Moon io=new Moon();
        io.setName("Io");
        io.setParent(jupiter);
        io.setOrbitDistance(35);
        io.setSpeed(0.054);
        io.move(Math.random());
        bodies.add(io);
        
        Moon europa=new Moon();
        europa.setName("Europa");
        europa.setParent(jupiter);
        europa.setOrbitDistance(35);
        europa.setSpeed(0.058);
        europa.move(Math.random());
        bodies.add(europa);
        //saturn
        Planet saturn=new Planet();
        saturn.setName("Saturn");
        saturn.setHabitable(Math.random());
        saturn.setParent(sun);
        saturn.setOrbitDistance(210);
        saturn.move(Math.random());
        saturn.setSpeed(0.013);
        bodies.add(saturn);
        //uranus
        Planet uranus=new Planet();
        uranus.setName("Uranus");
        uranus.setHabitable(Math.random());
        uranus.setParent(sun);
        uranus.setOrbitDistance(240);
        uranus.move(Math.random());
        uranus.setSpeed(0.012);
        bodies.add(uranus);
        //neptune
        Planet neptune=new Planet();
        neptune.setName("Neptune");
        neptune.setHabitable(Math.random());
        neptune.setParent(sun);
        neptune.setOrbitDistance(270);
        neptune.move(Math.random());
        neptune.setSpeed(0.011);
        bodies.add(neptune);
        
        Moon m=new Moon();
        m.setName("Earth's moon");
        m.setParent(earth);
        m.setOrbitDistance(35);
        m.setSpeed(0.05);
        m.move(1);
        bodies.add(m);
        //comet
        Comet c=new Comet();
        c.setTrailLength(20);
        c.setParent(sun);
        c.setOrbitDistance(160);
        c.move(1);
        c.setSpeed(0.03);
        bodies.add(c);
    }
    public void clearBodies() 
    {
        bodies=new ArrayList<CelestialBody>();
        //repaint();
       // invalidate();
    }
    public ArrayList<CelestialBody> getBodies(){
        return bodies;
    }

	

	

	
}
