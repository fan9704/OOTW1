package Memento;
import java.util.*;
public class careTaker {

	private List<memento> list = new ArrayList<memento>();
	private int lastIdx;
	public memento getMemento() {
		lastIdx = lastIdx - 1;
		memento lastElement = list.get(lastIdx);
		return lastElement;
	}
	public memento getLastMemento() {
		lastIdx = lastIdx + 1;
		memento NextElement = list.get(lastIdx);
		return NextElement;
	}
	public void setMemento(memento memento) {
		list.add(memento);
		lastIdx = list.size();
		
	}
}
