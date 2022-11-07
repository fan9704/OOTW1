package Iterator;

import Database.Model.DocumentModel;

import java.util.List;

public interface DocumentCollection {
    public void add(DocumentModel documentModel);
    public void remove(int index);
    public void removeAll();
    public DocumentModel get(int index);
    public int getSize();
    public DocumentIterator iterator();


}
