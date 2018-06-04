/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointergame;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import static pointergame.Box.BOX_SIZE;

/**
 *
 * @author wbolduc
 */

public class PointerGame extends Application{
    public static final int xSize = 1000;
    public static final int ySize = 1000;
    
    public static final ArrayList<Box> boxes = new ArrayList<Box>();
    
    public static void main(String[] args){
        //test drawing array
        boxes.add(new BoxArray(20+0*(BOX_SIZE + 20),20, new ElementArray("test", new Element(ValueBox.class, BOX_SIZE, BOX_SIZE), 5)));
        boxes.add(new BoxArray(20+1*(BOX_SIZE + 20),20, new ElementArray("test", new Element(PointerBox.class, BOX_SIZE, BOX_SIZE), 6)));

        //test drawing struct
        //struct def
        ElementStruct node = new ElementStruct("Node",new Element[]{
        new Element(ValueBox.class, "data", BOX_SIZE, BOX_SIZE),
        new Element(PointerBox.class, "next", BOX_SIZE, BOX_SIZE)
        });
        
        boxes.add(new BoxStruct(20+2*(BOX_SIZE + 20),20, node));


        //boxes.add(new BoxArray(20+2*(BOX_SIZE + 20),20, new ElementArray("test", new Element(PointerBox.class, BOX_SIZE, BOX_SIZE), 6)));
        
        /*
        ValueBox vb1 = new ValueBox(20, 20);
        boxes.add(vb1);
        boxes.add(new ValueBox(200, 100, '2'));
        
        boxes.add(new PointerBox(20, 200));
        boxes.add(new PointerBox(200, 320).setPointer(vb1));
        boxes.add(new PointerBox(400, 20).setPointer(null));
        */
        launch(args);
    }
    
    public void start(Stage theStage) 
    {
        theStage.setTitle( "Pointer Visualizer" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( xSize, ySize );
        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();

        for (Box b : boxes)
        {
            b.drawBox(gc);
        }

        theStage.show();
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
        /*
        Element numerator = new Element("numerator", ValueBox.class);
        Element denominator = new Element("denominator", ValueBox.class);
        ArrayList<Element> structContents = new ArrayList<Element>();
        structContents.add(numerator);
        structContents.add(denominator);
        ElementStruct fractionStruct = new ElementStruct("Fraction", structContents);

        //student struct
        Element name = new ElementArray("name", new Element(ValueBox.class), 5);
        structContents = new ArrayList<Element>();
        structContents.add(name);
        structContents.add(fractionStruct);
        ElementStruct studentStruct = new ElementStruct("Student", structContents);

        //make an array of students
        Element studentArray = new ElementArray("students", studentStruct, 3);
        
        //Classroom Struct
        structContents = new ArrayList<Element>();
        structContents.add(new Element("Rating", ValueBox.class));
        structContents.add(new ElementArray("profName", new Element(ValueBox.class),10));
        structContents.add(studentArray);
        ElementStruct classRoom = new ElementStruct("ClassStruct", structContents);
        
        
        BoxStruct temp = new BoxStruct(0,0, classRoom);
        classRoom.printStructure();
        lineBreak();
        temp.showChain();
        lineBreak();
        */
    }
}   