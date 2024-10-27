
package java2project;

/**
 *
 * @author dedo
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java2project.post_city_1;
import java2project.post_city_2;
import java2project.post_city_3;


import javax.swing.*;
import javax.swing.JFrame;


public class Make_Book_Page extends JFrame {

    JButton btn1 = new JButton("Dammam");
    JButton btn2 = new JButton("Riyadh");
    JButton btn3 = new JButton("Meddina");
        private ButtonHandler listener = new ButtonHandler();
        JLabel p1 = new JLabel(new ImageIcon("damam.jpg"));
        JLabel p2 = new JLabel(new ImageIcon("riyadh.jpg"));
        JLabel p3 = new JLabel(new ImageIcon("meddina.jpg"));

    void buildscreen() {

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        JLabel BackScreen = new JLabel(new ImageIcon("hotel.jpg"));
        add(BackScreen);
        
        btn1.addActionListener((ActionListener) listener);
        btn1.setBounds(100, 525, 220, 30);
        BackScreen.add(btn1);
        
                p1.setBounds(20, 200, 400, 300);
        BackScreen.add(p1);
        
        btn2.addActionListener((ActionListener) listener);
        btn2.setBounds(550, 525, 220, 30);
        BackScreen.add(btn2);
        
        
        p2.setBounds(450, 200, 400, 300);
        BackScreen.add(p2);
        
        btn3.addActionListener((ActionListener) listener); 
        btn3.setBounds(980, 525, 220, 30);
        BackScreen.add(btn3);
        
        p3.setBounds(900, 200, 400, 300);
        BackScreen.add(p3);
        
        JLabel label1 = new JLabel("Select city ", JLabel.CENTER);
        label1.setOpaque(false);
        label1.setBounds(460, 610, 400, 50);
        BackScreen.add(label1);
        label1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        label1.setForeground(Color.WHITE);

        JLabel label2 = new JLabel("Hotels Rental", JLabel.CENTER);
        label2.setBounds(420, 30, 500, 100);
        label2.setOpaque(false);
        BackScreen.add(label2);
        label2.setFont(new Font("Times New Roman", Font.BOLD, 30));
        label2.setForeground(Color.WHITE);
        
        
        //this.setSize(1800, 1450);
        pack();
        this.setVisible(true);
    }

    
        private class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            {
                if (e.getSource() == btn1) {
                    Login_page.customerlog.city = 1;
                    post_city_1 p = new post_city_1();
                    p.Dammam();

                } else if (e.getSource() == btn2) {
                    Login_page.customerlog.city = 2;
                    post_city_3 p2 = new post_city_3();
                    p2.Meddina();
                } else if (e.getSource() == btn3) {
                    Login_page.customerlog.city = 3;
                    post_city_2 p3 = new post_city_2();
                    p3.Riyadh();
                }
            }
        }
    }

   /*public static void main(String[] args) {
        

        Make_Book_Page mb = new Make_Book_Page();
        mb.buildscreen();
    }*/
}
