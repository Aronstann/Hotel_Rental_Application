/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


/**
 *
 * @author omar
 */
public class post_city_1 extends JFrame {
    
    
       /*       public static void main(String[] args) {
        // TODO code application logic here

        post_city_1 s = new post_city_1();
        s.mumpage();
       

    }*/

    private JButton home, viewRoom, review, services, contactus, login, signup, viewcal, makeBook;

    public void Dammam() {
        
        home = new JButton("Home");
        viewRoom = new JButton("View Rooms");
        makeBook = new JButton("Make Booking");
        services = new JButton("Services");
        contactus = new JButton("Contact Us");
        
        setTitle("Hotel Rental");
        this.setSize(1800, 1450);
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
        
        
        viewRoom.setBounds(10, 270, 250, 30);
        backscreen.add(viewRoom);
        
                viewRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                city_1_room room = new city_1_room();
                room.setupscreen3();
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

        
        contactus.setBounds(10, 570, 250, 30);
        backscreen.add(contactus);
        
                contactus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contact_us_page cont = new contact_us_page();
                cont.contact();
            }
        });
        makeBook.setBounds(10, 470, 250, 30);
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
                else{
                booking_page page = new booking_page();
                try {
                    page.book();
                } catch (AssertionError ex) {
                    Logger.getLogger(post_city_1.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(post_city_1.class.getName()).log(Level.SEVERE, null, ex);
                }
               }
            }
        });

        pack();
      //  this.setSize(1800, 1450);
        this.setVisible(true);
    }
}
