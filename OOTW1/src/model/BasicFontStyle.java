package model;

import org.apache.commons.lang3.NotImplementedException;

import java.awt.event.ActionEvent;

public class BasicFontStyle extends FontStyleComponent{

    @Override
    void setStyle() {

    }

    @Override
    public void removeDecorator(FontStyleComponent toRemove) {

    }
    @Override
    protected FontStyleComponent getSubject() {
        return this;
    }

    @Override
    protected ActionEvent getActionEvent() {
        return actionEvent;
    }

    BasicFontStyle(ActionEvent actionEvent){
        this.actionEvent = actionEvent;
    }




}
