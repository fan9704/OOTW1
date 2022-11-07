package Database.Weight;

import Database.DatabaseManager;
import Database.Model.DocumentModel;
import Iterator.DocumentIterator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class DatabaseDialogPanel implements ActionListener {
    JPanel documentPanel,
            contentPanel,
            operationPanel,
            layoutPanel;

    DatabaseManager databaseManager;
    JTextPane textPane, dialogTextPane;

    DocumentModel editingDocumentModel;
    JTextField fileNameJTextField = new JTextField();


    public DatabaseDialogPanel(JTextPane textPane,DocumentModel editingDocumentModel) {
        this.textPane = textPane;
        this.editingDocumentModel = editingDocumentModel;

        dialogTextPane = new JTextPane();
        dialogTextPane.setEditable(false);

        databaseManager = new DatabaseManager();

        contentPanel = getContentPanel();
        contentPanel.add(dialogTextPane);

        documentPanel = getDocumentPanel();

        operationPanel = getOperationPanel();
        layoutPanel = new JPanel();
        layoutPanel.setLayout(new BorderLayout(10, 10));


        layoutPanel.add(documentPanel, BorderLayout.LINE_START);
        layoutPanel.add(contentPanel, BorderLayout.CENTER);
        layoutPanel.add(operationPanel, BorderLayout.PAGE_END);

    }

    private JPanel getDocumentPanel() {
        JPanel documentPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        documentPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 0));


        DocumentIterator documentIterator = databaseManager.getDocumentVersionIterator();
        DocumentModel document;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");


        while (documentIterator.hasNext()) {
            document = documentIterator.next();
            JButton tempButton = new JButton("<html>Author:" + document.getFileName() + "<br/>" +
                    "CreateAt：" + simpleDateFormat.format(document.getCreatedDate()).toString() + "<br/>" +
                    "UpdateAt：" + simpleDateFormat.format(document.getUpdateTime()).toString() +
                    "</html>");
            tempButton.setPreferredSize(new Dimension(200, 50));

            DocumentModel finalDocument = document.clone();
            tempButton.addActionListener((e) -> {
                editingDocumentModel.documentId = finalDocument.getDocumentId();
                editingDocumentModel.document = finalDocument.getDocument();
                dialogTextPane.setDocument(finalDocument.getDocument());
            });
            documentPanel.add(tempButton);

            if (editingDocumentModel.documentId == finalDocument.documentId){
                dialogTextPane.setDocument(finalDocument.getDocument());
            }

        }

        return documentPanel;
    }

    private JPanel getContentPanel() {
        JPanel contentPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPanel.add(dialogTextPane);
        return contentPanel;
    }

    private JPanel getOperationPanel() {
        JPanel operationPanel = new JPanel();

        JButton edit = new JButton("edit");
        edit.setActionCommand("edit");
        edit.addActionListener(this);

        JButton update = new JButton("update");
        update.setActionCommand("update");
        update.addActionListener(this);

        JButton delete = new JButton("delete");
        delete.setActionCommand("delete");
        delete.addActionListener(this);

        JTextField jTextField = new JTextField();

        operationPanel.add(edit);
        operationPanel.add(update);
        operationPanel.add(delete);

        return operationPanel;
    }


    public JPanel getLayoutPanel() {
        return layoutPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch (command) {
            case "delete":
                databaseManager.deleteDocumentModel(editingDocumentModel);

                layoutPanel.remove(documentPanel);

                documentPanel = getDocumentPanel();
                layoutPanel.add(documentPanel, BorderLayout.LINE_START);


                layoutPanel.revalidate();
                layoutPanel.repaint();

                break;
            case "edit":
                DocumentModel cloneDocumentModel = editingDocumentModel.clone();
                textPane.setDocument(cloneDocumentModel.getDocument());
                break;
            case "update":
                editingDocumentModel.document = textPane.getDocument();
                databaseManager.updateDocumentModel(editingDocumentModel);
                dialogTextPane.setDocument(editingDocumentModel.document);
                break;

        }

    }


}


