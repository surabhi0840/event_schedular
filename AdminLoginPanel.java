package javadb;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


class ALogin_Panel extends JFrame implements ActionListener
{
    Container c;
    
    JLabel userlabel=new JLabel("User name :");
    JLabel passlabel=new JLabel("Password :");
    
    JTextField fill_usrnme=new JTextField();
    JPasswordField fill_pswrd=new JPasswordField();
    
    JButton lbtn=new JButton("Login");
    
    ALogin_Panel()
    {
        c=this.getContentPane();
        c.setLayout(null);
        
    
        userlabel.setBounds(100,50,150,40);
        passlabel.setBounds(100,150,150,40);
        
        Font f=new Font("Arial",Font.BOLD,20);
        userlabel.setFont(f);
        passlabel.setFont(f);
        
        fill_usrnme.setBounds(250,50,150,40);
        fill_pswrd.setBounds(250,150,150,40);
        fill_usrnme.setFont(f);
        fill_pswrd.setFont(f);
        lbtn.setBounds(300,200,100,50);
        lbtn.setFont(f);
        lbtn.addActionListener(this);
        lbtn.setBackground(Color.RED);
        
        c.add(userlabel);
        c.add(passlabel);
        c.add(fill_usrnme);
        c.add(fill_pswrd);
        
        c.add(lbtn);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==lbtn)
        {
            String username=fill_usrnme.getText();
            String password=fill_pswrd.getText();
            if(username.equals("varunav")&&password.equals("4101"))
            {
                try {
                    AdminD ad=new AdminD();
                } catch (SQLException ex) {
                    Logger.getLogger(ALogin_Panel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
            c.setBackground(Color.RED);
            wrn.setBounds(100,450,200,40);
            c.add(wrn);
            }
        }
        
    }
    JLabel wlcm=new JLabel("Welcome dear");
    JLabel wrn=new JLabel("Wrong username or password");
}

public class AdminLoginPanel
{
    AdminLoginPanel()
    {
        ALogin_Panel frame=new ALogin_Panel();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(100,100,1000,500);
        frame.setTitle("Admin");
        
    }
}


