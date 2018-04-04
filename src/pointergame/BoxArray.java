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
    private Class boxType;
    
    BoxArray(int x, int y, int arraySize, Class boxType)
    {
        super(x, y);
        
        this.boxType = boxType;
        this.arraySize = arraySize;
        
        for (int i = 0; i < arraySize; i++)
        {
            boxes.add(BadBox.getInstance());
        }
    }
    
    //Setters
    public void setBoxAt(Box box, int index)
    {
        //check for ranges
        if (!inRange(index))
            return;
        
        //check for null
        if (box != null)
        {
            box.addOrigin(this);
        }
        
        //check for matching type
        if (box.getClass() != boxType)
        {
            System.err.println("Wrong box type cannot store");
            return;
        }
        
        boxes.set(index, box);
    }
    
    //Getters
    public Box getBoxAt(int index)
    {
        //check for ranges
        if (!inRange(index))
            return BadBox.getInstance();
        
        return boxes.get(index);
    }
    
    //Util    
    private boolean inRange(int index)
    {
        if (index < 0)
        {
            System.err.println("index less than 0");
            return false;
        }
        if (index >= arraySize)
        {
            System.err.println("index out of bounds");
            return false;
        }
        return true;
    }
    
    public void showChain(int indentLevel)
    {
        PointerGame.indentPad(indentLevel);
        System.out.println("Array of size " + Integer.toString(arraySize));
        for (Box b : boxes)
        {
            if (b == null)
            {
                indentPad(indentLevel + 1);
                System.out.println("null");
            }
            else
            {
                b.showChain(indentLevel + 1);
            }
        }
    }
    
}
