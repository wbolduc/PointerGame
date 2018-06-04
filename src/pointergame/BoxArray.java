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

public class BoxArray extends Box{
    private ArrayList<Box> boxes = new ArrayList<Box>();
    private int arraySize;
    private Element arrayElementType;
    private ElementArray arrayDef;
    //used for graphics
    private Orientation orientation;
    
    BoxArray(int x, int y, ElementArray arrayDef)
    {
        super(x, y);
        this. arrayDef = arrayDef;
        
        arrayElementType = arrayDef.getIndexType();
        arraySize = arrayDef.getArraySize();
        orientation = arrayDef.orientation; //TODO: should probably just use the ElementArray
        
        Size2D elementSize = arrayElementType.get2DSize();
        Class type = arrayElementType.getType();
        
        if (orientation == Orientation.VERTICAL)
        {
            if (type == ElementStruct.class)
            {
                for (int i = 0; i < arraySize; i++)
                    boxes.add(new BoxStruct(x, y + i*elementSize.y, (ElementStruct) arrayElementType));
            }
            else if (type == ElementArray.class)
            {
                for (int i = 0; i < arraySize; i++)
                    boxes.add(new BoxArray(x, y + i*elementSize.y, (ElementArray) arrayElementType));
            }
            else if (type == PointerBox.class)
            {
                for (int i = 0; i < arraySize; i++)
                    boxes.add(new PointerBox(x, y + i*elementSize.y));
            }
            else //valueBox
            {
                for (int i = 0; i < arraySize; i++)
                    boxes.add(new ValueBox(x, y + i*elementSize.y));
            }
        }
        else //orientation horizontal
        {
            if (type == ElementStruct.class)
            {
                for (int i = 0; i < arraySize; i++)
                    boxes.add(new BoxStruct(x + i*elementSize.x, y, (ElementStruct) arrayElementType));
            }
            else if (type == ElementArray.class)
            {
                for (int i = 0; i < arraySize; i++)
                    boxes.add(new BoxArray(x + i*elementSize.x, y, (ElementArray) arrayElementType));
            }
            else if (type == PointerBox.class)
            {
                for (int i = 0; i < arraySize; i++)
                    boxes.add(new PointerBox(x + i*elementSize.x, y));
            }
            else //valueBox
            {
                for (int i = 0; i < arraySize; i++)
                    boxes.add(new ValueBox(x + i*elementSize.x, y));
            }
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
        /*if (box.getClass() != arrayElementType)
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
        return arrayElementType;
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
    @Override
    public void drawBox(GraphicsContext gc)
    {
        gc.setStroke(Color.GREEN);
        gc.strokeRect(x-2, y-2, arrayDef.size.x+4, arrayDef.size.y+4);
        System.out.println(boxes.size());
        for (Box b : boxes)
        {
            b.drawBox(gc);
        }
    }
}
