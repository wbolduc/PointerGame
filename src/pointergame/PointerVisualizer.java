/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author wbolduc
 */
public class PointerVisualizer extends JPanel{
    ArrayList<Box> boxes = new ArrayList<Box>();    
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        for(Box b : boxes)
        {
            System.out.println("boop");
            b.drawBox(g);
        }
    }
    
    public void addBox(Box box)
    {
        this.boxes.add(box);
        System.out.println("box added");
    }
    public void addBoxes(ArrayList<Box> boxes)
    {
        this.boxes.addAll(boxes);
    }
    
}