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
public class ElementStruct extends Element
{
    private final Element[] structElements;
    
    ElementStruct(String name, Element[] structElements)
    {
        super(BoxStruct.class, name);
        
        size = new Size2D(0,0);
        for (Element e: structElements)
        {
            if (e.size.y > size.y)
            {
                size.y = e.size.y;
            }
            size.x += e.size.x;
        }
        this.structElements = structElements;
    }
    
    public Element[] getStructElements()
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
//            e.printStructure(indent + PointerGame.indentPad(e.getName().length()+2));
        }
    }
    public void get2Dsize()
    {
        System.out.println("I am here");
    }
}