/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

/**
 * Elements are used to describe the structure of structs or arrays
 * They do not actually store any of the data
 * @author wbolduc
 */

public class Element {
    protected String name = null;
    protected Size2D size;
    private Class type;
    
    protected Element(Class type)
    {
        this.type = type;
    }
    
    protected Element(Class type, String name)
    {
        this(type);
        this.name = name;
    }

    protected Element(Class type, int xSize, int ySize)
    {
        this(type);
        size = new Size2D(xSize, ySize);
    }
    
    protected Element(Class type, String name, int xSize, int ySize)
    {
        this(type, name);
        size = new Size2D(xSize, ySize);
    }

    
    public String getName()
    {
        return name;
    }
    
    public Class getType()
    {
        return type;
    }
    
    public Size2D get2DSize()
    {
        return size;
    }
}
