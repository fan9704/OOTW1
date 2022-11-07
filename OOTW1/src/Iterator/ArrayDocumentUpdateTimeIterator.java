package Iterator;

import Database.Model.DocumentModel;

public class ArrayDocumentUpdateTimeIterator implements DocumentIterator {
    private ArrayDocumentCollection arrayVersionCollection;
    private int iteratorIndex = 0;

    public ArrayDocumentUpdateTimeIterator(ArrayDocumentCollection arrayVersionCollection) {
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
