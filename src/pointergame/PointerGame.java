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
        boxes.add(new BoxArray(20+0*(BOX_SIZE + 20),20, Orientation.VERTICAL, new DefArray("test", 5, new Def(ValueBox.class))));
        boxes.add(new BoxArray(20+1*(BOX_SIZE + 20),20, Orientation.VERTICAL, new DefArray("test", 5, new Def(PointerBox.class))));

        //test drawing struct
        //struct def
        DefStruct node = new DefStruct("Node", new Def[]{
        new DefArray("id", 3, new Def(ValueBox.class)),
        new Def(PointerBox.class, "next")
        });
        boxes.add(new BoxArray(20+2*(BOX_SIZE + 20),20, Orientation.VERTICAL, new DefArray("woah", 4, node)));

        
        
        boxes.add(new BoxArray(300, 20+0*(BOX_SIZE + 20), Orientation.HORIZONTAL, new DefArray("test", 5, new Def(ValueBox.class))));
        boxes.add(new BoxArray(300, 20+1*(BOX_SIZE + 20), Orientation.HORIZONTAL, new DefArray("test", 5, new Def(PointerBox.class))));

        //test drawing struct
        //struct def
        boxes.add(new BoxArray(300, 20+2*(BOX_SIZE + 20), Orientation.HORIZONTAL, new DefArray("woah", 4, node)));
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
        Def numerator = new Def("numerator", ValueBox.class);
        Def denominator = new Def("denominator", ValueBox.class);
        ArrayList<Element> structContents = new ArrayList<Element>();
        structContents.add(numerator);
        structContents.add(denominator);
        DefStruct fractionStruct = new DefStruct("Fraction", structContents);

        //student struct
        Def name = new DefArray("name", new Def(ValueBox.class), 5);
        structContents = new ArrayList<Element>();
        structContents.add(name);
        structContents.add(fractionStruct);
        DefStruct studentStruct = new DefStruct("Student", structContents);

        //make an array of students
        Def studentArray = new DefArray("students", studentStruct, 3);
        
        //Classroom Struct
        structContents = new ArrayList<Element>();
        structContents.add(new Def("Rating", ValueBox.class));
        structContents.add(new DefArray("profName", new Def(ValueBox.class),10));
        structContents.add(studentArray);
        DefStruct classRoom = new DefStruct("ClassStruct", structContents);
        
        
        BoxStruct temp = new BoxStruct(0,0, classRoom);
        classRoom.printStructure();
        lineBreak();
        temp.showChain();
        lineBreak();
        */
    }
}   