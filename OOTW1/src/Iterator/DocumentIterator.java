package Iterator;

import Database.Model.DocumentModel;

public interface DocumentIterator {
    public boolean hasNext();
    public DocumentModel next();
    public void remove();

}
