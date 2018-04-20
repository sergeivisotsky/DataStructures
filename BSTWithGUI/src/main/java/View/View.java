package View;

import Controler.Controller;
import Model.Model;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private Model model = new Model();
    private Controller controller;

    public View() {
        setTitle("Binary Search Tree");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(375, 358);
        setLocationRelativeTo(null);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        Fields.lblAddElement = new JLabel("Add element:");

        Fields.textField = new JTextField();
        Fields.textField.setColumns(10);

        Fields.btnAdd = new JButton("Add");
        Fields.btnAdd.addActionListener(е -> model.btnAddActionListener());

        Fields.textPane = new JTextPane();

        Fields.lblPostorderOutput = new JLabel("Postorder output");

        Fields.btnShow = new JButton("Show");
        Fields.btnShow.addActionListener(e -> model.btnShowActionListener());

        Fields.lblSize = new JLabel("Size: ");

        Fields.lblSize = new JLabel("");

        Fields.lblEvenElementQuantity = new JLabel("Even element quantity:");

        Fields.lblEvenQuantity = new JLabel("");

        Fields.lblNodesWithTwo = new JLabel("Nodes with two children: ");

        
    }
}
