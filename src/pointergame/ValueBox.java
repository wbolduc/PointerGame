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
    private char content;
    private boolean uninitialized = true;

    ValueBox(int x, int y, char value) {
        super(x, y);
        content = value;
        uninitialized = false;
    }
    
    ValueBox(int x, int y) {
        super(x, y);
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
}
