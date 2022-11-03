
package model;

import javax.swing.text.*;

public class Underline extends FontStyleDecorator {
    public Underline( FontStyleComponent fontStyleComponent){
        super(fontStyleComponent);
    }

    @Override
    public void setStyle(StyledDocument styledDocument, int startLocation, int endLocation){
        fontStyleComponent.setStyle(styledDocument,startLocation, endLocation);
        SimpleAttributeSet s = new SimpleAttributeSet();
        StyleConstants.setUnderline(s, true);
        styledDocument.setCharacterAttributes(startLocation, endLocation - startLocation, s, false);
    }
}
