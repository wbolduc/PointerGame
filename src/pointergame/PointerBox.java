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
public class PointerBox extends Box{
    private Box pointingTo = null;

    PointerBox(int x, int y)
    {
        super(x,y);
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
    public void showChain(int indentLevel)
    {   
        PointerGame.indentPad(indentLevel);
        
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
