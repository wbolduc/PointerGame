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

    PointerBox(int x, int y, PointerBox origin, Box pointingTo)
    {
        super(x, y, origin);
        this.pointingTo = pointingTo;
    }

    //Mutators
    void setPointer(Box dest)
    {
        pointingTo = dest;
    }
    
    //Getters
    Box getDest()
    {
        return pointingTo;
    }
    
}
