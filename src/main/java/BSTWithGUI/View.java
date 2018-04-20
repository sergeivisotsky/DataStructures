package BSTWithGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

class View extends JFrame {

    private Model model = new Model();
    View() {
        setTitle("Binary Search Tree");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(375, 358);
        setLocationRelativeTo(null);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblAddElement = new JLabel("Add element:");

        JTextField textField = new JTextField();
        textField.setColumns(10);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(е -> model.btnAddActionListener());

        JTextPane textPane = new JTextPane();

        JLabel lblPostorderOutput = new JLabel("Postorder output");

        JButton btnShow = new JButton("Show");

        JLabel lblEvenElementQuantity = new JLabel("Even element quantity:");

        JLabel lblEvenQuantity = new JLabel("");

        JLabel lblNodesWithTwo = new JLabel("Nodes with two children: ");

        JLabel lblNodesWithTwoChildren = new JLabel("");
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(lblAddElement)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(113)
                                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblPostorderOutput)
                                                        .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(122)
                                                .addComponent(btnShow, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(GroupLayout.Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                                        .addGap(106)
                                                        .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                        .addComponent(lblNodesWithTwo)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(lblNodesWithTwoChildren))
                                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                                        .addComponent(lblEvenElementQuantity)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(lblEvenQuantity))))
                                                .addGroup(GroupLayout.Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                                        .addGap(47)
                                                        .addComponent(textPane, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblAddElement)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addComponent(btnAdd)
                                .addGap(43)
                                .addComponent(lblPostorderOutput)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textPane, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addComponent(btnShow)
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblEvenElementQuantity)
                                        .addComponent(lblEvenQuantity))
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblNodesWithTwo)
                                        .addComponent(lblNodesWithTwoChildren))
                                .addContainerGap(94, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
    }
}
