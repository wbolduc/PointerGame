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
    
    private void updateLength()
    {
        length = p1.distance(p2);
    }
    
    public boolean isParallel(Line2D line2)
    {
        return this.atOrigin().isParallel(line2.atOrigin());
    }
    
        //NOTE: Wow did I manage to forget a lot of linear algebra, basically had to completely lift this
    public Vector2D intersectionPoint(Line2D line2) //https://www.geeksforgeeks.org/program-for-point-of-intersection-of-two-lines/
    {//assumes point exists
        // Line AB represented as a1x + b1y = c1
        Vector2D A = this.getP1();
        Vector2D B = this.getP2();
        Vector2D C = line2.getP1();
        Vector2D D = line2.getP2();
        
        double a1 = B.getY() - A.getY();
        double b1 = A.getX() - B.getX();
        double c1 = a1*(A.getX()) + b1*(A.getY());
      
        // Line CD represented as a2x + b2y = c2
        double a2 = D.getY() - C.getY();
        double b2 = C.getX() - D.getX();
        double c2 = a2*(C.getX())+ b2*(C.getY());
      
        double determinant = a1*b2 - a2*b1;
      
        if (determinant == 0)
        {
            // The lines are parallel. This is simplified
            // by returning a pair of FLT_MAX
            return new Vector2D(Double.MAX_VALUE, Double.MAX_VALUE);
        }
        else
        {
            double x = (b2*c1 - b1*c2)/determinant;
            double y = (a1*c2 - a2*c1)/determinant;
            return new Vector2D(x, y);
        }
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
