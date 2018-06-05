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
        gc.strokeRect(x, y, size.x, size.y);
        if (uninitialized == true)
        {
            gc.setStroke(Color.RED);
            gc.strokeLine(x, y, x + size.x, y + size.y);
            gc.strokeLine(x, y + size.y, x + size.x, y);
        }
        else
        {
            Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
            gc.setFont( theFont );
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setTextBaseline(VPos.CENTER);
            gc.strokeText(""+content, x+size.x/2, y+size.y/2, size.x);
        }
    }
}
