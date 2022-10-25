package model;

import javax.swing.text.StyledDocument;

public abstract class TextDecorator extends Glyph {
    private Glyph decorator;
    private StyledDocument doc;
    TextDecorator(Glyph decorator){
        this.decorator = decorator;
    }
    public abstract void setStyle();
}
