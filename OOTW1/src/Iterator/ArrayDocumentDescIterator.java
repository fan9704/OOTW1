package Iterator;

import Database.Model.DocumentModel;

public class ArrayDocumentDescIterator implements DocumentIterator {
    private ArrayDocumentCollection arrayVersionCollection;
    private int iteratorIndex = 0;

    public ArrayDocumentDescIterator(ArrayDocumentCollection arrayVersionCollection) {
        this.arrayVersionCollection = arrayVersionCollection;
    }

    @Override
    public boolean hasNext() {
        return arrayVersionCollection.getSize() > this.iteratorIndex;
    }

    @Override
    public DocumentModel next() {
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
