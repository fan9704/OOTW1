package singleton.MenuWeight;
import org.apache.commons.lang3.SerializationUtils;
import singleton.DBConnector;
import singleton.Model.DocumentModel;
import  java.lang.Object;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.StyledDocument;
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
            dbConnector.createDocumentModel(jTextPane);
        });

        dbRollbackMenuItem.addActionListener(e -> {
            DBConnector dbConnector = DBConnector.getInstance();
            dbConnector.rollbackToNewstDocumentModel(jTextPane);
        });

        dbMenu.add((dbUpdateMenuItem));
        dbMenu.add(dbRollbackMenuItem);

        return dbMenu;
    }


}
