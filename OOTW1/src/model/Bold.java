package model;

import javax.swing.text.*;
import java.awt.event.ActionEvent;

public class Bold extends TextDecorator {
    ActionEvent e;
    public Bold(Glyph decorator ,ActionEvent e){
        super(decorator);
        this.e = e;
    }

    @Override
    public void setStyle(){
          new StyledEditorKit.BoldAction().actionPerformed(e);
    }

}
