/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2project;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author admin
 */
public class person implements Serializable {
    String nam;
    String emailid;
    String pass;
    String month_in,year_in,datein;
    String monthout,yearout,dateout;
    String suite;
    String regular;
    String economy;
    int totalsum;
    public int city;
   // int hasBooked=0;
    person()
    {
        nam=null;
        emailid=null;
        pass=null;
        month_in=null;
        month_in=year_in=datein=null;
        monthout=yearout=dateout=null;
        suite="0";
        regular="0";
        economy="0";
        totalsum=0;
        city=0;
    }
    void signup(String name,String emailid, String password) {
        
        this.nam=name;
        this.emailid=emailid;
        this.pass=password;
        
    }
    void setrooms(String suite,String economy,String regular)
    {
        this.suite=suite;
        this.economy=economy;
        this.regular=regular;
    }
    void setdates(String datein,String monthin,String yearin,String dateout,String monthout,String yearout)
    {
        this.datein=datein;
        this.month_in=monthin;
        this.year_in=yearin;
        this.dateout=dateout;
        this.monthout=monthout;
        this.yearout=yearout;
    }
    String getname()
    {
        return this.nam;
    }
    String getpassword()
    {  
        return this.pass;
    }
    String getemail()
    {  
        return this.emailid;
    }
    String getdatein()
    {  
        return this.datein;
    }
    String getmonthin()
    {  
        return this.month_in;
    }
    String getyearin()
    {  
        return this.year_in;
    }
    String getdateout()
    {  
        return this.dateout;
    }
    String getmonthout()
    {  
        return this.monthout;
    }
    String getyearout()
    {  
        return this.yearout;
    }
    String getsuite(){
       return this.suite;
    }
    
    String geteconomy(){
        return this.economy;
    }
    
    String getregular(){
        return this.regular;
    }
     
    Integer getsum(int economy,int regular,int suite){
        totalsum=(int) (economy*500+regular*800+suite*1000);
        return(totalsum);
    }
    int getamount()
    {return totalsum;}
    int getcity()
    {
        return city;
    }
   
}

