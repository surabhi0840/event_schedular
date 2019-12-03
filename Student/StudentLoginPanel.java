package javadb;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
class SLogin_Panel extends JFrame implements ActionListener
{
    //db objects
     public Connection con;
     public Statement stmt;
     public ResultSet rs;
    public String username;
    public String password;
    
     void conn()
    {
        try
        {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/s?autoReconect=true&useSSL=false","root","varu1234");
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("ASas");
        }
    }
    
    
    Container c;
    
    JLabel userlabel=new JLabel("User name :");
    JLabel passlabel=new JLabel("Password :");
    
    JTextField fill_usrnme=new JTextField();
    JPasswordField fill_pswrd=new JPasswordField();
    JButton lbtn=new JButton("Login");
    JLabel wlcm=new JLabel("Welcome dear");
    JLabel wrn=new JLabel("Wrong username or password");
    
       
    SLogin_Panel() // Student Login
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
        //database query
            
            try
            {
            stmt=con.createStatement();
                if(e.getSource()==lbtn)
                {
                    username=fill_usrnme.getText();
                    password=fill_pswrd.getText();
                    rs=stmt.executeQuery("SELECT * FROM student");                       
                        while(rs.next())
                        {
                            if(username.equals(rs.getString("SID"))&&password.equals(rs.getString("DOB")))
                            {
                                StudentD sd=new StudentD(rs); 
                            }
                        }
                        con.close();
                    }
                else
                    {
                        c.setBackground(Color.RED);
                        wrn.setBounds(100,450,200,40);
                        c.add(wrn);
                    }
            }
                    catch(Exception ex)
                    {
                        System.out.println(ex); 
                    }
    }
}
    
public class StudentLoginPanel
{
    StudentLoginPanel()
    {
        SLogin_Panel frame=new SLogin_Panel();
        frame.conn();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(100,100,1000,500);
        frame.setTitle("Student");
    }
}