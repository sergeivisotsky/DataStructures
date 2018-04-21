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
        setSize(370, 400);
        setLocationRelativeTo(null);
        Fields.contentPane = new JPanel();
        Fields.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(Fields.contentPane);

        Fields.lblAddElement = new JLabel("Add element:");

        Fields.textField = new JTextField();
        Fields.textField.setColumns(10);

        Fields.btnAdd = new JButton("Add");
        Fields.btnAdd.addActionListener(e -> model.btnAddActionListener());

        Fields.lblPostorderOutput = new JLabel("Postorder output");

        Fields.btnShow = new JButton("Show");

        Fields.btnShow.addActionListener(e -> model.btnShowActionListener());

        Fields.lblEvenElementQuantity = new JLabel("Even element quantity:");

        Fields.lblEvenQuantity = new JLabel("");

        Fields.lblNodesWithTwo = new JLabel("Nodes with two children: ");

        Fields.lblSizeNumber = new JLabel("");

        Fields.lblSize = new JLabel("Size: ");

        Fields.lblSizeNumber = new JLabel("");

        JList list = new JList();
        GroupLayout gl_contentPane = new GroupLayout(Fields.contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(113)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(Fields.btnAdd, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(Fields.lblPostorderOutput)))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(122)
                                                .addComponent(Fields.btnShow, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(106)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(Fields.lblNodesWithTwo)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(Fields.lblSizeNumber))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(Fields.lblEvenElementQuantity)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Fields.lblEvenQuantity))
                                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                                .addComponent(Fields.lblSize)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(Fields.lblSizeNumber))))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(Fields.lblAddElement)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Fields.textField, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(47)
                                                .addComponent(list, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)))
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
                                .addComponent(list, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addGap(39)
                                .addComponent(Fields.btnShow)
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Fields.lblEvenElementQuantity)
                                        .addComponent(Fields.lblEvenQuantity))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Fields.lblNodesWithTwo)
                                        .addComponent(Fields.lblSizeNumber))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Fields.lblSize)
                                        .addComponent(Fields.lblSizeNumber))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Fields.contentPane.setLayout(gl_contentPane);
    }
}
