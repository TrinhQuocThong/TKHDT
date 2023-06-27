package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.HomeController;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

//	mau nền: new Color(255, 235, 205)
//`	mau cac btn: new Color(255, 204, 153)
public class Home extends JFrame {

    private JPanel pnHome;
    private JPanel pnLoginMain, pnLogin1;
    private JPanel pnHomeMain;
    private JButton btnOrder;
    private JButton btnManagement;
    private JPanel pnLogin;
    private JPanel pnLoginItem;
    private JLabel lblID;
    private JTextField txtID;
    private JLabel lblPassword;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JPanel pnTitle;
    private JLabel lblTitle;
    private JButton btnBack;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home frame = new Home();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Home() {
        setTitle("Home");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1224, 600);
        setLocationRelativeTo(null);
        pnHome = new JPanel();
        pnHome.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(pnHome);
        pnHome.setLayout(new CardLayout(0, 0));









//		************************************************
//		xu ly su kien
        ActionListener lis= new HomeController(this);
        MouseListener mouseLis= new HomeController(this);

        pnHomeMain = new JPanel();
        pnHomeMain.setMinimumSize(new Dimension(400, 400));
        pnHomeMain.setMaximumSize(new Dimension(400, 400));
        pnHomeMain.setPreferredSize(new Dimension(400, 400));
        pnHome.add(pnHomeMain, "homeMain");
        pnHomeMain.setLayout(new BoxLayout(pnHomeMain, BoxLayout.X_AXIS));

        pnHomeMain.add(Box.createHorizontalGlue());

        btnOrder = new JButton("ORDER");
        btnOrder.addMouseListener(mouseLis);
        btnOrder.addActionListener(lis);
        btnOrder.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pnHomeMain.add(btnOrder);

        pnHomeMain.add(Box.createHorizontalStrut(20));

        btnManagement = new JButton("MANAGEMENT");
        btnManagement.addMouseListener(mouseLis);
        btnManagement.addActionListener(lis);
        btnManagement.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pnHomeMain.add(btnManagement);

        pnHomeMain.add(Box.createHorizontalGlue());

        pnLoginMain = new JPanel();
        pnHome.add(pnLoginMain, "loginMain");
        pnLoginMain.setLayout(new BoxLayout(pnLoginMain, BoxLayout.Y_AXIS));

        pnLoginMain.add(Box.createVerticalGlue());

        pnLogin1= new JPanel();
        pnLogin1.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
        pnLogin1.setMinimumSize(new Dimension(400, 400));
        pnLogin1.setMaximumSize(new Dimension(400, 400));
        pnLogin1.setPreferredSize(new Dimension(400, 400));
        pnLogin1.setLayout(new BorderLayout(0, 0));
        pnLoginMain.add(pnLogin1);

        pnLoginMain.add(Box.createVerticalGlue());

        pnTitle = new JPanel();
        pnTitle.setMinimumSize(new Dimension(400, 36));
        pnTitle.setMaximumSize(new Dimension(400, 36));
        pnTitle.setPreferredSize(new Dimension(400, 36));
        pnLogin1.add(pnTitle,BorderLayout.NORTH);
        pnTitle.setLayout(new BorderLayout(0, 0));

