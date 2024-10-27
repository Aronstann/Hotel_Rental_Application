
package java2project;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author omar
 */

public class Service_Page extends JFrame{
     
    void buildscreen4()
    {
      
    setVisible(true);
    //this.setSize(1800, 1450);
    JPanel panel1 = new JPanel();
    panel1.setLayout(null);
    JLabel BackScreen =new JLabel(new ImageIcon("hotel.jpg"));
    BackScreen.setBounds(00,00,400,300);
    add(BackScreen);
    

    
    
    JLabel label1= new JLabel("Security",JLabel.CENTER);
    label1.setOpaque(true);
    label1.setBounds(270,0,300,130);
    label1.setFont(new Font("Castellar",Font.PLAIN,18));
     BackScreen.add(label1);
     
    JLabel label2= new JLabel("Housekeeping",JLabel.CENTER);
    label2.setOpaque(true);
    label2.setBounds(270,150,300,130);
    label2.setFont(new Font("Castellar",Font.PLAIN,18));
     BackScreen.add(label2);
     
    JLabel label3= new JLabel("Dining Facilities",JLabel.CENTER);
    label3.setOpaque(true);
    label3.setBounds(270,300,300,130);
    label3.setFont(new Font("Castellar",Font.PLAIN,18));
     BackScreen.add(label3);
   
       
    JLabel label4= new JLabel("Wi-Fi and Internet Access",JLabel.CENTER);
    label4.setOpaque(true);
    label4.setBounds(270,450,300,130);
    label4.setFont(new Font("Castellar",Font.PLAIN,18));
     BackScreen.add(label4);
     
       
    JLabel label5= new JLabel("Fitness Center/Spa",JLabel.CENTER);
    label5.setOpaque(true);
    label5.setBounds(270,600,300,130);
    label5.setFont(new Font("Castellar",Font.PLAIN,18));
     BackScreen.add(label5);
   
    
    JTextArea tf1=new JTextArea("Ensuring the safety and security of guests is a priority. Hotels implement measures such as \n surveillance, secure access, and trained staff to address security concerns.");
    tf1.setOpaque(true);
    tf1.setBounds(575,0,800,130);
    tf1.setEditable(false);
    tf1.setFont(new Font("Aparajita",Font.PLAIN,20));
    BackScreen.add(tf1);
    
    JTextArea tf2=new JTextArea("Housekeeping services ensure that guest rooms and common areas are clean and well-maintained.\n This includes regular cleaning, bed-making, and replenishing of amenities.");
    tf2.setOpaque(true);
    tf2.setBounds(575,150,800,130);
    tf2.setEditable(false);
    tf2.setFont(new Font("Aparajita",Font.PLAIN,20));
    BackScreen.add(tf2);
    
    JTextArea tf3=new JTextArea("Many hotels have on-site restaurants, cafes, or bars, offering a variety of dining options \n to cater to different tastes. Some hotels  also provide complimentary breakfast for guests.");
    tf3.setOpaque(true);
    tf3.setBounds(575,300,800,130);
    tf3.setEditable(false);
    tf3.setFont(new Font("Aparajita",Font.PLAIN,20));
    BackScreen.add(tf3);
    
    
    JTextArea tf4=new JTextArea("Providing Wi-Fi and internet access allows guests to stay connected for both business and \n leisure purposes. This service is often essential for communication, work,\n and entertainment.");
    tf4.setOpaque(true);
    tf4.setBounds(575,450,800,130);
    tf4.setEditable(false);
    tf4.setFont(new Font("Aparajita",Font.PLAIN,20));
    BackScreen.add(tf4);
    
    
    JTextArea tf5=new JTextArea("Hotels may offer fitness centers with exercise equipment and spa services for guests \nseeking relaxation and wellness during their stay.");
    tf5.setOpaque(true);
    tf5.setBounds(575,600,800,130);
    tf5.setEditable(false);
    tf5.setFont(new Font("Aparajita",Font.PLAIN,20));
    BackScreen.add(tf5);
    pack();
    }
   /* public static void main(String[] args) {
        

        Service_Page s = new Service_Page();
        s.buildscreen4();
    }*/
}
    
