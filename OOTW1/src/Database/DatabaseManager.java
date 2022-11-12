package Database;

import Database.Model.DocumentModel;
import Iterator.ArrayDocumentCollection;
import Iterator.DocumentCollection;
import Iterator.DocumentIterator;

import java.util.List;

public class DatabaseManager {

    DocumentCollection documentCollection;
    public DatabaseManager() {
        documentCollection = new ArrayDocumentCollection();
    }

    private void fetchModel() {
        documentCollection.removeAll();
        DatabaseRepository dbRepository = new DatabaseRepository();
        List<DocumentModel> documentModelList = dbRepository.fetchDbDocumentModelList();
        for (DocumentModel documentModel : documentModelList) {
            documentCollection.add(documentModel);
        }
    }

    public void createDocumentModel(DocumentModel documentModel) {
        DatabaseRepository dbRepository = new DatabaseRepository();
        dbRepository.createDocumentModel(documentModel);
        documentCollection.add(documentModel);
    }

    public void updateDocumentModel(DocumentModel documentModel) {
        DatabaseRepository dbRepository = new DatabaseRepository();
        dbRepository.updateDbDocument(documentModel);
    }

    public void deleteDocumentModel(DocumentModel documentModel) {
        DatabaseRepository dbRepository = new DatabaseRepository();
        dbRepository.deleteDbDocument(documentModel.documentId);
    }

    public DocumentIterator getDocumentVersionIterator(String order) {
        fetchModel();
        return documentCollection.getIterator(order);
    }

    static public void closeConnection(){
        DBConnector dbConnector = DBConnector.getInstance();
        dbConnector.closeConnection();
    }
}
