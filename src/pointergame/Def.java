/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

/**
 * Elements are used to describe the structure of structs or arrays
 * They do not actually store any of the data
 * @author wbolduc
 */

public class Def {
    final String name;
    final Class type;    

    protected Def(Class type)
    {
        this.type = type;
        this.name = null;
    }    
    
    protected Def(Class type, String name)
    {
        this.type = type;
        this.name = name;
    }
}
