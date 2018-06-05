/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author wbolduc
 */
public class PointerBox extends Box{
    private Box pointingTo = null;
    
    PointerBox(int x, int y)
    {
        super(x,y);
        this.pointingTo = BadBox.getInstance();
    }
    PointerBox(int x, int y, Orientation orientation)
    {
        this(x,y);
        this.orientation = orientation;
    }

    //Mutators
    public PointerBox setPointer(Box dest)
    {
        if (pointingTo != null)
        {
            pointingTo.removeOrigin(this);
        }
        
        pointingTo = dest;
        
        if (dest != null)
            dest.addOrigin(this);
        
        return this;
    }
    
    //Getters
    public Box getDest()
    {
        return pointingTo;
    }
    
    //Util
    public void showChain(String indent)
    {   
        System.out.print(indent);        
        System.out.print("PointerBox pointing to ");
        if(pointingTo == null)
        {
            System.out.println("null");
        }
        else
        {
            pointingTo.showChain();
        }
    }
    
    //graphics
    public void drawBox(GraphicsContext gc)
    {
        gc.setStroke(Color.BLACK);
        gc.strokeRect(x, y, size.x, size.y);
        
        if (pointingTo == null)
        {
            gc.setStroke(Color.BLUE);
            gc.strokeOval(x, y, size.x, size.y);
        }
        else if (pointingTo instanceof BadBox)
        {
            System.out.println("Gotta add bad box pointers");
        }
        else
        {
            
            CustomShape.arrow(gc, x+size.x/2, y+size.y/2, pointingTo.x+size.x/2, pointingTo.y+size.y/2, 10, 15, Color.BLUE);
            
            //gc.strokeLine(x+BOX_SIZE/2, y+BOX_SIZE/2, pointingTo.x+BOX_SIZE/2, pointingTo.y+BOX_SIZE/2);
        }
    }
}
