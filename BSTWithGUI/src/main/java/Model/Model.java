package Model;

import Controler.Controller;
import View.Fields;

import javax.swing.*;

public class Model {
    //        private View view = new View();
    private Controller controller =
            new Controller(15);
//    private DefaultListModel<Integer> model = new DefaultListModel<>();

    public void btnAddActionListener() {
        controller.insert(
                Integer.parseInt(
                        Fields.textField.getText()));
    }

    public void btnShowActionListener() {
        controller.postorderOutput();
    }


}
