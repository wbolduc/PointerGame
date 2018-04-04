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
        
        
    }
}
