package singleton.MenuWeight;

import singleton.DBConnector;
import singleton.Model.DocumentModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DBMenuWeightHelper {

    static public JMenu getMenu(JTextPane jTextPane){

        JMenu dbMenu = new JMenu("Database");

        JMenuItem dbUpdateMenuItem = new JMenuItem("update");
        JMenuItem dbRollbackMenuItem = new JMenuItem("rollback");

        dbUpdateMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DBConnector dbConnector = DBConnector.getInstance();
                EntityManager entityManager = dbConnector.getEntityManager();
                EntityTransaction transaction = entityManager.getTransaction();

                DocumentModel documentModel = new DocumentModel(jTextPane.getDocument(),"FakeMin");

                transaction.begin();
                entityManager.persist(documentModel);
                transaction.commit();

                TypedQuery<DocumentModel> query
                        = entityManager.createQuery("SELECT c FROM DocumentModel c",
                        DocumentModel.class);
                List<DocumentModel> results = query.getResultList();

                for (DocumentModel document : results) {
                    Document d = document.getDocument();
                    try {
                        System.out.println(d.getText(0,d.getLength()));
                    } catch (BadLocationException ex) {
                        throw new RuntimeException(ex);
                    }
                }
               // dbConnector.close();

            }
        });

        dbRollbackMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBConnector dbConnector = DBConnector.getInstance();
                EntityManager entityManager = dbConnector.getEntityManager();
               // EntityTransaction transaction = entityManager.getTransaction();
               // transaction.begin();
                TypedQuery<DocumentModel> query
                        = entityManager.createQuery("SELECT c FROM DocumentModel c",
                        DocumentModel.class);
                List<DocumentModel> results = query.getResultList();

                for (DocumentModel document : results) {
                    Document d = document.getDocument();
                    jTextPane.setDocument(d);
                    try {
                        System.out.println(d.getText(0,d.getLength()) +"--" );
                    } catch (BadLocationException ex) {
                        throw new RuntimeException(ex);
                    }
                }
//                dbConnector.close();
            }
        });

        dbMenu.add((dbUpdateMenuItem));
        dbMenu.add(dbRollbackMenuItem);

        return dbMenu;
    }



}
