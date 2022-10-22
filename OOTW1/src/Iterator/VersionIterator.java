package Iterator;

import singleton.Model.DocumentModel;

public interface VersionIterator {
    public boolean hasNext();
    public DocumentModel getNext();

}
