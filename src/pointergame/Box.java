/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author wbolduc
 */

//TODO: How do you handle if a box is in an array or just being pointed to


public class Box {    
    public static final String MIN_INDENT = "  ";
    
    private ArrayList<Box> pointedToBy = new ArrayList<Box>();
   
    //mutators
    public void addOrigin(Box origin)
    {
        pointedToBy.add(origin);
    }
    public void removeOrigin(Box origin)
    {
        pointedToBy.remove(origin);
    }
    
    protected ArrayList<Box> getOrigins()
    {
        return pointedToBy;
    }
    
    /*    
    //pointer expression generation
    public String getExpressionTo(Box dest)
    {
        return getExpressionTo(dest, new HashSet<Box>());
    }
    private String getExpressionTo(Box dest, HashSet<Box> visited)
    {//depth first search
        visited.add(this);
        for (Box e : pointedToBy)
        {
            if (visited.contains(e))
                continue;
            else if (e == dest)
                this.generateAccessExpression(dest);
            else
            {
                String ret = e.getExpressionTo(dest, visited);
                
            }            
        }
        
    }
    
    private String generateAccessExpression(Box toAccess)
    {
        System.err.println(this.toString() + " generateAccessExpression not implemented");
        return "Oh Nooo!";
    }
    */
    public void showChain()
    {
        this.showChain("");
    }
    public void showChain(String indent)
    {
        System.out.println(this.toString() + "     --- if you are seeing this I have not finished implementing this");
    }
}
