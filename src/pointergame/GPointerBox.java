/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.awt.Graphics;
import static pointergame.PointerGame.BOX_SIZE;

/**
 *
 * @author wbolduc
 */
public class GPointerBox extends PointerBox{
    private int x;
    private int y;
    private Arrow arrow = new Arrow(this, null);
    
    GPointerBox(int x, int y)
    {
        super();
        this.x = x;
        this.y = y;
    }
    
    public void drawBox(Graphics g)
    {
        g.drawRect(x, y, BOX_SIZE, BOX_SIZE);
        arrow.drawArrow(g);
    }
}
