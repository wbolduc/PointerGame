/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.awt.Font;
import java.awt.Graphics;
import static pointergame.Box.BOX_SIZE;

/**
 *
 * @author wbolduc
 */
public class ValueBox extends Box {
    private char content;
    private boolean uninitialized = true;

    ValueBox(int x, int y, char value) {
        super(x, y);
        content = value;
        uninitialized = false;
    }
    
    ValueBox(int x, int y) {
        super(x, y);
    }
    
    //Setters
    public void setContents(char value)
    {
        content = value;
    }
    
    //Util
    public void showChain(String indent)
    {
        if (uninitialized == true)
            System.out.println("Uninitialized ValueBox");
        else
            System.out.println("ValueBox storing " + content);
    }
    
    public void drawBox(Graphics g)
    {
        g.drawRect(x, y, BOX_SIZE, BOX_SIZE);
        if (uninitialized == true)
        {
            g.drawLine(x, y, x + BOX_SIZE, y + BOX_SIZE);
            g.drawLine(x, y + BOX_SIZE, x + BOX_SIZE, y);
        }
        else
        {
            g.setFont(new Font("Helvetica", Font.PLAIN, BOX_SIZE));
            g.drawString(""+content, x, y + BOX_SIZE);
        }
    }
}
