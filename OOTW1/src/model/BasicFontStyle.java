package model;

import org.apache.commons.lang3.NotImplementedException;

import java.awt.event.ActionEvent;

public class BasicFontStyle extends FontStyleComponent{

    @Override
    public void setStyle(ActionEvent event) {

    }

    @Override
    public void removeDecorator(FontStyleComponent toRemove) {

    }
    @Override
    protected FontStyleComponent getSubject() {
        return this;
    }



    public BasicFontStyle(){

    }




}
