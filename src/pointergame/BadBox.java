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
    
    public void showChain(String indent)
    {
        System.out.print(indent);
        System.out.println("Bad Memory");        
    }
}
