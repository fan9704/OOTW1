package Database;

import Database.Model.DocumentModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.swing.*;
import java.util.List;

public class DatabaseRepository {
    DBConnector dbConnector;

    DatabaseRepository(){
        dbConnector = DBConnector.getInstance();
    }




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

        EntityManager entityManager = dbConnector.getEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(documentModel);
        transaction.commit();

    }


    public List<DocumentModel> fetchDbDocumentModelList() {
        EntityManager entityManager = dbConnector.getEntityManager();

        TypedQuery<DocumentModel> query
                = entityManager.createQuery("SELECT d FROM DocumentModel d ORDER BY d.updateTime desc", DocumentModel.class);

        return query.getResultList();

    }

    public void updateDbDocument(){
        EntityManager entityManager = dbConnector.getEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
//        editingDocumentModel = anotherDocumentModel;
        transaction.begin();
        transaction.commit();
    }

    public void deleteDbDocument(int documentId,DocumentModel editingDocumentModel){
        EntityManager entityManager = dbConnector.getEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(editingDocumentModel);
        transaction.commit();
    }









}
