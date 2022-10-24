
package model;

import javax.swing.text.*;
import java.awt.event.ActionEvent;

public class Underline extends TextDecorator {
    ActionEvent e;
    public Underline(Glyph decorator, StyledDocument d,ActionEvent e){
        super(decorator,d);
        this.e = e;
    }
    @Override
    public void setStyle() {
//        StyleConstants.setUnderline(getstyle(),true);
//        int start = BasicText.getStart();
//        int end = BasicText.getEnd();
//
//        getDocument().setCharacterAttributes(start,end - start,getstyle(),false);
        new StyledEditorKit.UnderlineAction().actionPerformed(e);
    }

}
