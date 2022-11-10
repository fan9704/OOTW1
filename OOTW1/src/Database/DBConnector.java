package Database;

import Database.Model.DocumentModel;

import javax.persistence.*;
import java.util.Timer;
import javax.swing.*;
import java.util.TimerTask;

public class DBConnector {
    private static DBConnector dbConnector;
    private EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;
    Timer closeEntityManagerTimer;
    private DBConnector() {
//      ------------------------------------------------------------------------
//        entityManagerFactory = Persistence.createEntityManagerFactory(
//                "objectdb://localhost/test2.odb;user=admin;password=admin");
//      ------------------------------------------------------------------------

        entityManagerFactory = Persistence.createEntityManagerFactory(
                "db/TextEditor.odb");

        entityManager = entityManagerFactory.createEntityManager();
        closeEntityManagerTimer = new Timer();
        closeEntityManagerTimer.schedule(new CloseConnectionTimerTask(entityManager), 1000 * 60 * 5);

    }
    public static DBConnector getInstance() {
        if (dbConnector == null) {
            dbConnector = new DBConnector();
        }
        return dbConnector;
    }
    public EntityManager getConnection() {

        resetConnectCloseTimer();

        if (!entityManager.isOpen()) {
            entityManager = entityManagerFactory.createEntityManager();
        }

        return entityManager;
    }

    private void resetConnectCloseTimer() {
        closeEntityManagerTimer.cancel();
        closeEntityManagerTimer = new Timer();
        closeEntityManagerTimer.schedule(new CloseConnectionTimerTask(entityManager), 1000 * 60 * 5);
    }
    public void closeConnection() {
        entityManagerFactory.close();
    }
    class CloseConnectionTimerTask extends TimerTask {

        EntityManager entityManager;

        @Override
        public void run() {
            entityManager.close();
        }

        CloseConnectionTimerTask(EntityManager entityManager) {
            this.entityManager = entityManager;
        }
    }

}
