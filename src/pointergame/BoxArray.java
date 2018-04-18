/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.awt.Graphics;
import java.util.ArrayList;
import static pointergame.Box.BOX_SIZE;

/**
 *
 * @author wbolduc
 */

public class BoxArray extends Box{
    private ArrayList<Box> boxes = new ArrayList<Box>();;
    private int arraySize;
    private Element boxType;
    
    //used for graphics
    private Orientation orientation = Orientation.HORIZONTAL;
    
    BoxArray(int x, int y, ArrayElement arrayDef)
    {
        super(x, y);

        boxType = arrayDef.getType();
        arraySize = arrayDef.getArraySize();

        if (boxType instanceof StructElement)
            for (int i = 0; i < arraySize; i++)
                boxes.add(new BoxStruct(0, 0, (StructElement) boxType));
        else if (boxType instanceof ArrayElement)
            for (int i = 0; i < arraySize; i++)
                boxes.add(new BoxArray(0, 0, (ArrayElement) boxType));
        else
        {
            if (boxType.getElementType() == PointerBox.class)
                for (int i = 0; i < arraySize; i++)
                    boxes.add(new PointerBox(0, 0));
            else //valueBox
                for (int i = 0; i < arraySize; i++)
                    boxes.add(new ValueBox(0, 0));
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
        
        //TODO: FIX THIS
        /*if (box.getClass() != boxType)
        {
            System.err.println("Wrong box type cannot store");
            return;
        }*/
        
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
    
    public Element getBoxType()
    {
        return boxType;
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
    
    public void showChain(String indent)
    {
        String output = "Array of size " + Integer.toString(arraySize);
        
        System.out.println(output);
        
        indent += Box.MIN_INDENT + "| ";
        for (Box b : boxes)
        {
            System.out.print(indent);
            if (b == null)
            {
                System.out.println("null");
            }
            else
            {
                b.showChain(indent);
            }
        }
    }
    
    
    //Graphics
    public void drawBox(Graphics g)
    {
        
    }
}
