package bridge;

import javax.swing.*;
import java.awt.*;

public class Window extends AbstractWindow {
    public static JFrame frame;
    public Window(WindowImpl windowImpl) {
        super(windowImpl);
        this.applyTheme();
        JFrame frame = new JFrame("Window");
        this.frame =frame;
    }

    public void applyTheme(){
        this.windowImpl.setUpTheme();
    }

    public JFrame getFrame(){
        return this.frame;
    }
}
