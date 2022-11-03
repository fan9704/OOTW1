package Iterator;

import Database.Model.DocumentModel;

import java.util.ArrayList;
import java.util.List;

public class ConcreteVersionCollection implements VersionCollection {
    private List<DocumentModel> versionList;
    private int last = 0;

    public ConcreteVersionCollection() {
        this.versionList = new ArrayList<>();
    }

    ConcreteVersionCollection(List<DocumentModel> versionList) {
        this.versionList = versionList;
    }

    @Override
    public void add(DocumentModel documentModel) {
        this.versionList.add(documentModel);
        this.last++;
    }

    @Override
    public void addRange(List<DocumentModel> documentModel) {
        this.versionList.addAll(documentModel);
    }

    @Override
    public void remove(DocumentModel documentModel) {
        this.versionList.remove(documentModel);
        this.last--;
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
        return new ConcreteVersionIterator(this.versionList);
    }
}
