package model;
import javax.swing.text.StyledDocument;

// Componet
public abstract class FontStyleComponent {
    abstract void  setStyle(StyledDocument styledDocument, int startLocation, int endLocation);
    abstract public  FontStyleComponent removeDecorator(FontStyleComponent toRemove);
    abstract protected FontStyleComponent getSubject();

}
