package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Management extends JFrame {

    private JPanel pnManagement;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Management frame = new Management();
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
    public Management() {
        setTitle("Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 600);
        pnManagement = new JPanel();
        pnManagement.setBorder(new EmptyBorder(5, 5, 5, 5));
        pnManagement.setLayout(new BorderLayout(0, 0));
        setContentPane(pnManagement);


    }

}