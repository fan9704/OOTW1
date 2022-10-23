package Memento;
import java.util.*;
public class careTaker {
	private Stack<memento> st = new Stack<memento>();
	private List<memento> list = new ArrayList<memento>();
	int lastIdx;
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
//		this.memento = memento;
//		st.push(memento);
		list.add(memento);
		lastIdx = list.size();
		
	}
}
