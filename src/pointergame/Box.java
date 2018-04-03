/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.util.ArrayList;

/**
 *
 * @author wbolduc
 */

//TODO: How do you handle if a box is in an array or just being pointed to


public class Box {    
    public static final int BOX_SIZE = 20;
    private int x;
    private int y;
    
    private ArrayList<Box> pointedToBy = new ArrayList<Box>();

    Box(int x, int y)
    {
        this.x = x;
        this.y = y;
    }        
    
    //Setters
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public void setPos(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    //mutators
    public void addOrigin(Box origin)
    {
        pointedToBy.add(origin);
    }
    public void removeOrigin(Box origin)
    {
        pointedToBy.remove(origin);
    }
    
    //Getters
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public ArrayList<Box> getOrigins()
    {
        return pointedToBy;
    }
    
    //Util
    void indentPad(int padSize)
    {
        for (int i = 0; i < padSize; i++)
            System.out.print("  ");
    }
    
    public void showChain()
    {
        this.showChain(0);
    }
    public void showChain(int indentLevel)
    {
        indentPad(indentLevel);
        System.out.println(this.toString() + "     --- if you are seeing this I have not finished implementing this");
    }
    
}
