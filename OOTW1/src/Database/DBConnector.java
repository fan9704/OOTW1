package Database;

import Database.Model.DocumentModel;

import javax.persistence.*;
import javax.swing.*;
import java.util.List;

public class DBConnector {
    private static DBConnector dbConnector;
    private final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;

    private DocumentModel editingDocumentModel;
    private List<DocumentModel> dbDocumentModelList;


    DBConnector() {
//      ------------------------------------------------------------------------
//        entityManagerFactory = Persistence.createEntityManagerFactory(
//                "objectdb://localhost/test2.odb;user=admin;password=admin");
//      ------------------------------------------------------------------------

        entityManagerFactory = Persistence.createEntityManagerFactory(
                "db/TextEditor.odb");

        entityManager = entityManagerFactory.createEntityManager();
    }


    public static DBConnector getInstance() {
        if (dbConnector == null) {
            dbConnector = new DBConnector();
        }
        return dbConnector;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void close() {
        entityManagerFactory.close();
    }

    public void createDocumentModel(JTextPane jTextPane) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        DocumentModel documentModel = new DocumentModel(jTextPane.getDocument(), "FakeMin");
        entityManager.persist(documentModel);

        transaction.commit();

        editingDocumentModel = documentModel;

        setCloneToTextPane(jTextPane,documentModel.clone());
    }

    //   =========== CRUD ===========

    public void rollbackToNewstDocumentModel(JTextPane jTextPane) {

        TypedQuery<DocumentModel> query
                = entityManager.createQuery("SELECT d FROM DocumentModel d ORDER BY d.updateTime desc", DocumentModel.class);
        query.setFirstResult(0);
        query.setMaxResults(1);

        DocumentModel dbDocument = query.getSingleResult();
        editingDocumentModel = dbDocument;

        setCloneToTextPane(jTextPane,dbDocument.clone());
    }



    private void fetchDbDocumentModelList(JTextPane jTextPane) {

        TypedQuery<DocumentModel> query
                = entityManager.createQuery("SELECT d FROM DocumentModel d ORDER BY d.updateTime desc", DocumentModel.class);

        dbDocumentModelList = query.getResultList();

    }

    //TODO : Dialog function
    public void updateDbDocument(JTextPane jTextPane){
        EntityTransaction transaction = entityManager.getTransaction();
//        editingDocumentModel = anotherDocumentModel;
        transaction.begin();
        transaction.commit();
    }

    public void deleteDbDocument(JTextPane jTextPane,int documentId){

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(editingDocumentModel);
        transaction.commit();
        editingDocumentModel = editingDocumentModel.clone();
    }



    //   =========== CRUD END ===========



    private void setCloneToTextPane(JTextPane jTextPane,DocumentModel dbDocumentModel){
        DocumentModel clone = dbDocumentModel.clone();
        jTextPane.setDocument(clone.getDocument());
    }


}
