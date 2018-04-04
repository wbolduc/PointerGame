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
public class StructElement
{
    private final String name;
    private final Class type;
    private final StructDefinition structure;

    StructElement(String name, Class type)
    {
        this.name = name;
        this.type = type;
        structure = null;
    }
    StructElement(String name, StructDefinition structure)
    {
        this.name = name;
        type = StructDefinition.class;
        this.structure = structure;
    }
    
    public String getName()
    {
        return name;
    }
    public Class getType()
    {
        return type;
    }
    public StructDefinition getStructure()
    {
        return structure;
    }
}