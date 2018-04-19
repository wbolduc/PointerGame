/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.awt.Graphics;

/**
 *
 * @author wbolduc
 */
public class Line2D {
    private double length;
    private Vector2D p1;
    private Vector2D p2;
    
    
    Line2D (double x1, double y1, double x2, double y2)
    {
        p1 = new Vector2D(x1,y1);
        p2 = new Vector2D(x2,y2);
        updateLength();
    }
    Line2D (Vector2D p1, Vector2D p2)
    {
        this.p1 = p1;
        this.p2 = p2;
        updateLength();
    }   
    
    /*
    Line2D (Vector2D point, Vector2D unitVector, Line2D line)   //creates a line from a point all the way to a line intersection
    {
        
    }
    */
    
    private void updateLength()
    {
        length = p1.distance(p2);
    }
    
    public boolean isParallel(Line2D line2)
    {
        return this.atOrigin().isParallel(line2.atOrigin());
    }
    
    public Vector2D intersectionPoint(Line2D line2) //https://stackoverflow.com/questions/563198/how-do-you-detect-where-two-line-segments-intersect
    {//assumes point exists
        Vector2D R = this.atOrigin();
        Vector2D S = line2.atOrigin();
        
        double RcrossS = R.cross(S);
        double ScrossR = -RcrossS;
        
        if (RcrossS == 0)
            return null;
        
        double t = this.p1.subtract(line2.getP1()).cross(S) / RcrossS;
        double u = line2.getP1().subtract(this.p1).cross(R) / ScrossR;
        
        //if (0 <= t && t <= 1 && 0 <= u && u <= 1)
        return this.p1.add(R.scale(t));
    }
    
    public double angle()
    {
        return this.atOrigin().angle();
    }
    
    public double angleBetween(Line2D line2)
    {
        return Math.acos(this.cosThetaAngleBetween(line2));
    }
    
    public double cosThetaAngleBetween(Line2D line2) //returns the cosTheta part of (a DOT b)/(magnitude a * magnitude b) = cos theta -- apply inverse cos to get the angle
    {
        return this.atOrigin().cosThetaAngleBetween(line2.atOrigin());
    }

    public Vector2D atOrigin() //returns an equivalent line, but starting at the origin
    {
        return new Vector2D(p1,p2);
    }
    
    public double getLength() {
        return length;
    }

    public Vector2D getP1() {
        return p1;
    }

    public Vector2D getP2() {
        return p2;
    }

    public void setP1(Vector2D p1) {
        this.p1 = p1;
        updateLength();
    }

    public void setP2(Vector2D p2) {
        this.p2 = p2;
        updateLength();
    }
    
    public void printLine()
    {
        System.out.println(p1.toString() + " --> " + p2.toString());
    }
    
    public void drawLine(Graphics g)
    {
        g.drawLine((int)p1.getX(), (int)p1.getY(), (int)p2.getX(), (int)p2.getY());
    }
}
