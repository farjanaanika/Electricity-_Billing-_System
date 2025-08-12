
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class CalculateBill extends JFrame implements ActionListener{
    JTextField unit2;
    JButton b1,b2;
    JLabel name2,address2;
    Choice dropbox1,dropbox2;
    CalculateBill(){
        setSize(600,450);
        setLocation(400,180);
        
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(Color.CYAN);
        add(p);
        JLabel heading=new JLabel("Calculate Electricity Bill");
        heading.setBounds(100,15,400,25);
        heading.setFont(new Font("Arial",Font.PLAIN,24));
        p.add(heading);
        
        JLabel meternum=new JLabel("Meter Number");
        meternum.setBounds(100,80,100,20);
        p.add(meternum);
        dropbox1=new Choice();
        try{
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select * from customer");
           while(rs.next()){
               dropbox1.add(rs.getString("meter_no"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }
        dropbox1.setBounds(200,80,180,20);
        p.add(dropbox1);
        
        
        JLabel name1=new JLabel("Name");
        name1.setBounds(100,120,100,20);
        p.add(name1);
        name2=new JLabel();
        name2.setBounds(200,120,100,20);
        p.add(name2);
        
        JLabel address1=new JLabel("Address");
        address1.setBounds(100,160,100,20);
        p.add(address1);
        address2=new JLabel();
        address2.setBounds(200,160,180,20);
        p.add(address2);
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where meter_no ='"+dropbox1.getSelectedItem()+"'");
            while(rs.next()){
                name2.setText(rs.getString("name"));
                address2.setText(rs.getString("address"));
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        dropbox1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
            try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where meter_no ='"+dropbox1.getSelectedItem()+"'");
            while(rs.next()){
                name2.setText(rs.getString("name"));
                address2.setText(rs.getString("address"));   
            }
        }
            catch(Exception e){
            e.printStackTrace();
              }
             }
            } );
        
        JLabel unit1=new JLabel("Units Consumed");
        unit1.setBounds(100,200,100,20);
        p.add(unit1);
        unit2=new JTextField();
        unit2.setBounds(200,200,180,20);
        p.add(unit2);
        
        JLabel state=new JLabel("Month");
        state.setBounds(100,240,100,20);
        p.add(state);
        dropbox2=new Choice();
        dropbox2.setBounds(200,240,180,20);
        dropbox2.add("January");
        dropbox2.add("February");
        dropbox2.add("March");
        dropbox2.add("April");
        dropbox2.add("May");
        dropbox2.add("June");
        dropbox2.add("July");
        dropbox2.add("August");
        dropbox2.add("September");
        dropbox2.add("October");
        dropbox2.add("November");
        dropbox2.add("December");
        p.add(dropbox2);        
        //Buttons
        b1=new JButton("Submitt");
        b1.setBounds(120,350,100,25);
        b1.addActionListener(this);
        p.add(b1);
        b2=new JButton("Cancel");
        b2.setBounds(250,350,100,25);
        b2.addActionListener(this);
        p.add(b2);
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String s1=dropbox1.getSelectedItem();
            String s2=unit2.getText();
            String s3=dropbox2.getSelectedItem();
            
            int totalbill=0;
            int unitconsume=Integer.parseInt(s2);
            String query1="select * from tax";
            
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery(query1);
             while(rs.next()){
                 totalbill+=unitconsume*Integer.parseInt(rs.getString("cost_per_unit"));
                 totalbill+=Integer.parseInt(rs.getString("meter_rent"));
                 totalbill+=Integer.parseInt(rs.getString("service_charge"));
                 totalbill+=Integer.parseInt(rs.getString("service_tax"));
                 totalbill+=Integer.parseInt(rs.getString("fixed_tax"));
                 
             }
             }catch(Exception e){
                 e.printStackTrace();
                 }
              String query2="insert into bill values('"+s1+"','"+s3+"','"+s2+"','"+totalbill+"','Not Paid')";
              try{
                  Conn c=new Conn();
                  c.s.executeUpdate(query2);
                  JOptionPane.showMessageDialog(null,"Customer Bill Updated Successfully");
                  setVisible(false);
              }catch(Exception e){
                  e.printStackTrace();
              }
              }else{
             setVisible(false);
              }
              }
    
         public static void main(String[] args) {
          new CalculateBill();
         }
    
          }
