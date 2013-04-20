package com.innoprenez.apps.solarsyssim.model;
import android.graphics.Color;
import android.graphics.Rect;

import com.innoprenez.apps.solarsyssim.view.IPaintable;




/**
 * an abstract celestial body
 * @author zinhle
 */
public abstract class CelestialBody implements IPaintable{
    private CelestialBody parent;
    private double orbitDistance;
    private Coordinate center;
    private int color;
    private String name;
    //simulation specific
    private double speed;   //the amount to increment time by
    private double time;    //used to calculate the posotion of the body

    private double size;
    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
    
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public CelestialBody getParent() {
        return parent;
    }

    public double getOrbitDistance() {
        return orbitDistance;
    }

    public Coordinate getCenter() {
        return center;
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name=name;
    }
    
    public void setParent(CelestialBody parent) {
        this.parent = parent;
    }

    public void setOrbitDistance(double orbitDistance) {
        this.orbitDistance = orbitDistance;
    }

    public void setCenter(Coordinate center) {
        this.center = center;
    }

    public void setColor(int color) {
        this.color = color;
    }
    /**
     * calculates the coordinate give time t
     * t is in radians
     * @param t 
     */
    public void move(double t){
        if(parent!=null){
            this.time=t;
            double x=parent.getCenter().getX()+this.orbitDistance*Math.cos(t);
            double y=parent.getCenter().getY()+this.orbitDistance*Math.sin(t);
            this.center=new Coordinate(x, y);
        }
    }
    /**
     * for simulation
     * increments the time by its speed which moves the body
     * through its orbit
     */
    public void move(){
        this.time+=speed;
        if(this.time>=2*Math.PI)
            this.time=0;
        if(parent!=null){
            double x=parent.getCenter().getX()+this.orbitDistance*Math.cos(time);
            double y=parent.getCenter().getY()+this.orbitDistance*Math.sin(time);
            this.center=new Coordinate(x, y);
        }
    }
    public boolean isSelected(int x,int y){
        int offset=(int)size/2;
        Rect r=new Rect((int)center.getX()-offset,(int)center.getY()-offset
                ,(int) size,(int) size);
        return r.contains(x, y);
    }
    
    @Override
    public String toString(){
        return this.name+", "+this.center.toString();
    }
}
