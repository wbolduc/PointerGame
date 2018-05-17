/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> parent of 1385efa... Basic arrow being drawn correctly
=======
>>>>>>> parent of 1385efa... Basic arrow being drawn correctly
=======
>>>>>>> parent of 1385efa... Basic arrow being drawn correctly
=======
>>>>>>> parent of 1385efa... Basic arrow being drawn correctly
import java.awt.Font;
import java.awt.Graphics;
import static pointergame.Box.BOX_SIZE;

>>>>>>> parent of 1385efa... Basic arrow being drawn correctly
/**
 *
 * @author wbolduc
 */
public class ValueBox extends Box {
    private char content;           //NOTE: should content be "Object content"?
    private boolean uninitialized;

    ValueBox(char value) {
        content = value;
        uninitialized = false;
    }
    ValueBox()
    {
        uninitialized = true;
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
    
    //getters
    protected boolean isUninitialized()
    {
<<<<<<< HEAD
        return uninitialized;
    }
    protected char getContent()
    {
        return content;
=======
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
>>>>>>> parent of 1385efa... Basic arrow being drawn correctly
    }
            
}
