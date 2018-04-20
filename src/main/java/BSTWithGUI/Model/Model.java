package BSTWithGUI.Model;

import BSTWithGUI.Controler.Controller;
import BSTWithGUI.View.Fields;
import BSTWithGUI.View.View;

public class Model {
//    private View view = new View();
    private Controller controller =
            new Controller(15);

    public void btnAddActionListener() {
        controller.insert(
                Integer.parseInt(
                        Fields.textField.getText()));
    }

    /*public void btnShowActionListener() {
        Fields.textPane.setText(controller.postorderOutput());
    }*/
}
