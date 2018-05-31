/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author wbolduc
 */
public class CustomShape{
    
    private static final double defaultArrowHeadWidth = 10;
    private static final double defaultArrowHeadLength = 15;
    private static final Color defaultColor = Color.BLUE;

    
    public static void arrow(GraphicsContext gc, double x1, double y1, double x2, double y2, double arrowHeadWidth, double arrowHeadLength, Color color)
    {
        gc.setStroke(color);
        gc.setFill(color);
        
        //line part
        gc.beginPath();
        gc.moveTo(x1, y1);
        gc.lineTo(x2, y2);
        
        //find unit vectors
        double magnitude = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        double unitx = (x2 - x1) / magnitude;
        double unity = (y2 - y1) / magnitude;
        
        double unitx90deg = -unity;
        double unity90deg = unitx;

        //arrowhead
        double p1x = x2 - unitx*arrowHeadLength + unitx90deg*arrowHeadWidth;
        double p1y = y2 - unity*arrowHeadLength + unity90deg*arrowHeadWidth;

        double p2x = x2 - unitx*arrowHeadLength - unitx90deg*arrowHeadWidth;
        double p2y = y2 - unity*arrowHeadLength - unity90deg*arrowHeadWidth;
        
        gc.lineTo(p1x, p1y);
        gc.lineTo(p2x, p2y);
        gc.lineTo(x2, y2);
        gc.closePath();
        gc.fill();
        gc.stroke();
    }
    
    public static void arrow(GraphicsContext gc, double x1, double y1, double x2, double y2)
    {
        arrow(gc, x1,y1,x2,y2,defaultArrowHeadWidth, defaultArrowHeadLength, defaultColor);
    }
}
