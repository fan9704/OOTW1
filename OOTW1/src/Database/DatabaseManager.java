package Database;

import Database.Model.DocumentModel;
import Iterator.ArrayVersionCollection;
import Iterator.VersionIterator;

import javax.swing.*;

public class DatabaseManager {

    ArrayVersionCollection arrayVersionCollection;
    DatabaseRepository dbRepository;
    JTextPane textPane;

    DatabaseManager(JTextPane textPane) {
        ArrayVersionCollection arrayVersionCollection = new ArrayVersionCollection();
        dbRepository = new DatabaseRepository();
        this.textPane = textPane;
    }

    void fetchModel(){
        arrayVersionCollection.removeAll();
        arrayVersionCollection.addRange(dbRepository.fetchDbDocumentModelList());
    }
    void createDocumentModel(DocumentModel documentModel){
        dbRepository.createDocumentModel(documentModel);
        arrayVersionCollection.add(documentModel);
    }

    void updateDocumentModel(DocumentModel documentModel){

    }



    public VersionIterator getDocumentVersionIterator() {
        return arrayVersionCollection.iterator();
    }
}
