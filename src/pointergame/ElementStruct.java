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
    
    ElementStruct(String name, Orientation orientation, Element[] structElements)
    {
        super(BoxStruct.class, orientation, name);
        
        size = new Size2D(0,0);
        if (orientation == Orientation.HORIZONTAL)
        {
            for (Element e: structElements)
            {
                if (e.size.y > size.y)
                {
                    size.y = e.size.y;
                }
                size.x += e.size.x;
            }
        }
        else
        {
            System.out.print("RORORO");
            for (Element e: structElements)
            {
                if (e.size.x > size.x)
                {
                    size.x = e.size.x;
                }
                size.y += e.size.y;
            }
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