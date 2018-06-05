/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import static pointergame.Box.BOX_SIZE;

/**
 * Elements are used to describe the structure of structs or arrays
 * They do not actually store any of the data
 * @author wbolduc
 */

public class Def {
    protected String name = null;
    protected Size2D size = new Size2D(BOX_SIZE, BOX_SIZE);
    private Class type;
    protected Orientation orientation = Orientation.HORIZONTAL;

    protected Def(Class type)
    {
        this.type = type;
    }    
    
    protected Def(Class type, String name)
    {
        this(type);
        this.name = name;
    }
    
    protected Def(Class type, Orientation orientation)
    {
        this(type);
        this.orientation = orientation;
    }
    
    protected Def(Class type, Orientation orientation, String name)
    {
        this(type,orientation);
        this.name = name;
    }

    protected Def(Class type, Orientation orientation, int xSize, int ySize)
    {
        this(type, orientation);
        size = new Size2D(xSize, ySize);
    }
    
    protected Def(Class type, Orientation orientation, String name, int xSize, int ySize)
    {
        this(type, orientation, name);
        size = new Size2D(xSize, ySize);
    }

    public Orientation getOrientation() {
        return orientation;
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
