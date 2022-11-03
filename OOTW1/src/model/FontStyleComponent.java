package model;
import javax.swing.text.StyledDocument;

// Componet
interface FontStyleComponent {
     void  setStyle(StyledDocument styledDocument, int startLocation, int endLocation);
     FontStyleComponent removeDecorator(FontStyleComponent toRemove);
     FontStyleComponent getSubject();

}
