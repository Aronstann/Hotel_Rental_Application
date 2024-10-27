
package java2project;


import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/*
 *
 * @author omar
 */
public class Sign_up_page extends JFrame {

    JPanel panel1;
    Container containers;

    private JLabel  Email, Name, Password;
    private JTextField nam, emai;
    private JPasswordField pas;
    private JButton signbtn, rm;

    Sign_up_page() {

        setTitle("Sign up");
        containers = getContentPane();
        containers.setLayout(new BoxLayout(containers, 3));

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(6, 2, 10, 10));
        setSize(900, 900);
        setVisible(true);

        Name = new JLabel("Name");

        nam = new JTextField(40);

        Password = new JLabel("Password");

        pas = new JPasswordField(8);
        pas.setEchoChar('*');

        Email = new JLabel("Email ID");
        emai = new JTextField(20);

        signbtn = new JButton("Sign up");
        rm = new JButton("Clear all");
        JLabel label1 = new JLabel("");
        JLabel label2 = new JLabel("");

        panel1.add(label1);
        panel1.add(label2);
        panel1.add(Name);
        panel1.add(nam);
        panel1.add(Password);
        panel1.add(pas);
        panel1.add(Email);
        panel1.add(emai);
        panel1.add(signbtn);
        panel1.add(rm);

        containers.add(panel1);



    
    
            rm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                nam.setText("");
                pas.setText("");
                emai.setText("");
            }
        });
        signbtn.addActionListener(new ActionListener() {
            //Code for saving signup details to file
            public void actionPerformed(ActionEvent ex) {
                ArrayList<person> al = new ArrayList();

                int flag = 0;
                try {
                    FileInputStream filestream = new FileInputStream("newPerson.dat");
                    ObjectInputStream objectstream = new ObjectInputStream(filestream);

                    person customer;
                    while ((customer = (person) objectstream.readObject()) != null) {
                        if (customer.getname().equals(nam.getText())) {
                            flag = 1;
                            break;
                        }
                        al.add(customer);
                    }
                    objectstream.close();
                    filestream.close();
                }
                catch(FileNotFoundException e)
                {}
                catch (EOFException e) {
                } catch (ClassNotFoundException ex2) {
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (flag == 0) {
                    //write to file only if name doesn't exist
                    person person2 = new person();
                    char[] character = pas.getPassword();
                    String s = new String(character);
                    person2.signup(nam.getText(), emai.getText(), s);

                    al.add(person2);
                    try {
                        FileOutputStream FileoutStream;
                        ObjectOutputStream objectoutputStream;
                        FileoutStream = new FileOutputStream("newPerson.dat");
                        objectoutputStream = new ObjectOutputStream(FileoutStream);

                        person cus;
                        Iterator i = al.iterator();
                        while (i.hasNext()) {
                            cus = (person) i.next();
                            objectoutputStream.writeObject(cus);

                        }

                        FileoutStream.close();
                        objectoutputStream.close();
                        dispose();
                        JOptionPane.showMessageDialog(null, "Welcome to hotel rental " + '\n'
                                + nam.getText() + "," + "\nYou have succesfully signed up ", "Message",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException e) {
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "SORRY" + '\n'
                            + nam.getText() + ", Already exists!\n Try again. ",
                            "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });
    }
   /* public static void main(String[] args) {
        

        new Sign_up_page();

    }*/
}
