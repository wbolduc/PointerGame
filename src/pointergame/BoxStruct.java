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
    
    private Orientation orientation = Orientation.HORIZONTAL;
    
    private int maxNameLength = 0;
    
    BoxStruct(int x, int y, DefStruct structDef)
    {
        super(x,y);
        
        this.structDef = structDef;
        orientation = structDef.orientation;
        
        int offset = 0;
        if (orientation == Orientation.HORIZONTAL)
        {
            //loops through the elements defined in structDef and creates them recursively in "actual memory"
            for(Def e : structDef.getStructElements())
            {   
                Class type = e.getType();
                if (type == DefStruct.class)
                    elements.put(e.getName(), new BoxStruct(x+offset,y,(DefStruct)e));
                else if (type == DefArray.class)
                    elements.put(e.getName(), new BoxArray(x+offset,y,(DefArray)e));
                else if (type == PointerBox.class)
                    elements.put(e.getName(), new PointerBox(x+offset,y));
                else //valueBox
                    elements.put(e.getName(), new ValueBox(x+offset,y));
                
                offset += e.get2DSize().x;
            }
        }
        else //Vertical
        {
            System.out.println("Vert");
            //loops through the elements defined in structDef and creates them recursively in "actual memory"   
            for(Def e : structDef.getStructElements())
            {   
                Class type = e.getType();
                if (type == DefStruct.class)
                    elements.put(e.getName(), new BoxStruct(x,y+offset,(DefStruct)e));
                else if (type == DefArray.class)
                    elements.put(e.getName(), new BoxArray(x,y+offset,(DefArray)e));
                else if (type == PointerBox.class)
                    elements.put(e.getName(), new PointerBox(x,y+offset));
                else //valueBox
                    elements.put(e.getName(), new ValueBox(x,y+offset));
                
                offset += e.get2DSize().y;
            }
        }
    }
    
    public void showChain(String indent)
    {
        String structName = structDef.getName();
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
        gc.strokeRect(x-2, y-2, structDef.size.x+4, structDef.size.y+4);
        for (Box b : elements.values())
        {
            b.drawBox(gc);
        }
    }
    
}
