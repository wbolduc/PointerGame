/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
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
    
    public void drawBox(GraphicsContext gc)
    {
        gc.setStroke(Color.BLACK);
        gc.strokeRect(x, y, BOX_SIZE, BOX_SIZE);
        if (uninitialized == true)
        {
            gc.setStroke(Color.RED);
            gc.strokeLine(x, y, x + BOX_SIZE, y + BOX_SIZE);
            gc.strokeLine(x, y + BOX_SIZE, x + BOX_SIZE, y);
        }
        else
        {
            Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
            gc.setFont( theFont );
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setTextBaseline(VPos.CENTER);
            gc.strokeText(""+content, x+BOX_SIZE/2, y+BOX_SIZE/2, BOX_SIZE);
        }
    }
}
