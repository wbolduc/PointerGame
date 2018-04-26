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
public class GBoxArray extends BoxArray{
    private int x;
    private int y;
    
    GBoxArray(int x, int y, ArrayElement arrayDef)
    {
        super(arrayDef);
        this.x = x;
        this.y = y;
    }
    
}
