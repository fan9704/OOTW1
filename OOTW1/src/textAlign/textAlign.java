package textAlign;

import javax.swing.*;

public class textAlign {
    private IAlign alignMeth;
    private final JTextPane textPane;

    public textAlign(JTextPane p){
        textPane = p;
    }
    public void setAlignMeth(IAlign alignMeth){
        this.alignMeth = alignMeth;
    }
    public void align(){
        alignMeth.align(textPane);
    }
}
