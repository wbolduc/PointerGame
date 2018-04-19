/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

/**
 *
 * @author wbolduc
 */
class Vector2D {
    private double x;
    private double y;
    private double magnitude;

    Vector2D(double x, double y)
    {
        this.x = x;
        this.y = y;
        updateMagnitude();
    }
    
    Vector2D(Vector2D p1, Vector2D p2) //creates a vector between 2 points but starting at the origin
    {
        x = p2.getX() - p1.getX();
        y = p2.getY() - p1.getY();
        updateMagnitude();
    }
    
    Vector2D(Vector2D toCopy)
    {
        x = toCopy.getX();
        y = toCopy.getY();
        updateMagnitude();
    }
    
    public Vector2D add(Vector2D v) //adds a vector to this vector
    {
        return new Vector2D(this.x + v.getX(), this.y + v.getY());
    }
    public Vector2D subtract(Vector2D v) //subtracts a vector from this vector
    {
        return new Vector2D(this.x - v.getX(), this.y - v.getY());
    }
    public Vector2D scale(double scalar)
    {
        return new Vector2D(this.x * scalar, this.y * scalar);
    }
    
    public Vector2D toUnit()
    {
        return new Vector2D(this.x / magnitude, this.y / magnitude);
    }
    
    public boolean isParallel(Vector2D v)
    {
        Vector2D t1 = new Vector2D(this);
        Vector2D t2 = new Vector2D(v);
        
        t1.toUnit();
        t2.toUnit();
        
        if(t1.equals(t2))
            return true;
        
        t2.scale(-1);
        if (t1.equals(t2))
            return true;
        
        return false;
    }
    
    public boolean equals(Vector2D v)
    {
        return this.x == v.getX() && this.y == v.getY();
    }
    
    public double angle()
    {
        double angle = Math.atan2(y, x);
        if (y<0)
            return Math.PI*2 + angle;
        return angle;

    }
    
    public double angleBetween(Vector2D v)
    {
        return Math.acos(cosThetaAngleBetween(v));
    }
    
    public double cosThetaAngleBetween(Vector2D v) //returns the cosTheta part of (a DOT b)/(magnitude a * magnitude b) = cos theta -- apply inverse cos to get the angle
    {
        return this.dot(v)/(magnitude * v.getMagnitude());
    }
    
    public double dot(Vector2D v)
    {
        return v.getX()*x + v.getY()*y;
    }
    
    public double cross(Vector2D v)
    {
        return v.getX()*y - v.getY()*x;
    }
    
    public double distance(Vector2D v)
    {
        return Math.sqrt(Math.pow(v.getX() - x, 2) + Math.pow(v.getY() - y, 2));
    }
    
    
    private void updateMagnitude()
    {
        magnitude = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }    
 
    
    //getters/setters    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setX(double x) {
        this.x = x;
        updateMagnitude();
    }

    public void setY(double y) {
        this.y = y;
        updateMagnitude();
    }
    
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
}
