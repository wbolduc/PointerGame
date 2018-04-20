/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.awt.Color;
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
        Vector2D p1 = new Vector2D(start.getX() + Box.BOX_SIZE/2, start.getY() + Box.BOX_SIZE/2);
        
        if (end == null)
        {
            return; // TODO: ACTUALLY DRAW NULL
        }
        else
        {
            Vector2D p2 = new Vector2D(end.getX() + Box.BOX_SIZE/2, end.getY() + Box.BOX_SIZE/2);
            Line2D arrow = new Line2D(p1,p2);
            double angle = arrow.atOrigin().angle();
            
            int endX = end.getX();
            int endY = end.getY();
            
            Line2D boxSide;
            System.out.println("Angle: " + Double.toString(angle));
            if (Math.PI * 7 / 4 <= angle)
                boxSide = new Line2D(endX, endY, endX, endY + Box.BOX_SIZE); //hitting left side
            else if (Math.PI * 5 /4 <= angle)
                boxSide = new Line2D(endX, endY + Box.BOX_SIZE, endX + Box.BOX_SIZE, endY + Box.BOX_SIZE); //hitting bottom side
            else if (Math.PI * 3 / 4 <= angle)
                boxSide = new Line2D(endX + Box.BOX_SIZE, endY, endX + Box.BOX_SIZE, endY + Box.BOX_SIZE); //hitting right side
            else if (Math.PI / 4 <= angle)
                boxSide = new Line2D(endX, endY, endX + Box.BOX_SIZE, endY); //hitting top side
            else
                boxSide = new Line2D(endX, endY, endX, endY + Box.BOX_SIZE); //hitting left side
            
            
            
            Vector2D intersect = arrow.intersectionPoint(boxSide);

            System.out.println("P1: " + p1.toString());
            System.out.println("P2: " + p2.toString());
            System.out.print("Arrow: ");
            arrow.printLine();
            System.out.print("Side: ");
            boxSide.printLine();
            System.out.println("Point: " + intersect.toString());
            PointerGame.lineBreak();
            
            arrow.setP2(intersect);
            
            //arrow.setP2(arrow.atOrigin().toUnit().scale(100).add(p1));
            arrow.drawLine(g);
            
            //(new Line2D(p1,(new Line2D(p1,p2).intersectionPoint(new Line2D(end.getX(), end.getY(),end.getX()+Box.BOX_SIZE,end.getY()+Box.BOX_SIZE))))).drawLine(g);
        }
    }
   
}