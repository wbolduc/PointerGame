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
    private StructDefinition structDef;
    private HashMap<String,Box> elements;
    
    BoxStruct(int x, int y, StructDefinition structDef)
    {
        super(x,y);
        /*
        for (Map.Entry<String, Class> entry: structDef.types.entrySet())
        {
            Class boxType = entry.getValue();
            Box initBox;
            if (boxType == PointerBox.class)
                initBox = new PointerBox(0,0);
            else if (boxType == ValueBox.class)
                initBox = new ValueBox(0,0,null);
            else if (boxType == BoxArray.class)
                initBox = new BoxArray()
            else if (boxType == BadBox.class)        
            else if (boxType == BoxStruct.class)
                
                
                
            }
                   
            
            
            elements.put(entry.getKey(),)
        }
        
        this.structDef = structDef;
*/
    }
}
