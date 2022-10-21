package bridge;

import javax.swing.*;

public abstract class AbstractWindow {
    protected WindowImpl windowImpl;

    protected AbstractWindow(WindowImpl windowImpl){
        this.windowImpl=windowImpl;
    }
    abstract void DrawText();
    abstract void DrawRect();

    public abstract JFrame getFrame();
}
