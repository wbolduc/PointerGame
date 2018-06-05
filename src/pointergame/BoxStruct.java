/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 *
 * @author wbolduc
 */
public class BoxStruct extends Box{
    private DefStruct structDef;
    private HashMap<String,Box> elements = new HashMap<String,Box>();
    
    private int maxNameLength = 0;
    
    BoxStruct(int x, int y, Orientation orientation, DefStruct structDef)
    {
        super(x,y);
        
        this.structDef = structDef;
        this.orientation = orientation;
        
        size = new Size2D(0,0);
        if (orientation == Orientation.VERTICAL)
        {
            //loops through the elements defined in structDef and creates them recursively in "actual memory"   
            for(Def e : structDef.elements)
            {   
                Class type = e.type;
                Box toAdd;
                if (type == BoxStruct.class)
                    toAdd = new BoxStruct(x,y+size.y,Orientation.HORIZONTAL, (DefStruct)e);
                else if (type == BoxArray.class)
                    toAdd = new BoxArray(x,y+size.y,Orientation.HORIZONTAL, (DefArray)e);
                else if (type == PointerBox.class)
                    toAdd = new PointerBox(x,y+size.y,Orientation.HORIZONTAL);
                else //valueBox
                    toAdd = new ValueBox(x,y+size.y);
                
                //add box to struct
                elements.put(e.name, toAdd);
                
                //increase graphical size of struct
                size.y += toAdd.size.y;
                if(size.x < toAdd.size.x)
                    size.x = toAdd.size.x;
            }
        }
        else
        {
            //loops through the elements defined in structDef and creates them recursively in "actual memory"
            for(Def e : structDef.elements)
            {   
                Class type = e.type;
                Box toAdd;
                if (type == BoxStruct.class)
                    toAdd = new BoxStruct(x+size.x,y,Orientation.VERTICAL, (DefStruct)e);
                else if (type == BoxArray.class)
                    toAdd = new BoxArray(x+size.x,y,Orientation.VERTICAL, (DefArray)e);
                else if (type == PointerBox.class)
                    toAdd = new PointerBox(x+size.x,y,Orientation.VERTICAL);
                else //valueBox
                    toAdd = new ValueBox(x+size.x,y);
                
                //add box to struct
                elements.put(e.name, toAdd);
                
                //increase graphical size of struct
                size.x += toAdd.size.x;
                if(size.y < toAdd.size.y)
                    size.y = toAdd.size.y;
            }
        }    
    }
    
    /*
    private void updateDimensions()
    {
        size = new Size2D(0,0);
        if (orientation == Orientation.HORIZONTAL)
        {
            for (Def e: elements)
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
            for (Def e: elements)
            {
                if (e.size.x > size.x)
                {
                    size.x = e.size.x;
                }
                size.y += e.size.y;
            }
        }
    }
    */
    
    public void showChain(String indent)
    {
        String structName = structDef.name;
        System.out.println(structName);
        indent += Box.MIN_INDENT + "| ";
        
        for (Map.Entry<String,Box> e : elements.entrySet())
        {
            String name = e.getKey();
            Box content = e.getValue();
            
            System.out.print(indent + name + PointerGame.indentPad(maxNameLength - name.length()) + ": ");
            
            if (content instanceof PointerBox)
                ((PointerBox)content).showChain(indent);
            else if (content instanceof ValueBox)
                ((ValueBox)content).showChain(indent);
            else if (content instanceof BoxStruct)
                ((BoxStruct)content).showChain(indent + PointerGame.indentPad(name.length()));
            else if (content instanceof BoxArray)
                ((BoxArray)content).showChain(indent + PointerGame.indentPad(name.length()));
        }
    }   
    
    //graphics
    @Override
    public void drawBox(GraphicsContext gc)
    {
        gc.setStroke(Color.DARKORANGE);
        gc.strokeRect(x-2, y-2, size.x+4, size.y+4);
        for (Box b : elements.values())
        {
            b.drawBox(gc);
        }
    }
    
}
