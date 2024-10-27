
package java2project;

/**
 *
 * @author omar
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author dedo
 */
public class contact_us_page extends JFrame {
    
      /*    public static void main(String[] args) {
       

        contact_us_page s = new contact_us_page();
        s.contact();
       

    }*/

    public void contact() {
      //  setSize(1600, 1000);
      
        setVisible(true);
        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("hotel.jpg"));
        add(background);
        
        
        JLabel label1 = new JLabel("Contact US ", JLabel.CENTER);
        label1.setOpaque(false);
        label1.setBounds(500, 10, 400, 50);
        background.add(label1);
        label1.setFont(new Font("Times New Roman", Font.BOLD, 30));
        label1.setForeground(Color.WHITE);

        JLabel label2 = new JLabel("ADDRESS", JLabel.CENTER);
        label2.setOpaque(true);
        label2.setBounds(20, 150, 300, 130);
        label2.setFont(new Font("Castellar", Font.PLAIN, 22));
        background.add(label2);

        JLabel label3 = new JLabel("EMAIL", JLabel.CENTER);
        label3.setOpaque(true);
        label3.setBounds(20, 300, 300, 130);
        label3.setFont(new Font("Castellar", Font.PLAIN, 22));
        background.add(label3);

        JLabel label4 = new JLabel("TELEPHONE", JLabel.CENTER);
        label4.setOpaque(true);
        label4.setBounds(20, 450, 300, 130);
        label4.setFont(new Font("Castellar", Font.PLAIN, 22));
        background.add(label4);

        JTextArea TextArea = new JTextArea("Hotel Rental company\nAl shati st\nJeddah");
        TextArea.setOpaque(true);
        TextArea.setBounds(575, 150, 800, 130);
        TextArea.setEditable(false);
        TextArea.setFont(new Font("Aparajita", Font.PLAIN, 20));
        background.add(TextArea);
        
        JTextArea TextArea2=  new JTextArea("HotelRental@hotmail.com");
        TextArea2.setOpaque(true);
        TextArea2.setBounds(575, 300, 800, 130);
        TextArea2.setEditable(false);
        TextArea2.setFont(new Font("Aparajita", Font.PLAIN, 20));
        background.add(TextArea2);
        
        JTextArea TextArea3 = new JTextArea("+0556733284");
        TextArea3.setOpaque(true);
        TextArea3.setBounds(575, 450, 800, 130);
        TextArea3.setEditable(false);
        TextArea3.setFont(new Font("Aparajita", Font.PLAIN, 20));
        background.add(TextArea3);
        pack();

    }
}
