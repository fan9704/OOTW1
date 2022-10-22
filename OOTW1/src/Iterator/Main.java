package Iterator;

import singleton.DBConnector;
import singleton.Model.DocumentModel;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DBConnector dbConnector = DBConnector.getInstance();
        EntityManager entityManager = dbConnector.getEntityManager();

        TypedQuery<DocumentModel> documentQuery = entityManager.createQuery("SELECT document from DocumentModel document",DocumentModel.class);
        List<DocumentModel> documentModelList = documentQuery.getResultList();


        VersionCollection collection = new ConcreteVersionCollection(documentModelList);
        VersionIterator versionIterator = collection.iterator();
        while (versionIterator.hasNext()){
            DocumentModel documentModel = versionIterator.getNext();
            System.out.println(""+documentModel.toString());
        }
    }
}
