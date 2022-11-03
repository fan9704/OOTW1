package Database.Weight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatabaseDialogPanel implements ActionListener {
    JPanel documentPanel,
            contentPanel,
            operationPanel,
            layoutPanel;

    DatabaseDialogPanel() {
        documentPanel = new JPanel();
        contentPanel = new JPanel();
        operationPanel = new JPanel();
        layoutPanel = new JPanel();

        layoutPanel.setLayout(new BorderLayout(10, 10));
//        JButton btn1



    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
