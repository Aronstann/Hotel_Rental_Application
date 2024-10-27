/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2project;

/**
 *
 * @author dedo
 */
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class CalendarProgram {

    static JLabel label1, label2;
    static JButton backward, forward;
    static JTable caltable;
    static JComboBox cYear;
    static JFrame frame;
    static Container containers;
    static DefaultTableModel DTMcalendar; //Table model
    static JScrollPane calScroll; //The scrollpane
    static JPanel calPanel;
    static int Year, Month, Day, presentYear, presentMonth;
    
    void calendar() {
        // TODO code application logic here
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}

        catch (ClassNotFoundException e) {}

        catch (InstantiationException e) {}

        catch (IllegalAccessException e) {}
     catch (UnsupportedLookAndFeelException e) {}

        //Prepare frame

        frame = new JFrame ("Calendar"); //Create frame

        frame.setSize(330, 360); //Set size to 400x400 pixels

        containers = frame.getContentPane(); //Get content pane

        containers.setLayout(null); //Apply null layout

       //frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close when X is clicked

 

        //Create controls

        label1 = new JLabel ("January");

        label2 = new JLabel ("Change year:");

        cYear = new JComboBox();

        backward = new JButton ("<<");

        forward = new JButton (">>");

        DTMcalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};

        caltable = new JTable(DTMcalendar);

        calScroll = new JScrollPane(caltable);

        calPanel = new JPanel(null);

 

        //Set border

        calPanel.setBorder(BorderFactory.createTitledBorder("Calendar"));
        
        
        
        
        //Register action listeners
        backward.addActionListener(new backwordAction());
        forward.addActionListener(new forwardAction());
        cYear.addActionListener(new cmbYear_Action());

        

         

        //Add controls to pane

        containers.add(calPanel);

        calPanel.add(label1);

        calPanel.add(label2);

        calPanel.add(cYear);

        calPanel.add(backward);

        calPanel.add(forward);

        calPanel.add(calScroll);

         

        //Set bounds

        calPanel.setBounds(0, 0, 320, 335);

        label1.setBounds(160-label1.getPreferredSize().width/2, 25, 100, 25);

        label2.setBounds(10, 305, 80, 20);

        cYear.setBounds(230, 305, 80, 20);

        backward.setBounds(10, 25, 50, 25);

        forward.setBounds(260, 25, 50, 25);

        calScroll.setBounds(10, 50, 300, 250);

         

        //Make frame visible

        frame.setResizable(false);

        frame.setVisible(true);

         

        //Get real month/year

        GregorianCalendar cal = new GregorianCalendar(); //Create calendar

        Day = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day

        Month = cal.get(GregorianCalendar.MONTH); //Get month

        Year = cal.get(GregorianCalendar.YEAR); //Get year

        presentMonth = Month; //Match month and year

        presentYear = Year;

         

        //Add headers

        String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers

        for (int i=0; i<7; i++){

            DTMcalendar.addColumn(headers[i]);

        }

         

        caltable.getParent().setBackground(caltable.getBackground()); //Set background

 

        //No resize/reorder

        caltable.getTableHeader().setResizingAllowed(false);

        caltable.getTableHeader().setReorderingAllowed(false);

 

        //Single cell selection

        caltable.setColumnSelectionAllowed(true);

        caltable.setRowSelectionAllowed(true);

        caltable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

 

        //Set row/column count

        caltable.setRowHeight(38);

        DTMcalendar.setColumnCount(7);
    DTMcalendar.setRowCount(6);

         

        //Populate table

        for (int i=Year-100; i<=Year+100; i++){

            cYear.addItem(String.valueOf(i));

        }

         

        //Refresh calendar

        refreshCalendar (Month, Year); //Refresh calendar

    }

     

    public static void refreshCalendar(int month, int year){
        //Variables

        String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        int nod, som; //Number Of Days, Start Of Month

             

        //Allow/disallow buttons

        backward.setEnabled(true);

        forward.setEnabled(true);

        if (month == 0 && year <= Year-10){backward.setEnabled(false);} //Too early

        if (month == 11 && year >= Year+100){forward.setEnabled(false);} //Too late

        label1.setText(months[month]); //Refresh the month label (at the top)

        label1.setBounds(160-label1.getPreferredSize().width/2, 25, 180, 25); //Re-align label with calendar

        cYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box

         

        //Clear table

        for (int i=0; i<6; i++){

            for (int j=0; j<7; j++){

                DTMcalendar.setValueAt(null, i, j);

            }

        }

         

        //Get first day of month and number of days

        GregorianCalendar cal = new GregorianCalendar(year, month, 1);

        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);

        som = cal.get(GregorianCalendar.DAY_OF_WEEK);

         

        //Draw calendar

        for (int i=1; i<=nod; i++){

            int row = new Integer((i+som-2)/7);

            int column  =  (i+som-2)%7;

            DTMcalendar.setValueAt(i, row, column);

        }

 

        //Apply renderers

        caltable.setDefaultRenderer(caltable.getColumnClass(0), new tblCalendarRenderer());

    }

 

    static class tblCalendarRenderer extends DefaultTableCellRenderer{

        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){

            super.getTableCellRendererComponent(table, value, selected, focused, row, column);

            if (column == 0 || column == 6){ //Week-end

                setBackground(new Color(255, 220, 220));

            }

            else{ //Week

                setBackground(new Color(255, 255, 255));

            }

            if (value != null){

                if (Integer.parseInt(value.toString()) == Day && presentMonth == Month && presentYear == Year){ //Today

                    setBackground(new Color(220, 220, 255));

                }

            }

            setBorder(null);

            setForeground(Color.black);

            return this; 

        }

    }
    
    
    
    static class backwordAction implements ActionListener{

        public void actionPerformed (ActionEvent e){

            if (presentMonth == 0){ //Back one year

                presentMonth = 11;

                presentYear -= 1;

            }

            else{ //Back one month

                presentMonth -= 1;

            }

            refreshCalendar(presentMonth, presentYear);

        }

    }
    
    static class forwardAction implements ActionListener{

        public void actionPerformed (ActionEvent e){

            if (presentMonth == 11){ //Foward one year

                presentMonth = 0;

                presentYear += 1;

            }

            else{ //Foward one month

                presentMonth += 1;

            }

            refreshCalendar(presentMonth, presentYear);

        }

    }


 
    static class cmbYear_Action implements ActionListener{

        public void actionPerformed (ActionEvent e){

            if (cYear.getSelectedItem() != null){

                String b = cYear.getSelectedItem().toString();

                presentYear = Integer.parseInt(b);

                refreshCalendar(presentMonth, presentYear);

            }

        }

    }

   
    
    
}


