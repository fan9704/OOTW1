package Iterator;

import Database.Model.DocumentModel;

public class ArrayDocumentAscIterator implements DocumentIterator {
    private ArrayDocumentCollection arrayDocumentCollection;
    private int iteratorIndex;

    public ArrayDocumentAscIterator(ArrayDocumentCollection arrayDocumentCollection) {
        this.arrayDocumentCollection = arrayDocumentCollection;
        iteratorIndex = arrayDocumentCollection.getSize()-1;
    }

    @Override
    public boolean hasNext() {
        return iteratorIndex >= 0;
    }

    @Override
    public DocumentModel next() {
        DocumentModel documentModel = arrayDocumentCollection.get(iteratorIndex);
        this.iteratorIndex--;
        return documentModel;
    }

    @Override
    public void remove() {
        arrayDocumentCollection.remove(iteratorIndex);
        iteratorIndex++;
    }

}
