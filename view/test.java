package view;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.Color;

public class test extends JFrame {

    public test() {
        setTitle("Radio Button Border Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        JRadioButton radioButton = new JRadioButton("Option 1");
        radioButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        panel.add(radioButton, BorderLayout.NORTH);

        add(panel);
        setVisible(true);
    }


    static  int a ;
    public static void main(String[] args) {

    }
}