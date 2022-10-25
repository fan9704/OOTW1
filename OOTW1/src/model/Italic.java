package model;

import javax.swing.text.*;
import java.awt.event.ActionEvent;

public class Italic extends TextDecorator {
    ActionEvent e;
    public Italic(Glyph decorator,ActionEvent e){
        super(decorator);
        this.e = e;
    }
    @Override
    public void setStyle() {
        new StyledEditorKit.ItalicAction().actionPerformed(e);
    }

}
