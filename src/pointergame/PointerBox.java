/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.awt.Graphics;
import static pointergame.Box.BOX_SIZE;

/**
 *
 * @author wbolduc
 */
public class PointerBox extends Box{
    private Box pointingTo = null;
    private Arrow arrow = new Arrow(this, null);
    
    PointerBox(int x, int y)
    {
        super(x,y);
        this.pointingTo = BadBox.getInstance();
    }

    //Mutators
    public void setPointer(Box dest)
    {
        pointingTo = dest;
        arrow.setEnd(dest); //for graphics
        dest.addOrigin(this);
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
    public void drawBox(Graphics g)
    {
        g.drawRect(x, y, BOX_SIZE, BOX_SIZE);
        arrow.drawArrow(g);
    }
}
