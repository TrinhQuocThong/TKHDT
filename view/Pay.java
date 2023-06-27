package view;

import MilkTeaStore.IPayStrategy;
import controller.PayController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pay extends JFrame {
    private JRadioButton cashPayment, cardPayment, onlinePayment;
    private JLabel cashDiscountLabel, cardDiscountLabel, onlineDiscountLabel;  // label để hiển thị mã giảm giá

    private String resultRandom; //bến lưu giá trị random để không phải gọi lại hàm đã random
    private JButton payButton, backButton;
    private JLabel totalLabel;
    private JTextField discountCodeField;
    private JButton checkCodeButton;
    private JTable drinksTable;
    private JLabel discountLabel;  // label để hiển thị mã giảm giá
    private IPayStrategy ipay ;


    private JButton createReamote;




    public static Pay currentPay;

    public static Pay setCurrentPay(Pay pay) {
        return currentPay = pay;
    }

    // hàm check xem là cái table có rỗng không
    public boolean isEmptyTable() {
        if (drinksTable.getRowCount() == 0) {
            return true;
        }
        return false;
    }

    public JTable get() {
        return this.drinksTable;
    }




    ///// khai basotable data bên ngoài

    public List<Object[]> tableData ;


    ///


    //tạo hashmap cho remote

    HashMap<Integer,Boolean> remote = new HashMap<>();

    public Pay(List<Object[]> tableData) {
        super("Payment");


        // tạo bảng
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
        drinksTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(drinksTable);
        drinksTable.setFillsViewportHeight(true);




        cashPayment = new JRadioButton("Cash Payment");
        cardPayment = new JRadioButton("Card Payment");
        onlinePayment = new JRadioButton("Online Payment");

        // kiểm tra xem cái bảng có empty không (có thì vô hiệu hóa radioi , không thì không vô hiệu hoa)
        if (isEmptyTable()) {
            cashPayment.setEnabled(false);
            cardPayment.setEnabled(false);
            onlinePayment.setEnabled(false);

        }
        ButtonGroup group = new ButtonGroup();
        group.add(cashPayment);
        group.add(cardPayment);
        group.add(onlinePayment);

        payButton = new JButton("Pay");

        payButton.setBackground(new Color(255, 153, 51));
        payButton.setPreferredSize(new Dimension(80, 30));

        totalLabel = new JLabel("Total: " + Order.currentOrder.getprice());


        payButton.addActionListener(new PayController(this));


        backButton = new JButton("←");
        backButton.setBackground(new Color(255, 153, 51));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        createReamote = new JButton("Create remote");
        createReamote.setBackground(new Color(255, 153, 51));

        createReamote.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                int crm = createRemote();


            }
        });






        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(backButton, BorderLayout.WEST);
        add(topPanel, BorderLayout.NORTH);
        topPanel.setBackground(new Color(255, 235, 205));
        JPanel paymentPanel = new JPanel(new GridLayout(3, 1));
        paymentPanel.add(cashPayment);
        paymentPanel.add(cardPayment);
        paymentPanel.add(onlinePayment);
        cashPayment.setOpaque(false);
        cardPayment.setOpaque(false);
        onlinePayment.setOpaque(false);
        add(paymentPanel, BorderLayout.WEST);
        paymentPanel.setBackground(new Color(255, 235, 205));
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(totalLabel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setBackground(new Color(255, 235, 205));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(payButton);
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setBackground(new Color(255, 235, 205));
        discountCodeField = new JTextField(15);
        checkCodeButton = new JButton("Check Discount Code");
        checkCodeButton.setBackground(new Color(255, 153, 51));
        checkCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputCode = discountCodeField.getText();
                boolean isValid = checkDiscountCode(inputCode);

                if (inputCode.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "vui lòng nhập vào mã giảm giá !");
                } else if (isValid) {
                    JOptionPane.showMessageDialog(null, "Mã giảm giá hợp lệ bạn được giảm 50% !");

                    Order.currentOrder.setTotalPrice(Order.currentOrder.getprice() / 2);
                    // hiển thị lại giá
                    totalLabel.setText("Total: " + Order.currentOrder.getprice());
                    //vô hiệu hóa nút
                    checkCodeButton.setEnabled(false);
                    // vô hiệu hóa textfied
                    discountCodeField.setEnabled(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Mã giảm giá không hợp lệ. Vui lòng thử lại!");
                }
            }
        });

        JPanel discountPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        discountPanel.add(new JLabel("Nhập mã giảm giá: "));
        discountPanel.add(discountCodeField);
        discountPanel.add(checkCodeButton);//thêm button checkcode vào khi ấn radio hiện ra
        discountPanel.add(createReamote); // thêm button additio
        //tạo sự kiện cho radiobutton
        cashPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buttonPanel.add(discountPanel);
                buttonPanel.revalidate();
                buttonPanel.repaint();
            }
        });

        cardPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPanel.add(discountPanel);
                buttonPanel.revalidate();
                buttonPanel.repaint();
            }
        });

        onlinePayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPanel.add(discountPanel);
                buttonPanel.revalidate();
                buttonPanel.repaint();
            }
        });


        // Tạo các label mới để hiển thị mã giảm giá
        cashDiscountLabel = new JLabel();
        cardDiscountLabel = new JLabel();
        onlineDiscountLabel = new JLabel();

        // Mặc định các label  bị ẩn
        cashDiscountLabel.setVisible(false);
        cardDiscountLabel.setVisible(false);
        onlineDiscountLabel.setVisible(false);

        cashPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultRandom = generateRandomCode();
                cashDiscountLabel.setText("Mã giảm giá: " + resultRandom);  // Cập nhật mã giảm giá
                cashDiscountLabel.setVisible(true);  // Hiển thị label

                // Ẩn các label khác
                cardDiscountLabel.setVisible(false);
                onlineDiscountLabel.setVisible(false);
            }
        });

        cardPayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultRandom = generateRandomCode();
                cardDiscountLabel.setText("Mã giảm giá: " + resultRandom);  // Cập nhật mã giảm giá
                cardDiscountLabel.setVisible(true);  // Hiển thị label

                // Ẩn các label khác
                cashDiscountLabel.setVisible(false);
                onlineDiscountLabel.setVisible(false);
            }
        });

        onlinePayment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultRandom = generateRandomCode();
                onlineDiscountLabel.setText("Mã giảm giá: " + resultRandom);  // Cập nhật mã giảm giá
                onlineDiscountLabel.setVisible(true);  // Hiển thị label

                // Ẩn các label khác
                cashDiscountLabel.setVisible(false);
                cardDiscountLabel.setVisible(false);
            }
        });

        //...
        //font chữ
        // Thiết lập kích thước và kiểu chữ cho các label
        Font labelFont = new Font("Arial", Font.PLAIN, 10);  // Chọn kiểu chữ Arial, không đậm, kích thước 10
        cashDiscountLabel.setFont(labelFont);
        cardDiscountLabel.setFont(labelFont);
        onlineDiscountLabel.setFont(labelFont);
        JPanel radioPanel = new JPanel(new GridLayout(6, 1));  // Sử dụng GridLayout với 6 hàng, 1 cột

        radioPanel.add(cashPayment);
        radioPanel.add(cashDiscountLabel);  // Thêm label hiển thị mã giảm giá sau mỗi JRadioButton
        radioPanel.add(cardPayment);
        radioPanel.add(cardDiscountLabel);  // Thêm label hiển thị mã giảm giá sau mỗi JRadioButton
        radioPanel.add(onlinePayment);
        radioPanel.add(onlineDiscountLabel);  // Thêm label hiển thị mã giảm giá sau mỗi JRadioButton

        // Thay thế paymentPanel bằng radioPanel
        add(radioPanel, BorderLayout.WEST);


        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 235, 205));
        setSize(1224, 600);
        this.setLocationRelativeTo(null);
        setVisible(true);


    }


    // hàm lấy dữ liệu bảng Pay sang Waterscounter
    public List<Object[]> getPaymentTableData() {
        List<Object[]> tableData = new ArrayList<>();
        DefaultTableModel tableModel = (DefaultTableModel) drinksTable.getModel();
        int rowCount = tableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            Object[] rowData = new Object[3];
            rowData[0] = tableModel.getValueAt(i, 0); // Lấy giá trị từ cột 0 (tên đồ uống)
            rowData[1] = tableModel.getValueAt(i, 1); // Lấy giá trị từ cột 1 (số lượng)
            rowData[2] = tableModel.getValueAt(i, 2); // Lấy giá trị từ cột 2 (giá trị khác)
            tableData.add(rowData);
        }
        return tableData;
    }

    public boolean checkDiscountCode(String inputCode) {

        return (inputCode.equals(resultRandom));
    }



    //hàm tạo số remote random và đồng thời trả ra những remote chưa cấp

    public  int createRemote(){

        for (int i = 1; i <=100; i++) {
            int a = (int)((Math.random()*100)+1);
            if(remote.containsKey(a)&& remote.get(a)==false)return a;
        }
      return  0;

    }


    public void addDt(){
        for (int i = 1; i <=100; i++) {

            remote.put(i,false);

        }
    }

    public String generateRandomCode() {
        String rs = "";
        for (int i = 1; i <= 2; i++) {
            char a = (char) (int) ((Math.random() * 25) + 66);
            char b = (char) (int) ((Math.random() * 25) + 98);
            char c = (char) (int) ((Math.random() * 9) + 48);
            rs += a + "" + b + "" + c;

        }
        return resultRandom = rs;
    }
    public JButton getAdditionalButton() {
        return this.createReamote;
    }

    /////////////

    public JLabel getTotalLabel() {
        return this.totalLabel;
    }

    public JLabel getCashDiscountLabel() {
        return cashDiscountLabel;
    }

    public JLabel getCardDiscountLabel() {
        return cardDiscountLabel;
    }

    public JLabel getOnlineDiscountLabel() {
        return onlineDiscountLabel;
    }

    public String getResultRandom() {
        return resultRandom;
    }

    public JTextField getDiscountCodeField() {
        return discountCodeField;
    }

    public JButton getCheckCodeButton() {
        return checkCodeButton;
    }

    public JLabel getDiscountLabel() {
        return discountLabel;
    }

    public JRadioButton getCashPayment() {
        return this.cashPayment;
    }

    public JRadioButton getCardPayment() {
        return this.cardPayment;
    }

    public JRadioButton getOnlinePayment() {
        return this.onlinePayment;
    }

    public JButton getPayButton() {
        return this.payButton;
    }

    public JButton getBackButton() {
        return this.backButton;
    }

    public JTable getDrinksTable() {
        return this.drinksTable;
    }

    public static void main(String[] args) {

    }
}