        lblTitle = new JLabel("Management - Login");
        lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 17));
        pnTitle.add(lblTitle, BorderLayout.WEST);

        btnBack = new JButton("Back");
        btnBack.addMouseListener(mouseLis);
        btnBack.addActionListener(lis);
        btnBack.setMinimumSize(new Dimension(70, 40));
        btnBack.setMaximumSize(new Dimension(70, 40));
        btnBack.setPreferredSize(new Dimension(70, 40));
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnTitle.add(btnBack, BorderLayout.EAST);

        pnLogin = new JPanel();
        pnLogin.setMinimumSize(new Dimension(400, 400));
        pnLogin.setMaximumSize(new Dimension(400, 400));
        pnLogin.setPreferredSize(new Dimension(400, 400));
        pnLogin1.add(pnLogin, BorderLayout.CENTER);
        pnLogin.setLayout(new BoxLayout(pnLogin, BoxLayout.Y_AXIS));

        pnLogin.add(Box.createVerticalGlue());



        pnLogin.add(Box.createVerticalStrut(20));

        pnLoginItem = new JPanel();
        pnLoginItem.setMinimumSize(new Dimension(240, 70));
        pnLoginItem.setMaximumSize(new Dimension(240, 70));
        pnLoginItem.setPreferredSize(new Dimension(240, 70));
        pnLogin.add(pnLoginItem);
        pnLoginItem.setLayout(new GridLayout(2, 2, 10, 10));

        pnLogin.add(Box.createVerticalStrut(20));

        btnLogin = new JButton("Log in");
        btnLogin.addMouseListener(mouseLis);
        btnLogin.addActionListener(lis);
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pnLogin.add(btnLogin);

        pnLogin.add(Box.createVerticalGlue());


        lblID = new JLabel("ID");
        lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnLoginItem.add(lblID);

        txtID = new JTextField();
        txtID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnLoginItem.add(txtID);
        txtID.setColumns(20);

        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnLoginItem.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setColumns(20);
        txtPassword.setEchoChar('*');
        txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnLoginItem.add(txtPassword);

//		set background
        setPanelBackground(pnHome, new Color(255, 235, 205));

//		to mau cac nut
        btnOrder.setBackground(new Color(255, 204, 153));
        btnManagement.setBackground(new Color(255, 204, 153));
        btnBack.setBackground(new Color(255, 204, 153));
        btnLogin.setBackground(new Color(255, 204, 153));


    }

//	btnOK.addMouseListener(new MouseAdapter() {
//		@Override
//		public void mouseEntered(MouseEvent e) {
//			btnOK.setBackground(new Color(255,153,51));
//		}
//
//
//		@Override
//		public void mouseExited(MouseEvent e) {
//			btnOK.setBackground(new Color(255, 204, 153));
//		}
//	});

    //	cac ham trang tri
//	ham dat mau nen
    public static void setPanelBackground(JPanel panel, Color color) {
        panel.setBackground(color);
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                setPanelBackground((JPanel)component, color);
            }
        }
    }





    public void openOrder() {
        Order order= new Order();
        Pointer.setCurrentOrder(order);//lấy địa chỉ đối tượng hiện tại bằng hàm set (static)(vì mỗi order là mỗi bảng khascc nhau
        order.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        order.setSize(1224, 600);
        order.setLocationRelativeTo(null);
        order.setVisible(true);
//		hàm đóng jframe hiện tại, là home
//		dispose();
    }

    public void openManagement() {
        pnLoginMain.setVisible(true);
        pnHomeMain.setVisible(false);
        pnLoginMain.setBackground(new Color(169, 169, 169));
    }

    public void backToHome() {
        pnLoginMain.setVisible(false);
        pnHomeMain.setVisible(true);
        pnLoginMain.setBackground(new Color(255, 235, 205));
    }

    public JButton getBtnOrder() {
        return btnOrder;
    }
    public JButton getBtnManagement() {
        return btnManagement;
    }
    public JButton getBtnBack() {
        return btnBack;
    }
    public JButton getBtnLogin() {
        return btnLogin;
    }

    public void hoverIn(JButton btn) {
        btn.setBackground(new Color(255,153,51));
    }

    public void hoverOut(JButton btn) {
        btn.setBackground(new Color(255, 204, 153));
    }

    public String getID() {
        return txtID.getText();
    }

//	private int[] encryptPwd() {
//		char[] pwd=txtPassword.getPassword();
//		int[] num= new int[pwd.length];
//		for(int i=0; i< pwd.length; i++) {
//			num[i] = (int)pwd[i]+1;
//		}
//		return num;
//	}

//	public ArrayList<String> getPassword() {
//		int num[]= new int[encryptPwd().length];
//		num = encryptPwd();
//		String result = new String(pwd);
//		return result;
//	}

    public String getPassword() {
        char[] pwd= txtPassword.getPassword();
        String result= new String(pwd);
        return result;
    }
}


