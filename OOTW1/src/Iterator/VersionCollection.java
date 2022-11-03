package Iterator;

import Database.Model.DocumentModel;

import java.util.List;

public interface VersionCollection {
    public void add(DocumentModel documentModel);
    public void addRange(List<DocumentModel> documentModel);

    public void remove(DocumentModel documentModel);
    public void removeAll();
    public VersionIterator iterator();


}
