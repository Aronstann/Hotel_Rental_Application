
package java2project;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


 
/**
 *
 * @author dedo
 */
public class post_Login extends JFrame {

    JPanel panel1;
    Container containers;

    post_Login() {
        containers = getContentPane();
        containers.setLayout(new FlowLayout());
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 3, 5, 10));
        setSize(400, 400);
        setVisible(true);
        setResizable(true);

        JTextField tf1 = new JTextField(10);
        tf1.setEditable(false);
        tf1.setText(Login_page.customerlog.getname()); // Set the username


        JButton btn1 = new JButton("New Booking");
        JButton btn2 = new JButton("View Booking");
        JButton btn3 = new JButton("Cancel Booking");
        JLabel label1 = new JLabel("   Username");
        

        JLabel label2 = new JLabel("");

        setTitle("logged in");

        panel1.add(label1);
        panel1.add(tf1);
        panel1.add(label2);
        panel1.add(btn1);
        panel1.add(btn2);
        panel1.add(btn3);
        containers.add(panel1);

        
        
                btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i=-1;
                if(Login_page.customerlog.getdatein()!=null)
                {
                     i = JOptionPane.showConfirmDialog(null,"You have already made a booking ! Making a new booking will cancel the old one ! Do you wish to proceed ?");
                     if(i==0)
                    {Make_Book_Page mb = new Make_Book_Page();
                    mb.buildscreen();
                    }
                }
                else
                {
                   Make_Book_Page makebook = new Make_Book_Page();
                    makebook.buildscreen(); 
                }
            }
        });
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                View_book_page view = new View_book_page();
                view.buildscreen();
            }
        });

        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Login_page.customerlog.getyearin() == null) {
                        
                        JOptionPane.showMessageDialog(null, "No Bookings Made !");

                    }
                else
                {int i = JOptionPane.showConfirmDialog(null, "Are you sure?");
                if (i == 0) {
                      
                     
                        

                        ArrayList<person> personsarray = new ArrayList();int ts=0;
                        try {
                            FileInputStream fileinputstream = new FileInputStream("newPerson.dat");
                            ObjectInputStream fileoutputstream = new ObjectInputStream(fileinputstream);
                            
                            person customer;
                            while ((customer = (person) fileoutputstream.readObject()) != null) {
                                if (customer.getname().equals(Login_page.customerlog.getname())) {
                                    ts=customer.getamount();
                                    customer.setrooms("0", "0", "0");
                                    customer.setdates(null, null, null, null, null, null);
                                    Login_page.customerlog.setdates(null, null, null, null, null, null);
                                    Login_page.customerlog.setrooms(null, null, null);
                                    
                                }
                                personsarray.add(customer);
                            }
                            fileoutputstream.close();
                            fileinputstream.close();
                        } catch (EOFException e1) {
                        } catch (ClassNotFoundException ex2) {
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null, "Booking Cancelled ! "+ts+"SR will be refunded to your account .");
                        try {
                            FileOutputStream fileoutputstream;
                            ObjectOutputStream objectoutputstream;
                            fileoutputstream = new FileOutputStream("newPerson.dat");
                            objectoutputstream = new ObjectOutputStream(fileoutputstream);

                            person customer;
                            Iterator i2 = personsarray.iterator();
                            while (i2.hasNext()) {
                                customer = (person) i2.next();
                                objectoutputstream.writeObject(customer);

                            }

                            fileoutputstream.close();
                            objectoutputstream.close();

                        } catch (IOException e3) {
                        }
                    }
                }
            }
        });
        
        
        
        
    }
   /* public static void main(String[] args) {
     

        new post_Login();

                
    }*/
}