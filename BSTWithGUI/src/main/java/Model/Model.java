package Model;

import Controler.Controller;
import View.Fields;

import javax.swing.*;

public class Model {

    private Controller controller =
            new Controller();

    public void btnAddActionListener() {
        if (!controller.isFull()) {
            controller.insert(
                    Integer.parseInt(
                            Fields.textField.getText()));
        } else {
            JOptionPane.showMessageDialog(Fields.contentPane, "No more elements is able to add!");
        }
    }

    public void btnShowActionListener() {
        if (!controller.isEmpty()) {
            controller.postorderOutput();
        } else {
            JOptionPane.showMessageDialog(Fields.contentPane, "BST is empty!");
        }
    }
}
