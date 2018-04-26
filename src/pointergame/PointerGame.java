/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;


import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author wbolduc
 */

public class PointerGame {
    public static final int xSize = 1000;
    public static final int ySize = 1000;
    public static final int BOX_SIZE = 100;
    
    public static void main(String[] args) throws InterruptedException{
        JFrame frame = new JFrame("PointerVisualizer");
	PointerVisualizer pv = new PointerVisualizer();
	frame.add(pv);
	frame.setSize(xSize, ySize);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
        
        //TODO: badBox should not be a singleton
<<<<<<< HEAD
        
=======
        PointerBox pb = new PointerBox(xSize/2 - Box.BOX_SIZE/2, ySize/2 - Box.BOX_SIZE/2);
        ValueBox vb = new ValueBox(0,0);
        
        pb.setPointer(vb);
        
        pv.addBox(pb);
        pv.addBox(vb);
        
        int stepTime = 1000;
        while(true)
        {
            while(vb.getX() < xSize - Box.BOX_SIZE)
            {
                vb.setX(vb.getX()+50);
                Thread.sleep(stepTime);
                pv.repaint();
            }
            while(vb.getY() < ySize - Box.BOX_SIZE)
            {
                vb.setY(vb.getY()+50);
                Thread.sleep(stepTime);
                pv.repaint();
            }
            while(vb.getX() > 0)
            {
                vb.setX(vb.getX()-50);
                Thread.sleep(stepTime);
                pv.repaint();
            }
            while(vb.getY() > 0)
            {
                vb.setY(vb.getY()-50);
                Thread.sleep(stepTime);
                pv.repaint();
            }
        }
>>>>>>> parent of 1385efa... Basic arrow being drawn correctly
    }

    //Util
    public static String indentPad(int padSize) {
        String indent = "";
        for (int i = 0; i < padSize; i++) {
            indent += " ";
        }
        return indent;
    }
    
    static void lineBreak()
    {
        System.out.println("----------------------------------------------------------");
    }
    
    //tests
    public static void bigStructTest()
    {
        //test printing
        //Franction Struct
        Element numerator = new Element("numerator", ValueBox.class);
        Element denominator = new Element("denominator", ValueBox.class);
        ArrayList<Element> structContents = new ArrayList<Element>();
        structContents.add(numerator);
        structContents.add(denominator);
        StructElement fractionStruct = new StructElement("Fraction", structContents);

        //student struct
        Element name = new ArrayElement("name", new Element(ValueBox.class), 5);
        structContents = new ArrayList<Element>();
        structContents.add(name);
        structContents.add(fractionStruct);
        StructElement studentStruct = new StructElement("Student", structContents);

        //make an array of students
        Element studentArray = new ArrayElement("students", studentStruct, 3);
        
        //Classroom Struct
        structContents = new ArrayList<Element>();
        structContents.add(new Element("Rating", ValueBox.class));
        structContents.add(new ArrayElement("profName", new Element(ValueBox.class),10));
        structContents.add(studentArray);
        StructElement classRoom = new StructElement("ClassStruct", structContents);
        
        
        BoxStruct temp = new BoxStruct(0,0, classRoom);
        classRoom.printStructure();
        lineBreak();
        temp.showChain();
        lineBreak();
    }
    
    public static void lineDrawTest(PointerVisualizer pv)
    {
        PointerBox pb = new PointerBox(xSize/2 - Box.BOX_SIZE/2, ySize/2 - Box.BOX_SIZE/2);
        ValueBox vb = new ValueBox(600,200);
        
        pb.setPointer(vb);
        
        pv.addBox(pb);
        pv.addBox(vb);
        
        int stepTime = 16;
        while(true)
        {
            while(vb.getX() < xSize - Box.BOX_SIZE)
            {
                vb.setX(vb.getX()+1);
                Thread.sleep(stepTime);
                pv.repaint();
            }
            while(vb.getY() < ySize - Box.BOX_SIZE)
            {
                vb.setY(vb.getY()+1);
                Thread.sleep(stepTime);
                pv.repaint();
            }
            while(vb.getX() > 0)
            {
                vb.setX(vb.getX()-1);
                Thread.sleep(stepTime);
                pv.repaint();
            }
            while(vb.getY() > 0)
            {
                vb.setY(vb.getY()-1);
                Thread.sleep(stepTime);
                pv.repaint();
            }
        }
    }
}   