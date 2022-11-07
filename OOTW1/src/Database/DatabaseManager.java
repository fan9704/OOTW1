package Database;

import Database.Model.DocumentModel;
import Iterator.ArrayDocumentCollection;
import Iterator.DocumentIterator;

import java.util.List;

public class DatabaseManager {

    ArrayDocumentCollection arrayVersionCollection;
    DatabaseRepository dbRepository;

    public DatabaseManager() {
        arrayVersionCollection = new ArrayDocumentCollection();
        dbRepository = new DatabaseRepository();
    }

    void fetchModel() {
        arrayVersionCollection.removeAll();
        List<DocumentModel> documentModelList = dbRepository.fetchDbDocumentModelList();
        for (DocumentModel documentModel : documentModelList) {
            arrayVersionCollection.add(documentModel);
        }
    }

    public void createDocumentModel(DocumentModel documentModel) {
        dbRepository.createDocumentModel(documentModel);
        arrayVersionCollection.add(documentModel);
    }

    public void updateDocumentModel(DocumentModel documentModel) {
        dbRepository.updateDbDocument(documentModel);
    }

    public void deleteDocumentModel(DocumentModel documentModel) {
        dbRepository.deleteDbDocument(documentModel);

        DocumentIterator documentIterator = arrayVersionCollection.iterator();
        DocumentModel tmp;

        while (documentIterator.hasNext()) {
            tmp = documentIterator.next();
            if (tmp.documentId == documentModel.documentId) {
                documentIterator.remove();
            }
        }

    }

    public DocumentIterator getDocumentVersionIterator() {
        fetchModel();
        return arrayVersionCollection.iterator();
    }
}
