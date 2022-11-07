package Iterator;

import Database.Model.DocumentModel;

import java.util.ArrayList;
import java.util.List;

public class ArrayDocumentCollection implements DocumentCollection {
    private List<DocumentModel> versionList;

    public ArrayDocumentCollection() {
        this.versionList = new ArrayList<>();
    }

    ArrayDocumentCollection(List<DocumentModel> versionList) {
        this.versionList = versionList;
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
    public void remove(int index) {
        versionList.remove(index-1);
    }

    @Override
    public void removeAll() {
        this.versionList.clear();
    }

    public int getLength() {
        return this.versionList.size();
    }

    @Override
    public DocumentIterator iterator() {
        return new ArrayDocumentUpdateTimeIterator(this);
    }
}
