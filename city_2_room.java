
package java2project;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author omar
 */
public class city_2_room extends JFrame {

    
         /*   public static void main(String[] args) {
        

        city_2_room s = new city_2_room();
        s.setupscreen4();

    }*/
    public void setupscreen4() {
           
        setVisible(true);
     //   this.setSize(1800, 1450);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel backscreen = new JLabel(new ImageIcon("hotel.jpg"));
        backscreen.setBounds(00, 00, 400, 300);
        add(backscreen);

        
        JLabel label1 = new JLabel("REGULAR ROOM", JLabel.CENTER);
        label1.setOpaque(true);
        label1.setBounds(10, 0, 700, 30);
        label1.setFont(new Font("Castellar", Font.PLAIN, 18));
        backscreen.add(label1);

        JLabel label2 = new JLabel("ECONOMY ROOM", JLabel.CENTER);
        label2.setOpaque(true);
        label2.setBounds(10, 220, 700, 30);
        label2.setFont(new Font("Castellar", Font.PLAIN, 18));
        backscreen.add(label2);

        JLabel label3 = new JLabel("SUITE ROOM", JLabel.CENTER);
        label3.setOpaque(true);
        label3.setBounds(10, 440, 700, 30);
        label3.setFont(new Font("Castellar", Font.PLAIN, 18));
        backscreen.add(label3);

       
        JTextArea TextArea1 = new JTextArea("   The Regular room provides amenities designed \n"
                + "   to indulge you in every possible manner\n"
                + "  ensuring that your stay at  \n"
                + "   Hotel Rental is enjoyable and satisfying .\n   RATE:800SR/day");
        TextArea1.setOpaque(true);
        TextArea1.setBounds(10, 30, 700, 170);
        TextArea1.setEditable(false);
        TextArea1.setFont(new Font("Aparajita", Font.PLAIN, 24));
        backscreen.add(TextArea1);
        
        
        JTextArea TextArea2 = new JTextArea("   Our dedicated team is committed to \n"
                + "   meeting  the needs  of economy room \n"
                + "   guests promptly and efficiently, ensuring  \n"
                + "   a comfortable and pleasant stay. \n   RATE:500SR/day");
        TextArea2.setOpaque(true);
        TextArea2.setBounds(10, 250, 700, 170);
        TextArea2.setEditable(false);
        TextArea2.setFont(new Font("Aparajita", Font.PLAIN, 24));
        backscreen.add(TextArea2);
        
        
        JTextArea TextArea3 = new JTextArea("   Our suite rooms epitomize coziness and comfort \n"
                + "   hey represent the most sought-after accommodation \n"
                + "   choice we offer ensuring a homey atmosphere.\n"
                + "   that truly feels like a second home.\n   RATE:1000SR/day");
        TextArea3.setOpaque(true);
        TextArea3.setBounds(10, 470, 700, 170);
        TextArea3.setEditable(false);
        TextArea3.setFont(new Font("Aparajita", Font.PLAIN, 24));
        backscreen.add(TextArea3);
pack();
    }

}
