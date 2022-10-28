package model;

import java.awt.*;
import java.awt.event.ActionEvent;


// Componet
public abstract class FontStyleComponent {
    ActionEvent actionEvent;
    abstract void  setStyle();
    abstract public  void removeDecorator(FontStyleComponent toRemove);
    abstract protected FontStyleComponent getSubject();

    abstract protected ActionEvent getActionEvent();

}
