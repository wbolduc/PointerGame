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

    ValueBox(int x, int y, PointerBox origin, char value) {
        super(x, y, origin);
        content = value;
    }
    
    //Setters
    public void setContents(char value)
    {
        content = value;
    }
    
    //Util
    public void showChain(int indentLevel)
    {
        indentPad(indentLevel);
        System.out.println("ValueBox storing " + content);
    }
}
