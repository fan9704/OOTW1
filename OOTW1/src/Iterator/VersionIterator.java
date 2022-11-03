package Iterator;

import Database.Model.DocumentModel;

public interface VersionIterator {
    public boolean hasNext();
    public DocumentModel getNext();

}
