
package model;

import javax.swing.text.*;
import java.awt.event.ActionEvent;

public class Underline extends FontStyleDecorator {
    public Underline( FontStyleComponent fontStyleComponent){
        super(fontStyleComponent);
    }

    @Override
    public void setStyle(ActionEvent event){
        fontStyleComponent.setStyle(event);
        new StyledEditorKit.UnderlineAction().actionPerformed(event);
    }
}
