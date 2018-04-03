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
public class BoxArray extends Box{
    private ArrayList<Box> boxes = new ArrayList<Box>();;
    private int arraySize;
    
    BoxArray(int x, int y, PointerBox origin, int arraySize)
    {
        super(x, y, origin);
        
        this.arraySize = arraySize;
        
        for (int i = 0; i < arraySize; i++)
        {
            boxes.add(BadBox.getInstance());
        }
    }
    
    
    //Util
    public void showChain()
    {
        this.showChain(0);
    }
    public void showChain(int indentLevel)
    {
        indentPad(indentLevel);
        System.out.println("ArraySize = " + Integer.toString(arraySize));
        for (Box b : boxes)
        {
            b.showChain(indentLevel + 1);
        }
    }
    
}
