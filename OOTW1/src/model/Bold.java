package model;

import javax.swing.text.*;
import java.awt.event.ActionEvent;

public class Bold extends FontStyleDecorator {

    public Bold( FontStyleComponent fontStyleComponent){
        super(fontStyleComponent);
    }

    @Override
    public void setStyle(){
        fontStyleComponent.setStyle();
        new StyledEditorKit.BoldAction().actionPerformed(actionEvent);
    }

}
