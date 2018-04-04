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

public class Element {
    private Class elementType;
    private String name;
    
    Element(Class elementType)
    {
        this.elementType = elementType;
    }
    Element(String name, Class elementType)
    {
        this.name = name;
        this.elementType = elementType;
    }
    
    public String getName()
    {
        return name;
    }
    
    public Class getElementType()
    {
        return elementType;
    }
    
    public void printStructure()
    {
        this.printStructure("", true);
    }
    
    public void printStructure(String indent, boolean inline)
    {
        if (inline == false)
            System.out.print(indent);
        System.out.println(elementType.getName().substring("pointergame.".length()));
    }
    
}
