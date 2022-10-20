package model;

import javax.swing.text.*;
import java.awt.event.ActionEvent;

public class Bold extends Decorator{
    ActionEvent e;
    public Bold(Glyph decorator, StyledDocument d,ActionEvent e){
        super(decorator,d);
        this.e = e;
    }

    @Override
    public void getStyle(){
//        System.out.println(StyleConstants.isBold(getstyle()));
//
//        if(StyleConstants.isBold(getstyle())){
//            StyleConstants.setBold(getstyle(),false);
//        }
//        else{
//            StyleConstants.setBold(getstyle(),true);
//        }
//        int start = BasicText.getStart();
//        int end = BasicText.getEnd();
//        getDocument().setCharacterAttributes(start,end - start,getstyle(),false);
          new StyledEditorKit.BoldAction().actionPerformed(e);
    }

    @Override
    void printGlyph() {
        System.out.println("This is Bold");
    }
}
