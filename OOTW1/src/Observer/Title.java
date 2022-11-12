package Observer;

import bridge.Window;

public class Title implements  Attribute{
    public void Update(String state){Window.frame.setTitle(state);
    }
}
