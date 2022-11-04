package Database;

import Database.Model.DocumentModel;
import Iterator.ArrayVersionCollection;
import Iterator.VersionIterator;

import javax.swing.*;

public class DatabaseManager {

    ArrayVersionCollection arrayVersionCollection;
    DatabaseRepository dbRepository;
    JTextPane textPane;

    public DatabaseManager() {
        arrayVersionCollection = new ArrayVersionCollection();
        dbRepository = new DatabaseRepository();
    }

    void fetchModel(){
        arrayVersionCollection.removeAll();
        arrayVersionCollection.addRange(dbRepository.fetchDbDocumentModelList());
    }
    public void createDocumentModel(DocumentModel documentModel){
        dbRepository.createDocumentModel(documentModel);
        arrayVersionCollection.add(documentModel);
    }

    public void updateDocumentModel(DocumentModel documentModel){
        dbRepository.updateDbDocument(documentModel);
    }

    public void deleteDocumentModel(DocumentModel documentModel){
        dbRepository.deleteDbDocument(documentModel);

        VersionIterator versionIterator = arrayVersionCollection.iterator();
        DocumentModel tmp;

        while (versionIterator.hasNext()) {
            tmp = versionIterator.getNext();
            if(tmp.documentId == documentModel.documentId){
                versionIterator.remove();
            }
        }

    }



    public VersionIterator getDocumentVersionIterator() {
        fetchModel();
        return arrayVersionCollection.iterator();
    }
}
