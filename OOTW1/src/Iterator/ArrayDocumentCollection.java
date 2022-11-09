package Iterator;

import Database.Model.DocumentModel;

import java.util.ArrayList;
import java.util.List;

public class ArrayDocumentCollection implements DocumentCollection {
    private List<DocumentModel> versionList;

    public ArrayDocumentCollection() {
        this.versionList = new ArrayList<>();
    }

    @Override
    public void add(DocumentModel documentModel) {
        this.versionList.add(documentModel);
    }

    @Override
    public DocumentModel get(int index) {
        return versionList.get(index);
    }

    @Override
    public int getSize() {
        return versionList.size();
    }

    @Override
    public DocumentIterator getIterator() {
        return new ArrayDocumentDescIterator(this);
    }

    @Override
    public DocumentIterator getIterator(String order) {
        return (order.equals("desc")) ? new ArrayDocumentDescIterator(this) : new ArrayDocumentAscIterator(this);

    }

    @Override
    public void remove(int index) {
        versionList.remove(index - 1);
    }

    @Override
    public void removeAll() {
        this.versionList.clear();
    }

}
