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
    
    private int maxNameLength = 0;
    
    BoxStruct(int x, int y, StructElement structDef)
    {
        super(x,y);
        
        this.structDef = structDef;
        
        //loops through the elements defined in structDef and creates them recursively in "actual memory"
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
            
            //gets the length of the longest element name (for use only for printing later)
            int len = e.getName().length();
            if (len > maxNameLength)
                maxNameLength = len;        
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
}
