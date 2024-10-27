
package java2project;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author omar
 */
public class city_3_room extends JFrame {
    
            /*    public static void main(String[] args) {
       

        city_3_room s = new city_3_room();
        s.setupscreen5();

    }*/

    public void setupscreen5() {
          
        setVisible(true);
        //this.setSize(1800, 1450);
        
        JPanel pane = new JPanel();
        pane.setLayout(null);
        JLabel background = new JLabel(new ImageIcon("hotel.jpg"));
        background.setBounds(00, 00, 400, 300);
        add(background);


   
        JLabel label4 = new JLabel("REGULAR ROOM", JLabel.CENTER);
        label4.setOpaque(true);
        label4.setBounds(10, 0, 700, 30);
        label4.setFont(new Font("Castellar", Font.PLAIN, 18));
        background.add(label4);

        JLabel label5 = new JLabel("ECONOMY ROOM", JLabel.CENTER);
        label5.setOpaque(true);
        label5.setBounds(10, 220, 700, 30);
        label5.setFont(new Font("Castellar", Font.PLAIN, 18));
        background.add(label5);

        JLabel label6 = new JLabel("SUITE ROOM", JLabel.CENTER);
        label6.setOpaque(true);
        label6.setBounds(10, 440, 700, 30);
        label6.setFont(new Font("Castellar", Font.PLAIN, 18));
        background.add(label6);

        
       JTextArea TextArea1 = new JTextArea("   The Regular room provides amenities designed \n"
                + "   to indulge you in every possible manner\n"
                + "  ensuring that your stay at  \n"
                + "   Hotel Rental is enjoyable and satisfying .\n   RATE:800SR/day");
        TextArea1.setOpaque(true);
        TextArea1.setBounds(10, 30, 700, 170);
        TextArea1.setEditable(false);
        TextArea1.setFont(new Font("Aparajita", Font.PLAIN, 24));
        background.add(TextArea1);
        
        
        
        JTextArea TextArea2 = new JTextArea("   Our dedicated team is committed to \n"
                + "   meeting  the needs  of economy room \n"
                + "   guests promptly and efficiently, ensuring  \n"
                + "   a comfortable and pleasant stay. \n   RATE:500SR/day");
        TextArea2.setOpaque(true);
        TextArea2.setBounds(10, 250, 700, 170);
        TextArea2.setEditable(false);
        TextArea2.setFont(new Font("Aparajita", Font.PLAIN, 24));
        background.add(TextArea2);
        
       JTextArea TextArea3 = new JTextArea("   Our suite rooms epitomize coziness and comfort \n"
                + "   hey represent the most sought-after accommodation \n"
                + "   choice we offer ensuring a homey atmosphere.\n"
                + "   that truly feels like a second home.\n   RATE:1000SR/day");
        TextArea3.setOpaque(true);
        TextArea3.setBounds(10, 470, 700, 170);
        TextArea3.setEditable(false);
        TextArea3.setFont(new Font("Aparajita", Font.PLAIN, 24));
        background.add(TextArea3);

        pack();
    }

}
