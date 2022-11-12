package Database;

import Database.Model.DocumentModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class DatabaseRepository {

//    public void rollbackToNewstDocumentModel() {
//
//        TypedQuery<DocumentModel> query
//                = entityManager.createQuery("SELECT d FROM DocumentModel d ORDER BY d.updateTime desc", DocumentModel.class);
//        query.setFirstResult(0);
//        query.setMaxResults(1);
//
//        DocumentModel dbDocument = query.getSingleResult();
//        editingDocumentModel = dbDocument;
//
//        setCloneToTextPane(jTextPane,dbDocument.clone());
//    }

    public void createDocumentModel(DocumentModel documentModel) {
        DBConnector dbConnector = DBConnector.getInstance();
        EntityManager entityManager = dbConnector.getConnection();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(documentModel);
        transaction.commit();

    }


    public List<DocumentModel> fetchDbDocumentModelList() {
        DBConnector dbConnector = DBConnector.getInstance();
        EntityManager entityManager = dbConnector.getConnection();

        TypedQuery<DocumentModel> query
                = entityManager.createQuery("SELECT d FROM DocumentModel d ORDER BY d.updateTime desc", DocumentModel.class);

        return query.getResultList();

    }

    public void updateDbDocument(DocumentModel documentModel){
        DBConnector dbConnector = DBConnector.getInstance();
        EntityManager entityManager = dbConnector.getConnection();
        EntityTransaction transaction = entityManager.getTransaction();

        DocumentModel dbDocumentModel = entityManager.find(DocumentModel.class,documentModel.documentId);

        transaction.begin();
        dbDocumentModel.document = documentModel.document;
        transaction.commit();
    }

    public void deleteDbDocument(int documentId){
        DBConnector dbConnector = DBConnector.getInstance();
        EntityManager entityManager = dbConnector.getConnection();
        EntityTransaction transaction = entityManager.getTransaction();

        DocumentModel dbDocumentModel = entityManager.find(DocumentModel.class,documentId);

        transaction.begin();
        entityManager.remove(dbDocumentModel);
        transaction.commit();
    }









}
