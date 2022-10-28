package bridge;

import javax.swing.*;

public abstract class AbstractWindow {
    protected WindowImpl windowImpl;

    public AbstractWindow(WindowImpl windowImpl){
        this.windowImpl=windowImpl;
    }

    public abstract JFrame getFrame();
}
