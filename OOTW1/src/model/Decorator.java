package model;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

public abstract class Decorator extends Glyph {
    private Glyph decorator;
    private StyledDocument doc;
    private SimpleAttributeSet style;
    Decorator(Glyph decorator, StyledDocument d){
        this.decorator = decorator;
        this.doc = d;
    }
    public SimpleAttributeSet getstyle(){
        return style;
    }
    public Glyph getGlyph(){
        return decorator;
    }
    public StyledDocument getDocument(){
        return doc;
    }
    public abstract void getStyle();
}
