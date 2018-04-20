package Model;

import Controler.Controller;
import View.Fields;

public class Model {
//    private View view = new View();
    private Controller controller =
            new Controller(15);

    public void btnAddActionListener() {
        controller.insert(
                Integer.parseInt(
                        Fields.textField.getText()));
    }

    public void btnShowActionListener() {
    }


}
