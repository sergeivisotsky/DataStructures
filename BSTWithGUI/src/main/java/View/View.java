package View;

import Controler.Controller;
import Model.Model;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
        Fields.btnShow.addActionListener(e -> controller.postorderOutput());

        Fields.lblEvenElementQuantity = new JLabel("Even element quantity:");

        Fields.lblEvenQuantity = new JLabel("");

        Fields.lblNodesWithTwo = new JLabel("Nodes with two children: ");

        Fields.lblNodesWithTwoChildren = new JLabel("");
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(Fields.lblAddElement)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Fields.textField, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(113)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(Fields.lblPostorderOutput)
                                                        .addComponent(Fields.btnAdd, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(122)
                                                .addComponent(Fields.btnShow, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(GroupLayout.Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                                        .addGap(106)
                                                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                        .addComponent(Fields.lblNodesWithTwo)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(Fields.lblNodesWithTwoChildren))
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                        .addComponent(Fields.lblEvenElementQuantity)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(Fields.lblEvenQuantity))))
                                                .addGroup(GroupLayout.Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                                        .addGap(47)
                                                        .addComponent(Fields.textPane, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Fields.lblAddElement)
                                        .addComponent(Fields.textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addComponent(Fields.btnAdd)
                                .addGap(43)
                                .addComponent(Fields.lblPostorderOutput)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Fields.textPane, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(Fields.btnShow)
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Fields.lblEvenElementQuantity)
                                        .addComponent(Fields.lblEvenQuantity))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Fields.lblNodesWithTwo)
                                        .addComponent(Fields.lblNodesWithTwoChildren))
                                .addContainerGap(94, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
