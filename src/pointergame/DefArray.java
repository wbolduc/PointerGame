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
    final Def indexType;
    final int arraySize;
    
    DefArray(String name, int arraySize, Def type)
    {
        super(BoxArray.class);
        this.indexType = type;
        this.arraySize = arraySize;
    }
    DefArray(int arraySize, Def type)
    {
        this(null, arraySize, type);
    }
    
    public void printStructure(String indent)
    {
        String output = "Array of " + Integer.toString(arraySize) + " ";
        System.out.print(output);
    }
}
