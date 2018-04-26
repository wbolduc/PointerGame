/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import static pointergame.PointerGame.BOX_SIZE;

/**
 *  the graphical stuff for value boxes
 * @author wbolduc
 */
public class GValueBox extends ValueBox{
    private int x;
    private int y;
    
    GValueBox(int x, int y, char value)
    {
        super(value);
        this.x = x;
        this.y = y;
    }
    
    GValueBox(int x, int y)
    {
        super();
        this.x = x;
        this.y = y;
    }
    
    public void drawBox(Graphics g)
    {
        g.drawRect(x, y, BOX_SIZE, BOX_SIZE);
        if (isUninitialized())
        {
            g.setColor(Color.red);
            g.drawLine(x, y, x + BOX_SIZE, y + BOX_SIZE);
            g.drawLine(x, y + BOX_SIZE, x + BOX_SIZE, y);
            g.setColor(Color.black);
        }
        else
        {
            g.setFont(new Font("Helvetica", Font.PLAIN, BOX_SIZE));
            g.drawString(""+getContent(), x, y + BOX_SIZE);
        }
    }
    
    //Getters/setters

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
