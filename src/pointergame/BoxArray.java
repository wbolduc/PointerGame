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
    private Def arrayElementType;
    private DefArray arrayDef;
    //used for graphics
    private Orientation orientation;
    
    BoxArray(int x, int y, Orientation orientation, DefArray arrayDef)
    {
        super(x, y);
        this.arrayDef = arrayDef;
        arrayElementType = arrayDef.getIndexType();
        arraySize = arrayDef.getArraySize();

        this.orientation = orientation;
        
        Class type = arrayElementType.getType();
        
        
        size = new Size2D(0,0);
        Box toAdd = null;
        if (arraySize <= 0) //nothing to draw or add
            return;
        
        if (orientation == Orientation.VERTICAL)
        {
            if (type == DefStruct.class)
            {
                for (int i = 0; i < arraySize; i++)
                {
                    //Add Box to array
                    toAdd = new BoxStruct(x, y + size.y, Orientation.HORIZONTAL, (DefStruct) arrayElementType);
                    boxes.add(toAdd);
                    //increase array graphical size by the size of that box
                    size.y += toAdd.size.y;
                }
            }
            else if (type == DefArray.class)
            {
                for (int i = 0; i < arraySize; i++)
                {
                    //Add Box to array
                    toAdd = new BoxArray(x, y + size.y, Orientation.HORIZONTAL, (DefArray) arrayElementType);
                    boxes.add(toAdd);
                    //increase array graphical size by the size of that box
                    size.y += toAdd.size.y;
                }
            }
            else if (type == PointerBox.class)
            {
                for (int i = 0; i < arraySize; i++)
                {
                    //Add Box to array
                    toAdd = new PointerBox(x, y + size.y, Orientation.HORIZONTAL);
                    boxes.add(toAdd);
                    //increase array graphical size by the size of that box
                    size.y += toAdd.size.y;
                }
            }
            else //valueBox
            {
                for (int i = 0; i < arraySize; i++)
                {
                    //Add Box to array
                    toAdd = new ValueBox(x, y + size.y);
                    boxes.add(toAdd);
                    //increase array graphical size by the size of that box
                    size.y += toAdd.size.y;
                }
            }
            size.x = toAdd.size.x;
        }
        else //orientation horizontal
        {
            if (type == DefStruct.class)
            {
                for (int i = 0; i < arraySize; i++)
                {
                    //Add Box to array
                    toAdd = new BoxStruct(x + size.x, y, Orientation.VERTICAL, (DefStruct) arrayElementType);
                    boxes.add(toAdd);
                    //increase array graphical size by the size of that box
                    size.x += toAdd.size.x;
                }
            }
            else if (type == DefArray.class)
            {
                for (int i = 0; i < arraySize; i++)
                {
                    //Add Box to array
                    toAdd = new BoxArray(x + size.x, y, Orientation.VERTICAL, (DefArray) arrayElementType);
                    boxes.add(toAdd);
                    //increase array graphical size by the size of that box
                    size.x += toAdd.size.x;
                }
            }
            else if (type == PointerBox.class)
            {
                for (int i = 0; i < arraySize; i++)
                {
                    //Add Box to array
                    toAdd = new PointerBox(x + size.x, y, Orientation.VERTICAL);
                    boxes.add(toAdd);
                    //increase array graphical size by the size of that box
                    size.x += toAdd.size.x;
                }
            }
            else //valueBox
            {
                for (int i = 0; i < arraySize; i++)
                {
                    //Add Box to array
                    toAdd = new ValueBox(x + size.x, y);
                    boxes.add(toAdd);
                    //increase array graphical size by the size of that box
                    size.x += toAdd.size.x;
                }
            }
            size.y = toAdd.size.y;
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
    
    public Def getBoxType()
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
        gc.strokeRect(x-2, y-2, size.x+4, size.y+4);
        System.out.println(boxes.size());
        for (Box b : boxes)
        {
            b.drawBox(gc);
        }
    }
}
