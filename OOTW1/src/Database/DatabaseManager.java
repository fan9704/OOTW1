package Database;

import Database.Model.DocumentModel;
import Iterator.ArrayDocumentCollection;
import Iterator.DocumentCollection;
import Iterator.DocumentIterator;

import java.util.List;

public class DatabaseManager {

    DocumentCollection documentCollection;
    DatabaseRepository dbRepository;

    public DatabaseManager() {
        documentCollection = new ArrayDocumentCollection();
        dbRepository = new DatabaseRepository();
    }

    void fetchModel() {
        documentCollection.removeAll();
        List<DocumentModel> documentModelList = dbRepository.fetchDbDocumentModelList();
        for (DocumentModel documentModel : documentModelList) {
            documentCollection.add(documentModel);
        }
    }

    public void createDocumentModel(DocumentModel documentModel) {
        dbRepository.createDocumentModel(documentModel);
        documentCollection.add(documentModel);
    }

    public void updateDocumentModel(DocumentModel documentModel) {
        dbRepository.updateDbDocument(documentModel);
    }

    public void deleteDocumentModel(DocumentModel documentModel) {
        dbRepository.deleteDbDocument(documentModel);
    }

    public DocumentIterator getDocumentVersionIterator(String order) {
        fetchModel();
        return documentCollection.getIterator(order);
    }
}
