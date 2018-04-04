/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

/**
 *  Elements are used to describe the structure of structs or arrays in an unchanging manner
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
        this.printStructure("");
    }
    
    public void printStructure(String indent)
    {
        System.out.println(elementType.getName().substring("pointergame.".length()));
    }
    
}
