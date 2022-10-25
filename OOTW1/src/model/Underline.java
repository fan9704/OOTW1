
package model;

import javax.swing.text.*;
import java.awt.event.ActionEvent;

public class Underline extends TextDecorator {
    ActionEvent e;
    public Underline(Glyph decorator,ActionEvent e){
        super(decorator);
        this.e = e;
    }
    @Override
    public void setStyle() {
        new StyledEditorKit.UnderlineAction().actionPerformed(e);
    }

}
