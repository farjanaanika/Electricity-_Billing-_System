
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class NewCustomer extends JFrame implements ActionListener{
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    JButton b1,b2;
    JLabel autometer;
    NewCustomer(){
        setSize(700,500);
        setLocation(400,180);
        
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(Color.CYAN);
        add(p);
        JLabel heading=new JLabel("New Customer");
        heading.setBounds(180,15,200,25);
        heading.setFont(new Font("Arial",Font.PLAIN,24));
        p.add(heading);
        
        JLabel customer=new JLabel("Customer Name");
        customer.setBounds(100,80,100,20);
        p.add(customer);
        tf1=new JTextField();
        tf1.setBounds(200,80,180,20);
        p.add(tf1);
        
        JLabel meternum=new JLabel("Meter Number");
        meternum.setBounds(100,120,100,20);
        p.add(meternum);
        autometer=new JLabel("");
        autometer.setBounds(200,120,100,20);
        p.add(autometer);
        Random ran=new Random();
        long number=ran.nextLong()%1000000;
        autometer.setText(""+Math.abs(number));
        
        JLabel address=new JLabel("Address");
        address.setBounds(100,160,100,20);
        p.add(address);
        tf2=new JTextField();
        tf2.setBounds(200,160,180,20);
        p.add(tf2);
        
        JLabel city=new JLabel("City");
        city.setBounds(100,200,100,20);
        p.add(city);
        tf3=new JTextField();
        tf3.setBounds(200,200,180,20);
        p.add(tf3);
        
        JLabel state=new JLabel("State");
        state.setBounds(100,240,100,20);
        p.add(state);
        tf4=new JTextField();
        tf4.setBounds(200,240,180,20);
        p.add(tf4);
        
        JLabel email=new JLabel("Email");
        email.setBounds(100,280,100,20);
        p.add(email);
        tf5=new JTextField();
        tf5.setBounds(200,280,180,20);
        p.add(tf5);
        
        JLabel phn=new JLabel("Phone Number");
        phn.setBounds(100,320,100,20);
        p.add(phn);
        tf6=new JTextField();
        tf6.setBounds(200,320,180,20);
        p.add(tf6);
        
        
        b1=new JButton("Next");
        b1.setBounds(120,390,100,25);
        b1.addActionListener(this);
        p.add(b1);
        b2=new JButton("Cancel");
        b2.setBounds(250,390,100,25);
        b2.addActionListener(this);
        p.add(b2);
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String s1=tf1.getText();
            String s2=tf2.getText();
            String s3=tf3.getText();
            String s4=tf4.getText();
            String s5=tf5.getText();
            String s6=tf6.getText();
            String s7=autometer.getText();
            
            String query1="insert into customer values('"+s1+"','"+s7+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')";
            String query2="insert into login values('"+s7+"','','"+s1+"','','')";
        try{
            Conn c=new Conn();
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            JOptionPane.showMessageDialog(null,"Customer Details Created Successfully");//popup
            setVisible(false);
            new MeterInfo(s7);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        }
    else{
          setVisible(false);
           }
    }
    
    public static void main(String[] args) {
        new NewCustomer();
    }
    
}
