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
    private Element type;
    private int arraySize;
    
    ArrayElement(Element type, int arraySize)
    {
        super(BoxArray.class);
        this.type = type;
        this.arraySize = arraySize;
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
}
