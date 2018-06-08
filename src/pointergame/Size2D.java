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
public class Size2D{
    public int x;
    public int y;
    public Size2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Size2D clone()
    {
        return new Size2D(x,y);
    }
    
    public Size2D incrementBy(Size2D increment)
    {
        x += increment.x;
        y += increment.y;
        return this;
    }
    public Size2D incrementBy(int x, int y)
    {
        this.x += x;
        this.y += y;
        return this;
    }
}