package Iterator;

import Database.Model.DocumentModel;

import java.util.ArrayList;
import java.util.List;

public class ArrayVersionCollection implements VersionCollection {
    private List<DocumentModel> versionList;

    public ArrayVersionCollection() {
        this.versionList = new ArrayList<>();
    }

    ArrayVersionCollection(List<DocumentModel> versionList) {
        this.versionList = versionList;
    }

    @Override
    public void add(DocumentModel documentModel) {
        this.versionList.add(documentModel);
    }

    @Override
    public void addRange(List<DocumentModel> documentModel) {
        this.versionList.addAll(documentModel);
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
    public void remove(DocumentModel documentModel) {
        this.versionList.remove(documentModel);
    }

    @Override
    public void remove(int index) {
        versionList.remove(index);
    }

    @Override
    public void removeAll() {
        this.versionList.clear();
    }

    public int getLength() {
        return this.versionList.size();
    }

    @Override
    public VersionIterator iterator() {
        return new ArrayVersionIterator(this);
    }
}
