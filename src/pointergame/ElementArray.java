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
    
    ElementArray(String name, Element type, int arraySize)
    {
        super(BoxArray.class, name, type.get2DSize().x * arraySize, type.get2DSize().y);
        this.indexType = type;
        this.arraySize = arraySize;
    }
    ElementArray(Element type, int arraySize)
    {
        this(null, type, arraySize);
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
