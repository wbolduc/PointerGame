package pointergame;


import java.util.ArrayList;
import java.util.Iterator;

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
    private final String name;
    private final ArrayList<StructElement> elements;
    
    StructDefinition(String name, ArrayList<StructElement> elements)
    {
        this.name = name;
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    public ArrayList<StructElement> getElements() {
        return elements;
    }
}