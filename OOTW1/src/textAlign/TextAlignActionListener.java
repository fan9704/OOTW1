package textAlign;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TextAlignActionListener implements ActionListener {
    private final TextAlign textAlign;

    public TextAlignActionListener(AlignMeth a){
        this.textAlign = new TextAlign(a);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        textAlign.align();
    }
}
