/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.awt.Color;
import java.awt.Graphics;
import static pointergame.PointerGame.BOX_SIZE;

/**
 *
 * @author wbolduc
 */
public class GBadBox extends BadBox{
    private int x;
    private int y;
    
    GBadBox(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public void drawBox(Graphics g)
    {
        g.setColor(Color.red);
        g.drawRect(x, y, BOX_SIZE, BOX_SIZE);
        g.drawLine(x, y, x + BOX_SIZE, y + BOX_SIZE);
        g.drawLine(x, y + BOX_SIZE, x + BOX_SIZE, y);
        g.setColor(Color.black);
    }
}
