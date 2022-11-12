package Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WindowTitle implements WindowAttribute{
    private  String state;
    private List<Attribute> IObserver = new ArrayList<Attribute>();
    public void Notify(String state){
        this.state = state;
        for (Attribute O : IObserver) {
            O.Update(state);
        }
    }
    public void AddObserver(Attribute attribute){
        IObserver.add(attribute);
    }

}
