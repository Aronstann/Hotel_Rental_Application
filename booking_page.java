
package java2project;

/**
 *
 * @author omar
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author admin
 */
public class booking_page extends JFrame {

            /*public static void main(String[] args) throws AssertionError, ParseException {
        

        booking_page sacc = new booking_page();
        sacc.book();

    }*/
    private String[] year = {"Year", "2023", "2024", "2025"};
    private String[] month = {"Month", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    private String[] day = {"Date", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private String[] room = {"0", "1", "2", "3", "4", "5"};
    
    
    
    private JTextField TFmonthin = new JTextField(15);
    private JTextField TFdatein = new JTextField(15);
    private JTextField TFyearin = new JTextField(15);
    
    private JComboBox CByearin = new JComboBox();
    private JComboBox CBdatein = new JComboBox();
    private JComboBox CBmonthin = new JComboBox();
    private JButton checkin = new JButton("Check Availability");
    
    private JButton viewcalbtn = new JButton("View Calendar");
    
    private JTextField TFmonthout = new JTextField(15);
    private JTextField TFdateout = new JTextField(15);
    private JTextField TFyearout = new JTextField(15);
    
    private JComboBox CByearout = new JComboBox();
    private JComboBox CBdateout = new JComboBox();
    private JComboBox CBmonthout = new JComboBox();
    
    private JComboBox CBregular = new JComboBox();
    private JComboBox CBeconomy = new JComboBox();
    private JComboBox CBsuite = new JComboBox();
    
    private JTextField TFregular = new JTextField(15);
    private JTextField TFeconomy = new JTextField(15);
    private JTextField TFsuite = new JTextField(15);
    
    private JTextField amount = new JTextField(15);
    
    private JButton payment = new JButton("Pay Amount");
    private JButton recepit = new JButton("View Bill Amount");
    
   
    public String monthin, monthout, datein, dateout, yearin, yearout;
    Integer diffDays;
    int regular, Suite, economy;
    
    int bookflag = 0;

    public void book() throws AssertionError, ParseException {
        TFregular.setText("0");
        TFeconomy.setText("0");
        TFsuite.setText("0");

      //  setSize(1600, 1000);
        
        setVisible(true);
        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("hotel.jpg"));
        add(background);

        JLabel checkingin = new JLabel("CheckIn", JLabel.CENTER);
        checkingin.setOpaque(false);
        checkingin.setBounds(50, 50, 150, 30);
        checkingin.setFont(new Font("Times New Roman", Font.BOLD, 30));
        checkingin.setForeground(Color.WHITE);
        background.add(checkingin);
        
        JLabel checkingout = new JLabel("CheckOut", JLabel.CENTER);
        checkingout.setForeground(Color.WHITE);
        checkingout.setOpaque(false);
        checkingout.setBounds(600, 50, 150, 30);
        checkingout.setFont(new Font("Times New Roman", Font.BOLD, 30));
        background.add(checkingout);
        
        checkin.setBounds(130, 500, 450, 50);
        background.add(checkin);
        
               
        
        viewcalbtn.setBounds(800, 150, 200, 50);
        background.add(viewcalbtn);
        viewcalbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CalendarProgram cal = new CalendarProgram();
                cal.calendar();
            }
        });


        

        background.add(checkin);
        viewcalbtn = new JButton("View Calendar");
       
        TFdatein.setBounds(250, 75, 100, 25);
        background.add(TFdatein);
        CBdatein.setBounds(250, 50, 100, 25);
        background.add(CBdatein);
        TFmonthin.setBounds(350, 75, 100, 25);
        background.add(TFmonthin);
        CBmonthin.setBounds(350, 50, 100, 25);
        background.add(CBmonthin);
        TFyearin.setBounds(450, 75, 100, 25);
        background.add(TFyearin);
        CByearin.setBounds(450, 50, 100, 25);
        background.add(CByearin);

        
        
        
        
        
        
        for (int i = 0; i < 13; i++) {
            CBmonthin.addItem(month[i]);
        }
        TFmonthin.setEditable(false);

        for (int i = 0; i < 31; i++) {
            CBdatein.addItem(day[i]);
        }
        TFdatein.setEditable(false);

        for (int i = 0; i < 4; i++) {
            CByearin.addItem(year[i]);
        }
        TFyearin.setEditable(false);


                CBdatein.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TFdatein.setText("" + ((JComboBox) e.getSource()).getSelectedItem());
                datein = TFdatein.getText();
            }
        });

        CBmonthin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TFmonthin.setText((((JComboBox) e.getSource()).getSelectedItem().toString()) + "");
                monthin = TFmonthin.getText();
            }
        });

        CByearin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TFyearin.setText("" + ((JComboBox) e.getSource()).getSelectedItem());
                yearin = TFyearin.getText();
            }
        });


        TFdateout.setBounds(800, 75, 100, 25);
        background.add(TFdateout);
        CBdateout.setBounds(800, 50, 100, 25);
        background.add(CBdateout);

        TFmonthout.setBounds(900, 75, 100, 25);
        background.add(TFmonthout);
        CBmonthout.setBounds(900, 50, 100, 25);
        background.add(CBmonthout);
        background.add(payment);

        TFyearout.setBounds(1000, 75, 100, 25);
        background.add(TFyearout);
        CByearout.setBounds(1000, 50, 100, 25);
        background.add(CByearout);

        for (int i = 0; i < 32; i++) {
            CBdateout.addItem(day[i]);
        }
        TFdateout.setEditable(false);

        for (int i = 0; i < 13; i++) {
            CBmonthout.addItem(month[i]);
        }
        TFmonthout.setEditable(false);

        for (int i = 0; i < 4; i++) {
            CByearout.addItem(year[i]);
        }
        TFyearout.setEditable(false);


        
                CBdateout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TFdateout.setText("" + ((JComboBox) e.getSource()).getSelectedItem());
                dateout = TFdateout.getText();
            }
        });
        CBmonthout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TFmonthout.setText("" + ((JComboBox) e.getSource()).getSelectedItem());
                monthout = TFmonthout.getText();
            }
        });

        CByearout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TFyearout.setText("" + ((JComboBox) e.getSource()).getSelectedItem());
                yearout = TFyearout.getText();
            }
        });

        checkin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                   if(datein==null|| monthin==null||yearin==null||dateout==null||monthout==null||yearout==null)
                    {
                        JOptionPane.showMessageDialog(null,"Please select checkin and checkout dates");
                    }
                    else if(TFregular.getText().equals("0")&& TFsuite.getText().equals("0") && TFeconomy.getText().equals("0"))
                    {
                        JOptionPane.showMessageDialog(null,"Please select atleast one room");
                    }
                    else
                    {int flag = 0;
                   
                    Integer yin = (Integer.parseInt(TFyearin.getText()));
                    Integer min = (Integer.parseInt(TFmonthin.getText()));
                    Integer din = (Integer.parseInt(TFdatein.getText()));
                    Integer yout = (Integer.parseInt(TFyearout.getText()));
                    Integer mout = (Integer.parseInt(TFmonthout.getText()));
                    Integer dout = (Integer.parseInt(TFdateout.getText()));
                    String d1 = TFdatein.getText() + "-" + TFmonthin.getText() + "-" + TFyearin.getText();
                    String d2 = TFdateout.getText() + "-" + TFmonthout.getText() + "-" + TFyearout.getText();
                    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        
                        int y = compareDatesByDateMethods(df, df.parse(d2), df.parse(d1));
                        if (y == 1) {
                            bookflag = 1;
                            flag = 1;
                        }

                    } catch (ParseException ex) {
                        Logger.getLogger(booking_page.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    SimpleDateFormat simpleDF1, simpleDF2, simpleDF3, simpleDF;
                    Date date;
                    date = new Date();
                    simpleDF = new SimpleDateFormat("dd-MM-yyyy");
                    String s = simpleDF.format(date);
                    String ss = TFdatein.getText() + "-" + TFmonthin.getText() + "-" + TFyearin.getText();

                    try {
                        int x = compareDatesByDateMethods(df, df.parse(ss), df.parse(s));
                        if (x == 1) {
                            bookflag = 1;
                            flag = 2;
                        }

                    } catch (ParseException ex) {
                        Logger.getLogger(booking_page.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (flag == 0) {
                        try {
                            FileInputStream fisc = new FileInputStream("newPerson.dat");
                            ObjectInputStream oisc = new ObjectInputStream(fisc);
                            int pdeluxe = 5;
                            int pgrand = 5;
                            int pregular = 5;
                            person cbook;
                            while ((cbook = (person) oisc.readObject()) != null) {

                                if (!(cbook.getname().equals(Login_page.customerlog.getname()))) {

                                    if (!(cbook.getyearout()==null)) {

                                        Integer y1out = (Integer.parseInt(cbook.getyearout()));

                                        Integer y1in = (Integer.parseInt(cbook.getyearin()));

                                        Integer m1in = (Integer.parseInt(cbook.getmonthin()));

                                        Integer m1out = (Integer.parseInt(cbook.getmonthout()));

                                        Integer d1in = (Integer.parseInt(cbook.getdatein()));

                                        Integer d1out = (Integer.parseInt(cbook.getdateout()));

                                        if ((!(yin <= y1in && yout <= y1in && min <= m1in && mout <= m1in && din < d1in && dout < d1in)) && (!(yin >= y1out && yout >= y1out && min >= m1out && mout >= m1out && din > d1out && dout > d1out))) {
                                            if (Login_page.customerlog.city == cbook.city) {
                                                Integer sgrand = (Integer.parseInt(cbook.getregular()));
                                                pgrand = pgrand - sgrand;
                                                Integer sdeluxe = (Integer.parseInt(cbook.getsuite()));
                                                pdeluxe = pdeluxe - sdeluxe;
                                                Integer sregular = (Integer.parseInt(cbook.geteconomy()));
                                                pregular = pregular - sregular;
                                            }

                                        }

                                    }
                                }
                                if (pgrand < Integer.parseInt(TFregular.getText()) || pregular < Integer.parseInt(TFeconomy.getText()) || pdeluxe < Integer.parseInt(TFsuite.getText())) {
                                    flag = 1;

                                    break;
                                }

                            }

                            oisc.close();
                            fisc.close();
                        } catch (EOFException ez) {
                        } catch (ClassNotFoundException ex2) {
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    }
                    if (flag == 0) {
                        bookflag = 0;
                        JOptionPane.showMessageDialog(null, "Booking is available, proceed to pay!", null, JOptionPane.INFORMATION_MESSAGE);
                    } else if (flag == 1) {
                        bookflag = 1;
                        JOptionPane.showMessageDialog(null, "Booking not Available! Change dates or number of rooms and try again.", null, JOptionPane.INFORMATION_MESSAGE);
                    } else if (flag == 2) {
                        bookflag = 1;
                        JOptionPane.showMessageDialog(null, "Invalid date. Please put date after " + s + " !", null, JOptionPane.INFORMATION_MESSAGE);
                    }
                    }
                
            }
        });

        

        JLabel economoy = new JLabel("Economoy Room", JLabel.CENTER);
        economoy.setForeground(Color.WHITE);
        economoy.setOpaque(false);
        economoy.setBounds(80, 340, 400, 50);
        economoy.setFont(new Font("Times New Roman", Font.BOLD, 30));
        background.add(economoy);
        TFeconomy.setBounds(500, 360, 80, 30);
        background.add(TFeconomy);
        CBeconomy.setBounds(500, 330, 80, 40);
        background.add(CBeconomy);

        for (int i = 0; i < 5;) {
            CBeconomy.addItem(room[i++]);
        }
        TFeconomy.setEditable(false);
        
                CBeconomy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TFeconomy.setText("" + ((JComboBox) e.getSource()).getSelectedItem());
            }
        });



        JLabel regular = new JLabel("Regular Room", JLabel.CENTER);
        regular.setForeground(Color.WHITE);
        regular.setOpaque(false);
        regular.setBounds(80, 250, 400, 50);
        regular.setFont(new Font("Times New Roman", Font.BOLD, 30));
        background.add(regular);
        TFregular.setBounds(500, 270, 80, 30);
        background.add(TFregular);
        CBregular.setBounds(500, 240, 80, 40);
        background.add(CBregular);

        for (int i = 0; i < 5;) {
            CBregular.addItem(room[i++]);
        }
        TFregular.setEditable(false);
        CBregular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TFregular.setText("" + ((JComboBox) e.getSource()).getSelectedItem());
            }
        });


        JLabel Suite = new JLabel("Suite Room", JLabel.CENTER);
        Suite.setForeground(Color.WHITE);
        Suite.setOpaque(false);
        Suite.setBounds(80, 160, 400, 50);
        Suite.setFont(new Font("Times New Roman", Font.BOLD, 30));
        background.add(Suite);

        TFsuite.setBounds(500, 180, 80, 30);
        background.add(TFsuite);
        CBsuite.setBounds(500, 150, 80, 40);
        background.add(CBsuite);

        for (int i = 0; i < 5;) {
            CBsuite.addItem(room[i++]);
        }
        TFsuite.setEditable(false);

        CBsuite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TFsuite.setText("" + ((JComboBox) e.getSource()).getSelectedItem());
                String del = TFsuite.getText();
            }
        });

        recepit.setBounds(750, 250, 400, 50);
        background.add(recepit);
        payment.setBounds(750, 550, 400, 50);
        background.add(payment);
        amount.setBounds(750, 400, 400, 50);
        background.add(amount);
        amount.setEditable(false);
        pack();
        
        
        recepit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Calendar cal1 = Calendar.getInstance();
                Calendar cal2 = Calendar.getInstance();

                Integer yin = (Integer.parseInt(TFyearin.getText()));
                Integer min = (Integer.parseInt(TFmonthin.getText()));
                Integer din = (Integer.parseInt(TFdatein.getText()));
                Integer yout = (Integer.parseInt(TFyearout.getText()));
                Integer mout = (Integer.parseInt(TFmonthout.getText()));
                Integer dout = (Integer.parseInt(TFdateout.getText()));
                cal1.set(yin, min, din);
                cal2.set(yout, mout, dout);
                long milis1 = cal1.getTimeInMillis();
                long milis2 = cal2.getTimeInMillis();
                long diff = milis2 - milis1;

                 diffDays = (int) (diff / (24 * 60 * 60 * 1000));
                Integer s = (Login_page.customerlog.getsum(Integer.parseInt(TFeconomy.getText()), Integer.parseInt(TFregular.getText()), Integer.parseInt(TFsuite.getText())));
                s = s * diffDays;
                amount.setText(s.toString());
            }
        });
        payment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (bookflag == 0) {
                    
                   
                    {dispose();
                        int i = JOptionPane.showConfirmDialog(null, "Booking Successful. View Booking");

                    ArrayList<person> al = new ArrayList();
                    try {
                        FileInputStream fis = new FileInputStream("newPerson.dat");
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        person c;
                        while ((c = (person) ois.readObject()) != null) {

                            if (c.getname().equals(Login_page.customerlog.getname())) {
                                c.setrooms(TFsuite.getText(), TFeconomy.getText(), TFregular.getText());
                                c.city = Login_page.customerlog.city;
                                c.setdates(TFdatein.getText(), TFmonthin.getText(), TFyearin.getText(), TFdateout.getText(), TFmonthout.getText(), TFyearout.getText());
                                c.getsum(Integer.parseInt(TFeconomy.getText())*diffDays, Integer.parseInt(TFregular.getText())*diffDays, Integer.parseInt(TFsuite.getText())*diffDays);
                                Login_page.customerlog.setdates(TFdatein.getText(), TFmonthin.getText(), TFyearin.getText(), TFdateout.getText(), TFmonthout.getText(), TFyearout.getText());
                                
                                Login_page.customerlog.setrooms(TFsuite.getText(), TFeconomy.getText(), TFregular.getText());
                                
                            }
                            al.add(c);
                        }
                        ois.close();
                        fis.close();
                    } catch (EOFException e1) {
                    } catch (ClassNotFoundException ex2) {
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }

                    try {
                        FileOutputStream fos;
                        ObjectOutputStream oos;
                        fos = new FileOutputStream("newPerson.dat");
                        oos = new ObjectOutputStream(fos);

                        person c;
                        Iterator i1 = al.iterator();
                        while (i1.hasNext()) {
                            c = (person) i1.next();
                            oos.writeObject(c);

                        }

                        fos.close();
                        oos.close();

                    } catch (IOException e3) {
                    }
                    if (i == 0) {
                        View_book_page vb = new View_book_page();
                        vb.buildscreen();
                    } 
                    else {
                        int j=JOptionPane.showConfirmDialog(null, "Logout ?");
                        if(j==0)
                        {
                            Login_page.customerlog=null;
                            dispose();
                            screen s=new screen();
                            s.buildscreen();
                        }
                    }
                    }
                }
                 else {
                    JOptionPane.showMessageDialog(null, "Booking is not available, please make changes!", null, JOptionPane.INFORMATION_MESSAGE);
                }
                
            
        }});
        
    }

    public int compareDatesByDateMethods(DateFormat df, Date oldDate, Date newDate) {

        if (oldDate.equals(newDate)) {

            return 0;
        }

        if (oldDate.before(newDate)) {

            return 1;

        }

        if (oldDate.after(newDate)) {

            return 0;
        }
        return 0;
    }
}
