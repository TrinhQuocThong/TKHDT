package view;

import controller.PayController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Watercounters extends JFrame {


    static  Watercounters current ;
    private JButton createRemoteButton, returnRemoteButton, notificationButton, backButton;
    private JTable Watercounterstable;
    public DefaultTableModel model;
    private ArrayList<Integer> list1;
   private List<Object[]> tableData;

    public JTable getWatercounterstable() {
        return Watercounterstable;
    }
    public void getWatercounterstable(JTable a) {
         Watercounterstable = a ;
    }



    public Watercounters(List<Object[]> tableData) {
        createAndShowGUI(tableData);
        this.tableData = tableData;
    }


    // hàm khởi tạo giá trị cho list
    public void createRm() {
        for (int i = 1; i <= 30; i++) {

        }
    }

    private void createAndShowGUI(List<Object[]> tableData) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 235, 205));
        createRemoteButton = new JButton("Create Remote");
        createRemoteButton.setBackground(new Color(255, 153, 51));
        returnRemoteButton = new JButton("Return Remote");
        returnRemoteButton.setBackground(new Color(255, 153, 51));
        notificationButton = new JButton("Notification");
        notificationButton.setBackground(new Color(255, 153, 51));
//        backButton = new JButton("<-");
//        backButton.setBackground(new Color(255, 153, 51));

        createRemoteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Đã tạo thành công Remote số : " );

                //sau khi cấp số thf xóa nó
                //trả thì cộng lại

            }
        });

        returnRemoteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Remote returned");
            }
        });

        notificationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Notification");
            }
        });

//        backButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//                Pay.currentPay.setVisible(false);
//            }
//        });

        buttonPanel.add(createRemoteButton);
        buttonPanel.add(returnRemoteButton);
        buttonPanel.add(notificationButton);

        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//        backButtonPanel.add(backButton);


//        backButtonPanel.setBackground(new Color(255, 235, 205));

        model = new DefaultTableModel();

        String[] columnNames = {"Drink", "PriceUnit", "Quantity"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for (Object[] rowData : tableData) {
            model.addRow(rowData);
        }
        Watercounterstable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(Watercounterstable);
        Watercounterstable.setFillsViewportHeight(true);


//        add(backButtonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
        getContentPane().setBackground(new Color(255, 235, 205));
        setSize(1224, 600);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }


    public static void main(String[] args) {
    }
}
