package model;

import java.awt.*;
import java.awt.event.ActionEvent;


// Componet
public abstract class FontStyleComponent {
    abstract void  setStyle(ActionEvent actionEvent);
    abstract public  void removeDecorator(FontStyleComponent toRemove);
    abstract protected FontStyleComponent getSubject();

}
