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
    private Def arrayElementDef;
    private DefArray arrayDef;
    //used for graphics
    private Orientation orientation;
    
    BoxArray(int x, int y, Orientation orientation, DefArray arrayDef)
    {
        super(x, y);
        this.arrayDef = arrayDef;
        arrayElementDef = arrayDef.indexType;
        arraySize = arrayDef.arraySize;

        this.orientation = orientation;
        
        Class type = arrayElementDef.type;
        
        
        size = new Size2D(0,0);
        Box toAdd = null;
        if (arraySize <= 0) //nothing to draw or add
            return;
        
        if (orientation == Orientation.VERTICAL)
        {
            if (type == BoxStruct.class)
            {
                for (int i = 0; i < arraySize; i++)
                {
                    //Add Box to array
                    toAdd = new BoxStruct(x, y + size.y, Orientation.VERTICAL, (DefStruct) arrayElementDef);
                    boxes.add(toAdd);
                    //increase array graphical size by the size of that box
                    size.y += toAdd.size.y;
                }
            }
            else if (type == BoxArray.class)
            {
                for (int i = 0; i < arraySize; i++)
                {
                    //Add Box to array
                    toAdd = new BoxArray(x, y + size.y, Orientation.VERTICAL, (DefArray) arrayElementDef);
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
            if (type == BoxStruct.class)
            {
                for (int i = 0; i < arraySize; i++)
                {
                    //Add Box to array
                    toAdd = new BoxStruct(x + size.x, y, Orientation.HORIZONTAL, (DefStruct) arrayElementDef);
                    boxes.add(toAdd);
                    //increase array graphical size by the size of that box
                    size.x += toAdd.size.x;
                }
            }
            else if (type == BoxArray.class)
            {
                for (int i = 0; i < arraySize; i++)
                {
                    //Add Box to array
                    toAdd = new BoxArray(x + size.x, y, Orientation.HORIZONTAL, (DefArray) arrayElementDef);
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
        effectiveSize = size.clone().incrementBy(MIN_SPACING);
    }
    
    //Setters    
    public void moveBy(int x, int y)
    {
        this.x += x;
        this.y += y;
        for (Box b : boxes)
        {
            b.moveBy(x, y);
        }
    }
    
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
        /*if (box.getClass() != arrayElementDef)
        {
            System.err.println("Wrong box type cannot store");
            return;
        }*/
        
        boxes.set(index, box);
    }
    
    
    //Getters
    public ArrayList<Box> getBoxes()
    {
        return boxes;
    }
    
    public Box getBoxAt(int index)
    {
        //check for ranges
        if (!inRange(index))
            return BadBox.getInstance();
        
        return boxes.get(index);
    }
    
    public Def getBoxType()
    {
        return arrayElementDef;
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
    
    public Size2D setArrange(int x, int y)  //moves this structure and calls arrange
    {
        this.moveTo(x, y);
        Size2D connectedSize = this.arrange(x, y);
        
        if (orientation == Orientation.VERTICAL)
        {
            effectiveSize.x += connectedSize.x;
            if (effectiveSize.y < connectedSize.y)
                effectiveSize.y = connectedSize.y;
        }
        else
        {
            effectiveSize.y += connectedSize.y;
            if (effectiveSize.x < connectedSize.x)
                effectiveSize.x = connectedSize.x;
        }
        return effectiveSize;
    }
    
    public Size2D arrange(int x, int y)     //arranges things connected to this structure by pointer
    {
        Size2D connectedSize = new Size2D(0,0); //the size of the things connected to this structure by pointers
        Size2D subSize;
        
        if (orientation == Orientation.VERTICAL)
        {
            for(Box b : boxes)
            {
                subSize = b.arrange(x + size.x + MIN_SPACING.x, y + connectedSize.y);
                connectedSize.y += subSize.y;
                if (connectedSize.x < subSize.x)
                    connectedSize.x = subSize.x;
            }
        }
        else //horizontal
        {
            for(Box b : boxes)
            {
                subSize = b.arrange(x + connectedSize.x, y + size.y + MIN_SPACING.y);
                connectedSize.x += subSize.x;
                if (connectedSize.y < subSize.y)
                    connectedSize.y = subSize.y;
            }
        }
        return connectedSize;
    }
    
    
    /*
    public void arrange()
    {
        if (arrayElementDef.type == PointerBox.class)
        {
            
        }
        
        Size2D pointingSize;
        int offset = 0;
        if (orientation.VERTICAL == orientation)
        {
            for (Box b : boxes)
            {
                pointingSize = b.getEffectiveSize();
                b.moveTo(x+size.x + MIN_SPACING, y + offset);
                offset += pointingSize.y;
            }
        }
        else
        {
            for (Box b : boxes)
            {
                pointingSize = b.getEffectiveSize();
                b.moveTo(x + offset, y+size.y + MIN_SPACING);
                offset += pointingSize.x;
            }
        }
    }
    */
    
    @Override
    public void drawBox(GraphicsContext gc)
    {
        for (Box b : boxes)
        {
            b.drawBox(gc);
        }
        gc.setStroke(Color.GREEN);
        gc.strokeRect(x, y, size.x, size.y);
        gc.setStroke(Color.GRAY);
        gc.strokeRect(x, y, effectiveSize.x, effectiveSize.y);
    }
}
