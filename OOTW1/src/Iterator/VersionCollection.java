package Iterator;

import singleton.Model.DocumentModel;

import java.util.List;

public interface VersionCollection {
    public void add(DocumentModel documentModel);
    public void remove(DocumentModel documentModel);
    public VersionIterator iterator();
}
