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
        
    public static void main(String[] args) {
        JFrame frame = new JFrame("PointerVisualizer");
	PointerVisualizer pv = new PointerVisualizer();
	frame.add(pv);
	frame.setSize(1000, 1000);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
        
        //TODO: badBox should not be a singleton
        PointerBox pb = new PointerBox(10,20);
        ValueBox vb = new ValueBox(50,50);
        
        pb.setPointer(vb);
        
        pv.addBox(pb);
        pv.addBox(vb);
        pv.repaint();
        
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
}   