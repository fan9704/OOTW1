package model;

import javax.swing.text.*;
import java.awt.event.ActionEvent;

public class Italic extends TextDecorator {
    ActionEvent e;
    public Italic(Glyph decorator, StyledDocument d,ActionEvent e){
        super(decorator,d);
        this.e = e;
    }
    @Override
    public void setStyle() {
//        StyleConstants.setItalic(getstyle(),true);
//        int start = BasicText.getStart();
//        int end = BasicText.getEnd();
//
//        getDocument().setCharacterAttributes(start,end - start,getstyle(),false);
        new StyledEditorKit.ItalicAction().actionPerformed(e);
    }

}
