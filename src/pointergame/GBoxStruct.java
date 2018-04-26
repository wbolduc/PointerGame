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
public class GBoxStruct extends BoxStruct{
    private int x;
    private int y;
    
    GBoxStruct(int x, int y, StructElement structDef)
    {
        super(structDef);
        this.x = x;
        this.y = y;
    }
}
