package PresentationLayer;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class ChefGUI extends javax.swing.JFrame implements Observer {
    private String message;
    public ChefGUI(){}
    public ChefGUI(String message){
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.message = message;
    }

    @Override
    public void update(Observable o, Object arg) {
        ChefGUI chef = new ChefGUI("Chef saw note. Starting to prepare meal for" +
                " table " + ((Integer)arg).intValue());
        try {
            chef.displayMessage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void displayMessage() throws InterruptedException {
        JOptionPane.showMessageDialog(this,message);
        this.setVisible(false);
    }
}
