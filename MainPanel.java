
package javadb;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
class Main_Panel extends JFrame implements ActionListener
{
    JButton btn1=new JButton("Admin");
    JButton btn2=new JButton("Teacher");
    JButton btn3=new JButton("Student");
    Container c;
    Main_Panel ()
    {
        c=this.getContentPane();
        c.setLayout(null);
        btn1.setBounds(450,100,100,40);
        btn2.setBounds(450,150,100,40);
        btn3.setBounds(450,200,100,40);
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        
        c.add(btn1);
        c.add(btn2);
        c.add(btn3);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btn1)
        {
            AdminLoginPanel alp=new AdminLoginPanel();
        }
        else if(e.getSource()==btn2)
        {
            TeacherLoginPanel tlp=new TeacherLoginPanel();
        }
        else if(e.getSource()==btn3)
        {
            StudentLoginPanel slp=new StudentLoginPanel();
        }       
    }
}


public class MainPanel extends JFrame
{
    MainPanel()
    {
            Main_Panel frame=new Main_Panel();
            frame.setVisible(true);
            frame.setBounds(100,100,1000,500);
            frame.setTitle("Chandigarh University"); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

