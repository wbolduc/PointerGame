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
public class ElementArray extends Element{
    private final Element indexType;
    private final int arraySize;
    
    ElementArray(String name, Orientation orientation, int arraySize, Element type)
    {
        super(BoxArray.class, orientation, name);
        if (orientation == Orientation.VERTICAL)
        {
            System.out.print("vert");
            size = new Size2D(type.get2DSize().x, type.get2DSize().y * arraySize);            

        }
        else
        {
            size = new Size2D(type.get2DSize().x * arraySize, type.get2DSize().y);            
        }
        
        this.indexType = type;
        this.arraySize = arraySize;
    }
    ElementArray(Orientation orientation, int arraySize, Element type)
    {
        this(null, orientation, arraySize, type);
    }

    public int getArraySize()
    {
        return arraySize;
    }
    
    public Element getElementSize()
    {
        return indexType;
    }
    
    public Element getIndexType()
    {
        return indexType;
    }
    
    public void printStructure(String indent)
    {
        String output = "Array of " + Integer.toString(arraySize) + " ";
        System.out.print(output);
    }
    
    public Size2D get2dSize()
    {
        return size;
    }
}
