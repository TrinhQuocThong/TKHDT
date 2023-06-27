package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Home;

public class HomeController implements ActionListener, MouseListener{
    private Home homeView;


    public HomeController(Home homeView) {
        super();
        this.homeView = homeView;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String src= e.getActionCommand();
        if(src.equals("ORDER"))
            this.homeView.openOrder();
        if(src.equals("MANAGEMENT"))
            this.homeView.openManagement();
        if(src.equals("Back"))
            this.homeView.backToHome();
//		dang test log in va da thanh cong, hay chinh sua lai mot vai cho de tiep tuc
        if(src.equals("Log in"))
            if(this.homeView.getPassword().equals("123456"))
                this.homeView.backToHome();

            else
                this.homeView.openOrder();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }


    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == homeView.getBtnOrder())
            homeView.hoverIn(homeView.getBtnOrder());
//			homeView.getBtnOrder().setBackground(new Color(255,153,51));
        if(e.getSource() == homeView.getBtnManagement())
            homeView.hoverIn(homeView.getBtnManagement());
        if(e.getSource() == homeView.getBtnBack())
            homeView.hoverIn(homeView.getBtnBack());
        if(e.getSource() == homeView.getBtnLogin())
            homeView.hoverIn(homeView.getBtnLogin());
    }


    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == homeView.getBtnOrder())
            homeView.hoverOut(homeView.getBtnOrder());
//			homeView.getBtnOrder().setBackground(new Color(255, 204, 153));
        if(e.getSource() == homeView.getBtnManagement())
            homeView.hoverOut(homeView.getBtnManagement());
        if(e.getSource() == homeView.getBtnBack())
            homeView.hoverOut(homeView.getBtnBack());
        if(e.getSource() == homeView.getBtnLogin())
            homeView.hoverOut(homeView.getBtnLogin());

    }

}