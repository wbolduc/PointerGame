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
public class DefStruct extends Def
{
    private final Def[] structElements;
    
    DefStruct(String name, Def[] structElements)
    {
        super(BoxStruct.class);
        this.structElements = structElements;
    }
    
    public Def[] getStructElements()
    {
        return structElements;
    }
    
    public void printStructure(String indent)
    {        
        System.out.println("Struct: " + name);
        indent += "      | ";
        
        for (Def e : structElements)
        {
            System.out.print(indent);
            System.out.print(e.getName() + ": ");
//            e.printStructure(indent + PointerGame.indentPad(e.getName().length()+2));
        }
    }
    public void get2Dsize()
    {
        System.out.println("I am here");
    }
}