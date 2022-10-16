package model;

import javax.swing.text.*;
import java.awt.event.ActionEvent;

public class Italic extends Decorator{
    ActionEvent e;
    public Italic(Glyph decorator, StyledDocument d,ActionEvent e){
        super(decorator,d);
        this.e = e;
    }
    @Override
    public void getStyle() {
//        StyleConstants.setItalic(getstyle(),true);
//        int start = BasicText.getStart();
//        int end = BasicText.getEnd();
//
//        getDocument().setCharacterAttributes(start,end - start,getstyle(),false);
        new StyledEditorKit.ItalicAction().actionPerformed(e);
    }

    @Override
    void printGlyph() {
        System.out.println("This is Italic");
    }
}
