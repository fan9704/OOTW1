package Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WindowTitle implements WindowAttribute {
    static private WindowTitle windowTitle;
    static public WindowTitle getInstance() {
        if (windowTitle == null) {
            windowTitle = new WindowTitle();
        }
        return windowTitle;
    }

    private WindowTitle(){
        this.IObserver.add(new Title());
    }

    private String state;
    private List<Attribute> IObserver = new ArrayList<Attribute>();

    public void Notify(String state) {
        this.state = state;
        for (Attribute O : IObserver) {
            O.Update(state);
        }
    }

    public void AddObserver(Attribute attribute) {
        IObserver.add(attribute);
    }

}
