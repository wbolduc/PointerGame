/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author wbolduc
 */

public class PointerGame {

    private static void createGui()
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(30, 30, 1000, 1000);
        frame.getContentPane().add(new MyCanvas());
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        System.out.println("Program");
        PointerBox src = new PointerBox(0, 0, null, null);
        src.setPointer(new ValueBox(0,0,src,'d'));
        src = new PointerBox(0,0,null,src);
        
        src.showChain();
        BadBox.getInstance().showChain();
        
        src = new PointerBox(0,0,null);
        src.showChain();
        src.setPointer(new ValueBox(0,0,src,'g'));
        src.showChain();
        
        BoxArray testBA = new BoxArray(0,0, null, 10);
        testBA.showChain();
        //createGui();
    }
    
}   

class MyCanvas extends JComponent
{
    @Override
    public void paint(Graphics g)
    {
        g.drawRect(30, 30, 300, 300);
    }
    
}