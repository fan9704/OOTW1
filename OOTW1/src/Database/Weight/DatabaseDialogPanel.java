package Database.Weight;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatabaseDialogPanel {
    JPanel documentPanel,
            contentPanel,
            operationPanel,
            layoutPanel;

    public DatabaseDialogPanel() {
        documentPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        contentPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        operationPanel = new JPanel();
        layoutPanel = new JPanel();

        layoutPanel.setLayout(new BorderLayout(10, 10));

//        documentPanel.setBounds(15,15,200,400);
        documentPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 0));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        for (int i = 0; i < 10; i++) {
            JButton tempButton = new JButton("Integer.toString(i)");
            tempButton.setPreferredSize(new Dimension(100, 50));
            documentPanel.add(tempButton);
        }


        JTextPane content = new JTextPane();
        contentPanel.add(content);


        JButton edit = new JButton("edit");
        JButton refresh = new JButton("refresh");

        operationPanel.add(edit);
        operationPanel.add(refresh);

        layoutPanel.add(documentPanel, BorderLayout.LINE_START);
        layoutPanel.add(contentPanel, BorderLayout.CENTER);
        layoutPanel.add(operationPanel, BorderLayout.PAGE_END);

    }

    public JPanel getLayoutPanel() {
        return layoutPanel;
    }


}


