/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wbolduc
 */
public class BoxStruct extends Box{
    private StructElement structDef;
    private HashMap<String,Box> elements = new HashMap<String,Box>();
    
    BoxStruct(int x, int y, StructElement structDef)
    {
        super(x,y);
        
        this.structDef = structDef;
        
        for(Element e : structDef.getStructElements())
        {   
            if (e instanceof StructElement)
                elements.put(e.getName(), new BoxStruct(0,0,(StructElement)e));
            else if (e instanceof ArrayElement)
                elements.put(e.getName(), new BoxArray(0,0,(ArrayElement)e));
            else
            {
                if (e.getElementType() == PointerBox.class)
                    elements.put(e.getName(), new PointerBox(0,0));
                else //valueBox
                    elements.put(e.getName(), new ValueBox(0,0));
            }
        }
        
    }
}
