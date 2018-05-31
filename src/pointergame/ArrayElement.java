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
public class ArrayElement extends Element{
    private final Element type;
    private final int arraySize;
    private final Tuple2 size;

    
    ArrayElement(Element type, int arraySize)
    {
        super(BoxArray.class);
        this.type = type;
        this.arraySize = arraySize;
        
        Tuple2 elementSize = type.get2DSize();
        size = new Tuple2(elementSize.x, elementSize.y * arraySize);
    }
    ArrayElement(String name, Element type, int arraySize)
    {
        super(name, BoxArray.class);
        this.type = type;
        this.arraySize = arraySize;
    }

    public Element getType()
    {
        return type;
    }

    public int getArraySize()
    {
        return arraySize;
    }
    
    public void printStructure(String indent)
    {
        String output = "Array of " + Integer.toString(arraySize) + " ";
        System.out.print(output);
        type.printStructure(indent + PointerGame.indentPad(output.length()));
    }
    
    public Tuple2 get2dSize()
    {
        return size;
    }
}
