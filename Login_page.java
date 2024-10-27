
package java2project;

/**
 *
 * @author omar
 */
    

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



/**
 *
 * @author dedo
 */

public class Login_page extends JFrame{
    
     JPanel panel1;
     Container containers;
    public person customer1;
    static person customerlog;
    private JLabel Name,Password;
    private JTextField nam;
    private JPasswordField pas;
    private JButton login,rm;
    
    
    
    Login_page()
    {
        
        setTitle("Log in");
        containers=getContentPane();
        containers.setLayout(new BoxLayout(containers,3));
        
        panel1=new JPanel();
        panel1.setLayout(new GridLayout(6,2,10,10));
        setSize(900,900);
        setVisible(true);
        
        
        Name=new JLabel("Name");
        
        
        nam=new JTextField(40);
        
        
        Password=new JLabel("Password");
        
        
        pas=new JPasswordField(8);
        pas.setEchoChar('*');
        

        login=new JButton("Log in");
        rm=new JButton("Clear all");
        JLabel label1=new JLabel("");
        JLabel label2=new JLabel("");
        
        panel1.add(label1);
        panel1.add(label2);
        panel1.add(Name);panel1.add(nam);
        panel1.add(Password);panel1.add(pas);
        
        panel1.add(login);panel1.add(rm);
       
        containers.add(panel1);
        
                 rm.addActionListener(new ActionListener()
            {public void actionPerformed(ActionEvent ex)
            {nam.setText("");
            pas.setText("");
            }});
        login.addActionListener(new ActionListener() 
        {
            //Code for saving log in details to file
            public void actionPerformed(ActionEvent ex)
            {
            int flag1=0;
            
             try 
              {
              FileInputStream filestream1 = new FileInputStream("newPerson.dat");
              ObjectInputStream objectstream1 = new ObjectInputStream(filestream1);
              
              while((customer1 = (person)objectstream1.readObject()) != null) 
              {
                
                if(customer1.getname().equals(nam.getText()) && customer1.getpassword().equals(new String(pas.getPassword())))
                 {flag1=1;
                 customerlog=customer1;
                  break;
                 }
              }
               objectstream1.close();
               filestream1.close();
              }
            
              catch(EOFException e) {}
              catch(ClassNotFoundException ex2){}
              catch(IOException e) {}
              catch(NullPointerException np){
              }
             
             if(flag1==1)
              {dispose();
                  JOptionPane.showMessageDialog(null, nam.getText()+
                      ", you have succesfully logged in ","Message", 
                JOptionPane.INFORMATION_MESSAGE);
               
               post_Login al=new post_Login();
              }
             else
             {
                 JOptionPane.showMessageDialog(null, nam.getText()+
                         ", Invalid name/password ","Message", 
                 JOptionPane.INFORMATION_MESSAGE);
             }
            }
        });  

}

}