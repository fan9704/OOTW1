package Iterator;

import Database.Model.DocumentModel;

import java.util.List;

public class ArrayVersionIterator implements VersionIterator {
    private ArrayVersionCollection arrayVersionCollection;
    private int iteratorIndex = 0;

    public ArrayVersionIterator(ArrayVersionCollection arrayVersionCollection) {
        this.arrayVersionCollection = arrayVersionCollection;
    }

    @Override
    public boolean hasNext() {
        if (arrayVersionCollection.getSize() > this.iteratorIndex) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public DocumentModel getNext() {
        DocumentModel documentModel = arrayVersionCollection.get(iteratorIndex);
        this.iteratorIndex++;
        return documentModel;
    }

    @Override
    public void remove() {
        arrayVersionCollection.remove(iteratorIndex);
        iteratorIndex--;
    }


}
