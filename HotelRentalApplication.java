
package java2project;


import java.awt.Color;
import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class HotelRentalApplication {

 
    public static void main(String[] args) {
        

        screen s = new screen();
        s.buildscreen();

    }

}

class screen extends JFrame {
    
    JButton signbtn = new JButton("Sign Up");
    JButton logbtn = new JButton("Log in");

    JLabel city1 = new JLabel("Riyadh");
    JLabel city2 = new JLabel("Meddina");
    JLabel city3 = new JLabel("Dammam");
    

    void buildscreen() {

        JPanel pane = new JPanel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pane.setLayout(null);
        
        JLabel p1 = new JLabel(new ImageIcon("riyadh.jpg"));
        JLabel p2 = new JLabel(new ImageIcon("meddina.jpg"));
        JLabel p3 = new JLabel(new ImageIcon("damam.jpg"));


        JLabel backscreen = new JLabel(new ImageIcon("hotel.jpg"));
        add(backscreen);
        city1.setBounds(100, 525, 220, 30);
        
        p1.setBounds(20, 200, 400, 300);
        backscreen.add(p1);



        logbtn.setBounds(1100, 10, 100, 20);
        backscreen.add(logbtn);
        signbtn.setBounds(1200, 10, 100, 20);
        backscreen.add(signbtn);

        backscreen.add(city1);

        city2.setBounds(550, 525, 220, 30);
        city1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        city1.setForeground(Color.WHITE);

        backscreen.add(city2);
        city2.setFont(new Font("Times New Roman", Font.BOLD, 30));
        city2.setForeground(Color.WHITE);
        
        p2.setBounds(450, 200, 400, 300);
        backscreen.add(p2);

        city3.setBounds(980, 525, 220, 30);
        backscreen.add(city3);
        city3.setFont(new Font("Times New Roman", Font.BOLD, 30));
        city3.setForeground(Color.WHITE);
        
        p3.setBounds(900, 200, 400, 300);
        backscreen.add(p3);



        JLabel label1 =  new JLabel("Hotels Rental", JLabel.CENTER);
        label1.setBounds(420, 30, 500, 100);
        label1.setOpaque(false);
        backscreen.add(label1);
        label1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        label1.setForeground(Color.WHITE);

        
                logbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login_page lp = new Login_page();
            }
        });

        signbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Sign_up_page lp = new Sign_up_page();
            }
        });

pack();
        this.setVisible(true);
    }

}
