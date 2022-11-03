package Database;

import Database.Model.DocumentModel;

import javax.persistence.*;
import java.util.Timer;
import javax.swing.*;
import java.util.List;
import java.util.TimerTask;

public class DBConnector {
    private static DBConnector dbConnector;
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    Timer closeEntityManagerTimer;

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
        closeEntityManagerTimer = new Timer();
        closeEntityManagerTimer.schedule(new CloseEntityManagerTimerTask(entityManager), 1000 * 60 * 5);

    }


    public static DBConnector getInstance() {
        if (dbConnector == null) {
            dbConnector = new DBConnector();
        }
        return dbConnector;
    }

    public EntityManager getEntityManager() {

        resetCloseEntityManagerTimer();

        if (!entityManager.isOpen()) {
            entityManager = entityManagerFactory.createEntityManager();
        }

        return entityManager;
    }

    private void resetCloseEntityManagerTimer() {
        closeEntityManagerTimer.cancel();
        closeEntityManagerTimer = new Timer();
        closeEntityManagerTimer.schedule(new CloseEntityManagerTimerTask(entityManager), 1000 * 60 * 5);
    }

    public void close() {
        entityManagerFactory.close();
    }


    private void setCloneToTextPane(JTextPane jTextPane, DocumentModel dbDocumentModel) {
        DocumentModel clone = dbDocumentModel.clone();
        jTextPane.setDocument(clone.getDocument());
    }


    class CloseEntityManagerTimerTask extends TimerTask {

        EntityManager entityManager;

        @Override
        public void run() {
            entityManager.close();
        }

        CloseEntityManagerTimerTask(EntityManager entityManager) {
            this.entityManager = entityManager;
        }
    }


}
