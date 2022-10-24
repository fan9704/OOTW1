package model;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

public abstract class TextDecorator extends Glyph {
    private Glyph decorator;
    private StyledDocument doc;
    TextDecorator(Glyph decorator, StyledDocument d){
        this.decorator = decorator;
        this.doc = d;
    }
    public StyledDocument getDocument(){
        return doc;
    }
    public abstract void setStyle();
}
