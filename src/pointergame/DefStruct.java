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
    
    DefStruct(String name, Orientation orientation, Def[] structElements)
    {
        super(BoxStruct.class, orientation, name);
        this.structElements = structElements;
        updateDimensions();
    }
    
    private void updateDimensions()
    {
        size = new Size2D(0,0);
        if (orientation == Orientation.HORIZONTAL)
        {
            for (Def e: structElements)
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
            for (Def e: structElements)
            {
                if (e.size.x > size.x)
                {
                    size.x = e.size.x;
                }
                size.y += e.size.y;
            }
        }
    }
    
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
        updateDimensions();
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