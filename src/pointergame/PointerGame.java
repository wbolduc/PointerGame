/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;

import java.awt.Graphics;
import java.util.ArrayList;
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
    
    static void lineBreak()
    {
        System.out.println("----------------------------------------------------------");
    }
    
    
    public static void main(String[] args) {

        Element numerator   = new Element("numerator", ValueBox.class);
        Element denominator = new Element("denominator", ValueBox.class);
        ArrayList<Element> structContents = new ArrayList<Element>();
        structContents.add(numerator);
        structContents.add(denominator);
        Element fractionStruct = new StructElement("Fraction", structContents);
        
        Element name        = new ArrayElement("name", new Element(ValueBox.class), 5);
        structContents = new ArrayList<Element>();
        structContents.add(name);
        structContents.add(fractionStruct);
        Element studentStruct = new StructElement("Student", structContents);

        Element studentArray = new ArrayElement("students", studentStruct, 30);
        
        structContents = new ArrayList<Element>();
        structContents.add(new ArrayElement("profName", new Element(ValueBox.class),20));
        structContents.add(studentArray);
        Element classRoom = new StructElement("ClassStruct", structContents);
        
        classRoom.printStructure();
        lineBreak();
        
        //list of strings
        String [] strings = {"hello", "pointer", "test"};
        
        PointerBox stringArrayPointer = new PointerBox(0,0);
        stringArrayPointer.setPointer(new BoxArray(0, 0, strings.length, PointerBox.class));
        
        stringArrayPointer.showChain();
        lineBreak();
        
        for (int i = 0; i < strings.length; i++)
        {
            BoxArray charArray = new BoxArray(0,0,strings[i].length(), ValueBox.class);
            for (int j = 0; j < strings[i].length(); j++)
            {
                charArray.setBoxAt(new ValueBox(0,0,strings[i].charAt(j)), j);                
            }
            
            PointerBox charArrayPointer = new PointerBox(0,0);
            charArrayPointer.setPointer(charArray);
            
            ((BoxArray)stringArrayPointer.getDest()).setBoxAt(charArrayPointer, i);
        }
        
        stringArrayPointer.showChain();
    }

    //Util
    public static String indentPad(int padSize) {
        String indent = "";
        for (int i = 0; i < padSize; i++) {
            indent += " ";
        }
        return indent;
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