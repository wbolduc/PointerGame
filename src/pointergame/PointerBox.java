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
public class PointerBox extends Box{
    private Box pointingTo = null;
    
    PointerBox()
    {
        this.pointingTo = BadBox.getInstance();
    }

    //Mutators
    public void setPointer(Box dest)
    {
        pointingTo = dest;
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
}
