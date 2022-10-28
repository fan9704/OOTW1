package model;

import java.awt.event.ActionEvent;

public abstract class FontStyleDecorator extends FontStyleComponent {
    protected FontStyleComponent fontStyleComponent;

    FontStyleDecorator(FontStyleComponent fontStyleComponent) {
        this.fontStyleComponent = fontStyleComponent;
    }

    @Override
    public void removeDecorator(FontStyleComponent toRemove) {
        if (fontStyleComponent.equals(toRemove)) {
            fontStyleComponent = toRemove.getSubject();
        } else {
            fontStyleComponent.removeDecorator(toRemove);
        }
    }

    @Override
    public FontStyleComponent getSubject() {
        return fontStyleComponent;
    }

    @Override
    protected ActionEvent getActionEvent(){
        return fontStyleComponent.getActionEvent();
    }

}
