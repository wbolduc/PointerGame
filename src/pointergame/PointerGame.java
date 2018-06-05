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
        structuresWithPointers(5,5);
        recursiveStaticStructures(20, 300);
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
    
    public static void structuresWithPointers(int x, int y)
    {
        BoxArray arrayOfPointersToValues = new BoxArray(x,y,Orientation.HORIZONTAL, new DefArray(3, new Def(PointerBox.class)));
        boxes.add(arrayOfPointersToValues);
        for (Box b : arrayOfPointersToValues.getBoxes())
        {
            PointerBox p = (PointerBox)b;
            ValueBox vb = new ValueBox(30,100);
            boxes.add(vb);
            p.setPointer(vb);
        }
    }
    
    //tests
    public static void recursiveStaticStructures(int x, int y)
    {
        boxes.add(new BoxArray(x,y, Orientation.VERTICAL, new DefArray("test", 5, new Def(ValueBox.class))));
        boxes.add(new BoxArray(x+(BOX_SIZE + 20),y, Orientation.VERTICAL, new DefArray("test", 5, new Def(PointerBox.class))));

        //test drawing struct
        //struct def
        DefStruct node = new DefStruct("Node", new Def[]{
        new DefArray("id", 3, new Def(ValueBox.class)),
        new Def(PointerBox.class, "next")
        });
        boxes.add(new BoxArray(x+2*(BOX_SIZE + 20),y, Orientation.VERTICAL, new DefArray("woah", 4, node)));

        
        
        boxes.add(new BoxArray(x+300, y, Orientation.HORIZONTAL, new DefArray("test", 5, new Def(ValueBox.class))));
        boxes.add(new BoxArray(x+300, y+(BOX_SIZE + 20), Orientation.HORIZONTAL, new DefArray("test", 5, new Def(PointerBox.class))));

        //test drawing struct
        //struct def
        boxes.add(new BoxArray(x+300, y+2*(BOX_SIZE + 20), Orientation.HORIZONTAL, new DefArray("woah", 4, node)));
    }
}   