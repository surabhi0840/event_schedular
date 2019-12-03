package javadb;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
class TLogin_Panel extends JFrame implements ActionListener
{
    
    private Connection con;
    private Statement stmt;
    private ResultSet rs;    
    
    Container c;
    
    JLabel userlabel=new JLabel("User name :");
    JLabel passlabel=new JLabel("Password :");
    
    JTextField fill_usrnme=new JTextField();
    JPasswordField fill_pswrd=new JPasswordField();
    
    JButton lbtn=new JButton("Login");
    
    
    void dbconn()
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
    
    TLogin_Panel()
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
            JLabel wlcm=new JLabel("Welcome dear");
            JLabel wrn=new JLabel("Wrong username or password");
            try
            {
            stmt=con.createStatement();
                if(e.getSource()==lbtn)
                {
                    String username=fill_usrnme.getText();
                    String password=fill_pswrd.getText();
                    rs=stmt.executeQuery("SELECT * FROM teacher");                       
                        while(rs.next())
                        {
                            if(username.equals(rs.getString("TID"))&&password.equals(rs.getString("DOB")))
                            {
                                TeacherD td=new TeacherD(rs);
                            }
                        }
                        
                    }
                else
                    {
                        c.setBackground(Color.RED);
                        wrn.setBounds(100,450,200,40);
                        c.add(wrn);
                    }
                con.close();
            }
                    catch(Exception ex)
                    {
                        System.out.println(ex); 
                    }
                    
             
    }
    JLabel wlcm=new JLabel("Welcome dear");
    JLabel wrn=new JLabel("Wrong username or password");

}
public class TeacherLoginPanel
{
    TeacherLoginPanel()
    {
        TLogin_Panel frame=new TLogin_Panel();
        frame.dbconn();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(100,100,1000,500);
        frame.setTitle("Teacher");
        
    }
}
