package model;

import javax.swing.*;
import javax.swing.text.*;

public class BasicFontStyle extends FontStyleComponent{

    JTextPane jTextPane;

    @Override
    public void setStyle(StyledDocument styledDocument, int startLocation, int endLocation) {
            SimpleAttributeSet s = new SimpleAttributeSet();
            StyleConstants.setBold(s, false);
            StyleConstants.setItalic(s, false);
            StyleConstants.setUnderline(s, false);
            styledDocument.setCharacterAttributes(startLocation, endLocation - startLocation, s, false);
    }
    @Override
    public FontStyleComponent removeDecorator(FontStyleComponent toRemove) {
        return this;
    }
    @Override
    protected FontStyleComponent getSubject() {
        return this;
    }




    public BasicFontStyle(JTextPane jTextPane){
        this.jTextPane = jTextPane;
    }



}
