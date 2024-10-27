
package java2project;

import java.awt.Color;
import java.awt.Font;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import static java2project.Login_page.customerlog;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author omar
 */


public class View_book_page extends JFrame {

    
    
    
    
    void buildscreen() {

        JPanel pane = new JPanel();
        pane.setLayout(null);
        

        JLabel label1 = new JLabel("User Name");
        JLabel label2 = new JLabel("Checkin ");
        JLabel label3 = new JLabel("Checkout ");
        JLabel label4 = new JLabel("Rooms: ");
        JLabel label5 = new JLabel("Suite");
        JLabel label6 = new JLabel("Regular");
        JLabel label7 = new JLabel("Economy");
        
        JTextField TextField1 = new JTextField(10);
        JTextField TextField2 = new JTextField(10);
        JTextField TextField3 = new JTextField(10);
        JTextField TextField4 = new JTextField(10);
        JTextField TextField5 = new JTextField(10);
        JTextField TextField6 = new JTextField(10);
        JTextField TextField7 = new JTextField(10);
        
        TextField1.setEditable(false);
        TextField2.setEditable(false);
        TextField3.setEditable(false);
        TextField4.setEditable(false);
        TextField5.setEditable(false);
        TextField6.setEditable(false);
        TextField7.setEditable(false);
        
        
        setVisible(true);
       // this.setSize(1800, 1450);
       
        JLabel background = new JLabel(new ImageIcon("hotel.jpg"));
        add(background);

        label1.setBounds(390,50,300,50);
        label1.setFont(new Font("Castellar",Font.BOLD, 30));
        label1.setForeground(Color.WHITE);
        
        label2.setBounds(390,170,300,50);
        label2.setFont(new Font("Castellar",Font.BOLD, 30));
        label2.setForeground(Color.WHITE);
        
        label3.setBounds(390,290,300,50);
        label3.setFont(new Font("Castellar",Font.BOLD, 30));
        label3.setForeground(Color.WHITE);
        
        label4.setBounds(390,410,300,50);
        label4.setFont(new Font("Castellar",Font.BOLD, 30));
        label4.setForeground(Color.WHITE);
        
        label5.setBounds(540,410,300,50);
        label5.setFont(new Font("Castellar",Font.BOLD, 25));
        label5.setForeground(Color.WHITE);
        
        label6.setBounds(540,500,300,50);
        label6.setFont(new Font("Castellar",Font.BOLD, 25));
        label6.setForeground(Color.WHITE);
        
        label7.setBounds(540,590,300,50);
        label7.setFont(new Font("Castellar",Font.BOLD, 25));
        label7.setForeground(Color.WHITE);
        
        TextField1.setBounds(700,50,400,50);
        TextField2.setBounds(700,170,400,50);
        TextField3.setBounds(700,290,400,50);
        TextField4.setBounds(700,410,400,50);
        TextField5.setBounds(700,500,400,50);
        TextField6.setBounds(700,590,400,50);
        TextField7.setBounds(1200,10,100,20);
        
        background.add(label1);
        background.add(label2);
        background.add(label3);
        background.add(label4);
        background.add(label5);
        background.add(label6);
        background.add(label7);
        
        background.add(TextField1);
        background.add(TextField2);
        background.add(TextField3);
        background.add(TextField4);
        background.add(TextField5);
        background.add(TextField6);
        background.add(TextField7);
        
         person customer1;
        try 
              {
              FileInputStream filestream1 = new FileInputStream("newPerson.dat");
              ObjectInputStream objectstream1 = new ObjectInputStream(filestream1);
              
              while((customer1 = (person)objectstream1.readObject()) != null) 
              {
                if(customer1.getname().equals(customerlog.getname()) )
                {
                    if(customer1.getyearin()==null){
                        dispose();
                        JOptionPane.showMessageDialog(null,"No Bookings Made");
                        
                    }
                    else
                    {
                    TextField1.setText(customerlog.getname());
                    TextField2.setText(customerlog.getdatein()+" / "+customerlog.getmonthin()+" / "+customerlog.getyearin());
                    TextField3.setText(customerlog.getdateout()+" / "+customerlog.getmonthout()+" / "+customerlog.getyearout());
                    TextField4.setText(customerlog.getsuite());
                    TextField5.setText(customerlog.getregular());
                    TextField6.setText(customerlog.geteconomy());
                    if(customer1.getcity()==1)
                        TextField7.setText("Dammam");
                    if(customer1.getcity()==3)
                        TextField7.setText("Meddina");
                    if(customer1.getcity()==2)
                        TextField7.setText("Riyadh");
                    } 
                }
              }
               objectstream1.close();
               filestream1.close();
              }
            
              catch(EOFException e) {}
              catch(ClassNotFoundException ex2){}
              catch(IOException e) {}
              catch(NullPointerException np){System.out.println(np.getMessage());
              np.printStackTrace();}
        pack();
    }

    }
    


