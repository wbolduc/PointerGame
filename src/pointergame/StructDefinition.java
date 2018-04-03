package pointergame;


import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wbolduc
 */
public class StructDefinition
{
    String name;
    HashMap<String, Class> types;
    
    StructDefinition(String name, HashMap<String, Class> types)
    {
        this.name = name;
        this.types = types;
    }
    StructDefinition(String name)
    {
        this.name = name;
        this.types = new HashMap<String, Class>();
    }
    
    //Mutators
    public void addTypePair(String name, Class type)
    {
        types.put(name, type);
    }
}