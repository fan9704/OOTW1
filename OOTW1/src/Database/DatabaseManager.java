package Database;

import Iterator.ConcreteVersionCollection;

import javax.swing.*;

public class DatabaseManager {

    ConcreteVersionCollection concreteVersionCollection;
    DatabaseRepository dbRepository;
    JTextPane textPane;

    DatabaseManager(JTextPane textPane) {
        ConcreteVersionCollection concreteVersionCollection = new ConcreteVersionCollection();
        dbRepository = new DatabaseRepository();
        this.textPane = textPane;
    }








}
