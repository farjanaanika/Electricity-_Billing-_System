
package electricity.billing.system;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener  {
    JButton b1,b2;
    Choice acc2;
    JTextField meterTF,usernameTF,nameTF,passTF;
       Signup(){
           setBounds(400,200,700,350);
           getContentPane().setBackground(Color.WHITE);
           setLayout(null);
           JPanel p1=new JPanel();
           p1.setBounds(20,15,690,280);
           p1.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"Create Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(173,216,230)));
           p1.setBackground(Color.WHITE);
           p1.setLayout(null);
           p1.setForeground(new Color(34,139,34));
           add(p1);
           
           JLabel acc1=new JLabel("Create Account As");
           acc1.setBounds(100,50,140,20);
           acc1.setForeground(Color.blue);
           acc1.setFont(new Font("Calibri",Font.BOLD,18));
           p1.add(acc1);   
           acc2=new Choice();
           acc2.add("Admin");
           acc2.add("Customer");
           acc2.setBounds(250,48,170,90);
           p1.add(acc2);
           
           JLabel meter=new JLabel("Meter Number");
           meter.setBounds(100,90,140,20);
           meter.setForeground(Color.blue);
           meter.setFont(new Font("Calibri",Font.BOLD,18));
           meter.setVisible(false);
           p1.add(meter);
           meterTF=new JTextField();
           meterTF.setBounds(250,90,175,20);
           meterTF.setVisible(false);
           p1.add(meterTF);
 
           
           JLabel username=new JLabel("Username");
           username.setBounds(100,130,140,20);
            username.setForeground(Color.blue);
            username.setFont(new Font("Calibri",Font.BOLD,18));
           p1.add( username);
           usernameTF=new JTextField();
            usernameTF.setBounds(250,130,175,20);
           p1.add( usernameTF);
           
           JLabel name=new JLabel("Name");
           name.setBounds(100,170,140,20);
           name.setForeground(Color.blue);
           name.setFont(new Font("Calibri",Font.BOLD,18));
           p1.add(name);
           nameTF=new JTextField();
           nameTF.setBounds(250,170,175,20);
           p1.add(nameTF);
            meterTF.addFocusListener(new FocusListener(){
               public void focusGained(FocusEvent fe){
               }
               public void focusLost(FocusEvent fe){
                   try{
                       Conn c=new Conn();
                       ResultSet rs=c.s.executeQuery("select * from login where meter_no='"+meterTF.getText()+"'"); 
                       while(rs.next()){
                           nameTF.setText(rs.getString("name"));
                       }
                   }catch(Exception e){
                       e.printStackTrace();
                   }
               }
             
           });
          
           
           JLabel pass=new JLabel("Password");
           pass.setBounds(100,210,140,20);
           pass.setForeground(Color.blue);//to set panel font clr
           pass.setFont(new Font("Calibri",Font.BOLD,18));//import Font from awt package
           p1.add(pass);
           passTF=new JTextField();
           passTF.setBounds(250,210,175,20);
           p1.add(passTF);
           
           acc2.addItemListener(new ItemListener(){
               public void itemStateChanged(ItemEvent ae){
                   String user=acc2.getSelectedItem();
                   if(user.equals("Customer")){
                        meter.setVisible(true);
                        meterTF.setVisible(true);
                        nameTF.setEditable(false);
                        
                   }
                   else{
                       meter.setVisible(false);
                       meterTF.setVisible(false);
                       nameTF.setEditable(true);
                   }
               }
           });
           
            b1=new JButton("Create");
           b1.setBounds(130,245,100,23);
           b1.setBackground(Color.BLUE);
           b1.setForeground(Color.WHITE);
           b1.addActionListener(this);
           p1.add(b1);
           
           b2=new JButton("Back");
           b2.setBounds(260,245,100,23);
           b2.setBackground(Color.BLUE);
           b2.setForeground(Color.WHITE);
           b2.addActionListener(this);
           p1.add(b2);
           
           ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
           Image i4=i3.getImage().getScaledInstance(170,170,Image.SCALE_DEFAULT);
           ImageIcon i5=new ImageIcon(i4);
           JLabel image3=new JLabel(i5);
           image3.setBounds(450,60,170,170);
           p1.add(image3);
           
           
           
           setVisible(true);
       }
       
       public void actionPerformed(ActionEvent ae){
           if(ae.getSource()==b1){
               String s1=acc2.getSelectedItem();
               String s2=meterTF.getText();
               String s3=usernameTF.getText();
               String s4=nameTF.getText();
               String s5=passTF.getText();
               //to hit mysql
               try{
                   Conn c=new Conn();//to establish connection with sql
                   String query=null;
                   if(s1.equals("Admin")){
                    query="insert into login values('"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s1+"')";//to hit sql query
                   }else{
                       query="update login set username='"+s3+"',password='"+s5+"',user='"+s1+"'where meter_no='"+s2+"'";
                   }
                   c.s.executeUpdate(query);//to execute sql query
                   JOptionPane.showMessageDialog(null,"Account Created Successfully");//popup
                   setVisible(false);
                   new Login();
               }catch(Exception e){
                   e.printStackTrace();
               }
               
           }
           else if(ae.getSource()==b2){
               setVisible(false);
               new Login();
           }
       }
    
    public static void main(String[] args) {
        new Signup();
    }
    
}
