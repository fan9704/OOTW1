package model;

import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class FontStyleDecorator extends FontStyleComponent {
    protected FontStyleComponent fontStyleComponent;

    FontStyleDecorator(FontStyleComponent fontStyleComponent) {
        this.fontStyleComponent = fontStyleComponent;
    }

    @Override
    public FontStyleComponent removeDecorator(FontStyleComponent toRemove) {
        if (fontStyleComponent.equals(toRemove)) {
            fontStyleComponent = toRemove.getSubject();
        } else if (this.equals(toRemove)) {
            return getSubject();
        } else {
            fontStyleComponent.removeDecorator(toRemove);
        }
        return this;
    }

    @Override
    public FontStyleComponent getSubject() {
        return fontStyleComponent;
    }


}
