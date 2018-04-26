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
public class ValueBox extends Box {
    private char content;           //NOTE: should content be "Object content"?
    private boolean uninitialized;

    ValueBox(char value) {
        content = value;
        uninitialized = false;
    }
    ValueBox()
    {
        uninitialized = true;
    }
    
    //Setters
    public void setContents(char value)
    {
        content = value;
    }
    
    //Util
    public void showChain(String indent)
    {
        if (uninitialized == true)
            System.out.println("Uninitialized ValueBox");
        else
            System.out.println("ValueBox storing " + content);
    }
    
    //getters
    protected boolean isUninitialized()
    {
        return uninitialized;
    }
    protected char getContent()
    {
        return content;
    }
            
}
