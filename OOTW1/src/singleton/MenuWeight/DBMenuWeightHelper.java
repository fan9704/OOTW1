package singleton.MenuWeight;

import singleton.DBConnector;
import singleton.Model.DocumentModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DBMenuWeightHelper {

    static public JMenu getMenu(JTextPane jTextPane) {

        JMenu dbMenu = new JMenu("Database");

        JMenuItem dbUpdateMenuItem = new JMenuItem("update");
        JMenuItem dbRollbackMenuItem = new JMenuItem("rollback");

        dbUpdateMenuItem.addActionListener(e -> {

            DBConnector dbConnector = DBConnector.getInstance();
            EntityManager entityManager = dbConnector.getEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            DocumentModel documentModel = new DocumentModel(jTextPane.getDocument(), "FakeMin");

            transaction.begin();
            entityManager.persist(documentModel);
            transaction.commit();

        });

        dbRollbackMenuItem.addActionListener(e -> {
            DBConnector dbConnector = DBConnector.getInstance();
            EntityManager entityManager = dbConnector.getEntityManager();
            // EntityTransaction transaction = entityManager.getTransaction();
            // transaction.begin();
            TypedQuery<DocumentModel> query
                    = entityManager.createQuery("SELECT d FROM DocumentModel d ORDER BY d.updateTime", DocumentModel.class);
            query.setFirstResult(0);
            query.setMaxResults(1);

             DocumentModel dbDocument = query.getSingleResult();

            jTextPane.setDocument(dbDocument.getDocument());


        });

        dbMenu.add((dbUpdateMenuItem));
        dbMenu.add(dbRollbackMenuItem);

        return dbMenu;
    }


}
