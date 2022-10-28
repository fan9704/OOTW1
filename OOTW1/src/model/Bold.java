package model;

import javax.swing.text.*;
import java.awt.event.ActionEvent;

public class Bold extends FontStyleDecorator {

    public Bold( FontStyleComponent fontStyleComponent){
        super(fontStyleComponent);
    }

    @Override
    public void setStyle(ActionEvent event){
        fontStyleComponent.setStyle(event);
        new StyledEditorKit.BoldAction().actionPerformed(event);
    }

}
