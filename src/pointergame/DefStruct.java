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
    final Def[] elements;
    
    DefStruct(String name, Def[] structElements)
    {
        super(BoxStruct.class, name);
        this.elements = structElements;
    }
    
    public void printStructure(String indent)
    {        
        System.out.println("Struct: " + name);
        indent += "      | ";
        
        for (Def e : elements)
        {
            System.out.print(indent);
            System.out.print(e.name + ": ");
//            e.printStructure(indent + PointerGame.indentPad(e.getName().length()+2));
        }
    }
}