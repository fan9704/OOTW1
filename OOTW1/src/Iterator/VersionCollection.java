package Iterator;

import Database.Model.DocumentModel;

public interface VersionCollection {
    public void add(DocumentModel documentModel);
    public void remove(DocumentModel documentModel);
    public VersionIterator iterator();
}
