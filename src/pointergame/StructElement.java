/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.util.ArrayList;

/**
 *
 * @author wbolduc
 */
public class StructElement extends Element
{
    private final ArrayList<Element> structElements;
    private final String name;
    
    StructElement(String name, ArrayList<Element> structElements)
    {
        super(BoxStruct.class);
        this.name = name;
        this.structElements = structElements;
    }

    public String getName()
    {
        return name;
    }
    
    public ArrayList<Element> getStructElements()
    {
        return structElements;
    }
    
    public void printStructure(String indent)
    {        
        System.out.println("Struct: " + name);
        indent += "      | ";
        
        for (Element e : structElements)
        {
            System.out.print(indent);
            System.out.print(e.getName() + ": ");
            e.printStructure(indent + PointerGame.indentPad(e.getName().length()+2));
        }
    }
    public void get2Dsize()
    {
        System.out.println("I am here");
    }
}