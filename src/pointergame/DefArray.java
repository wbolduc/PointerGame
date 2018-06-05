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
public class DefArray extends Def{
    private final Def indexType;
    private final int arraySize;
    
    DefArray(String name, Orientation orientation, int arraySize, Def type)
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
    DefArray(Orientation orientation, int arraySize, Def type)
    {
        this(null, orientation, arraySize, type);
    }

    public int getArraySize()
    {
        return arraySize;
    }
    
    public Def getElementSize()
    {
        return indexType;
    }
    
    public Def getIndexType()
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
