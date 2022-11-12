package Observer;

public interface WindowAttribute {
    public void Notify(String state);
    public void AddObserver(Attribute attribute);

}
