
package java2project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class post_city_2 extends JFrame {

    
    
    
    
        /*    public static void main(String[] args) {
       

        post_city_2 s = new post_city_2();
        s.bangpage();

    }*/
            
            
    private JButton home, viewroom, review, services, contactus, login, signup, viewcal, makeBook;

    
    
    
    
    public void Riyadh() {
        home = new JButton("Home");
        viewroom = new JButton("View Rooms");
        makeBook = new JButton("Make Booking");
        services = new JButton("Services");
        contactus = new JButton("Contact Us");
        
        setTitle("Hotel");
        setSize(1600, 1000);
        setVisible(true);
        setLayout(new BorderLayout());
        
        JLabel backscreen = new JLabel(new ImageIcon("hotel.jpg"));
        add(backscreen);
        

        
        
        home.setBounds(10, 170, 250, 30);
        backscreen.add(home);
        
        
            home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        
        
        viewroom.setBounds(10, 270, 250, 30);
        backscreen.add(viewroom);
        
                viewroom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                city_3_room room = new city_3_room();
                room.setupscreen5();
            }
        });

        
        
        this.setSize(1000, 450);
        this.setVisible(true);

        services.setBounds(10, 370, 250, 30);
        backscreen.add(services);
        
        
                services.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Service_Page ser = new Service_Page();
                ser.buildscreen4();
            }
        });

        contactus.setBounds(10, 470, 250, 30);
        backscreen.add(contactus);
        
                contactus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contact_us_page cont = new contact_us_page();
                cont.contact();
            }
        });

        makeBook.setBounds(10, 570, 250, 30);
        backscreen.add(makeBook);
        
        
                makeBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(Login_page.customerlog.getdatein()!=null)
                {int i;
                     i = JOptionPane.showConfirmDialog(null,"You have already made a booking ! Making a new booking will cancel the old one ! Do you wish to proceed ?");
                     if(i==0)
                    {booking_page page = new booking_page();
                    try {
                        page.book();
                    } catch (AssertionError ex) {
                        Logger.getLogger(post_city_1.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ParseException ex) {
                        Logger.getLogger(post_city_1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                }
                else
                {
                booking_page page = new booking_page();
                try {
                    page.book();
                } catch (AssertionError ex) {
                    Logger.getLogger(post_city_2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(post_city_2.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }
            
        });

        pack();
       // this.setSize(1800, 1450);
        this.setVisible(true);

    }
}
