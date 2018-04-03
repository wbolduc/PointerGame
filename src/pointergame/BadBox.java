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
//represents an uninitialized pointer
public class BadBox extends Box{
    private static BadBox instance = null;
    
    private BadBox()
    {
        super(0,0,null);
    }
    
    public static BadBox getInstance()
    {
        if (instance == null)
        {
            instance = new BadBox();
        }
        return instance;
    }
    
    public void showChain(int indentLevel)
    {
        indentPad(indentLevel);
        System.out.println("Bad Memory");        
    }
}
