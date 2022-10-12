package textAlign;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class textAlignActionListener implements ActionListener {
    private final textAlign textAlign;

    public textAlignActionListener(JTextPane textPane){
        this.textAlign = new textAlign(textPane);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        IAlign alignMeth;
        switch (e.getActionCommand()){
            case "Center":
                alignMeth = new alignCenter();
                break;
            case "Left":
                alignMeth = new alignLeft();
                break;
            case "Right":
                alignMeth = new alignRight();
                break;
            default:
                throw new RuntimeException("Not support this alignment method");
        }
        textAlign.setAlignMeth(alignMeth);
        textAlign.align();
    }
}
