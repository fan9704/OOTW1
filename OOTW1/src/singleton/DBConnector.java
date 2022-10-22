package singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnector {
    private static DBConnector dbConnector;
    private final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;

    DBConnector() {
//      ------------------------------------------------------------------------
//        entityManagerFactory = Persistence.createEntityManagerFactory(
//                "objectdb://localhost/test.odb;user=admin;password=admin");
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
}
