/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author wbolduc
 */

//TODO: How do you handle if a box is in an array or just being pointed to


public class Box {    
    public static final int BOX_SIZE = 50;
    public static final String MIN_INDENT = "  ";
    protected int x;
    protected int y;
    
    protected Size2D size = new Size2D(BOX_SIZE, BOX_SIZE);
    protected Orientation orientation = Orientation.HORIZONTAL;
    
    private ArrayList<Box> pointedToBy = new ArrayList<Box>();

    Box(int x, int y)
    {
        this.x = x;
        this.y = y;
    }        
    
    Box(int x, int y, Orientation orientation)
    {
        this(x,y);
        this.orientation = orientation;
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
    
    public void moveTo(int x, int y)
    {
        int xChange = x - this.x;
        int yChange = y - this.y;
        
        moveBy(xChange, yChange);
    }
    
    public void moveBy(int x, int y)
    {
        this.x += x;
        this.y += y;
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
    
    public Orientation getOrientation() {
        return orientation;
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
    
    //graphics
    public void drawBox(GraphicsContext gc)
    {
        gc.setStroke(Color.BLUEVIOLET);
        gc.strokeRect(x, y, BOX_SIZE, BOX_SIZE);
        gc.strokeLine(x, y, x + BOX_SIZE, y + BOX_SIZE);
        gc.strokeLine(x, y + BOX_SIZE, x + BOX_SIZE, y);
        gc.setFill(Color.BLACK);
    }
    
}
