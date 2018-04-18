/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.awt.Graphics;

/**
 *
 * @author wbolduc
 */
public class Arrow {
    private Box start;
    private Box end;
    
    Arrow(Box start, Box end)
    {
        this.start = start;
        this.end = end;
    }

    public Box getStart() {
        return start;
    }

    public void setStart(Box start) {
        this.start = start;
    }

    public Box getEnd() {
        return end;
    }

    public void setEnd(Box end) {
        this.end = end;
    }
    
    public void drawArrow(Graphics g)
    {
        int x1 = start.getX() + Box.BOX_SIZE/2;
        int y1 = start.getY() + Box.BOX_SIZE/2;
        
        if (end == null)
        {
            return; // TODO: ACTUALLY DRAW NULL
        }
        else
        {
            int x2 = end.getX() + Box.BOX_SIZE/2;
            int y2 = end.getY() + Box.BOX_SIZE/2;
        
            g.drawLine(x1, y1, x2, y2);
            end.drawBox(g);
        }
    }
   
}
