/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.util.ArrayList;

/**
 *
 * @author wbolduc
 */
public class BoxArray extends Box{
    private ArrayList<Box> boxes = new ArrayList<Box>();

    BoxArray(int x, int y, PointerBox origin)
    {
        super(x, y, origin);
    }
    
    
}
