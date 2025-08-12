package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton b1,b2,b3;
    JTextField F1,F2;
    Choice login2;
    Login(){
        super("Login Frame");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i3=i2.getImage().getScaledInstance(230,230,Image.SCALE_DEFAULT); 
        ImageIcon i4=new ImageIcon(i3);
        JLabel image2=new JLabel(i4);
        image2.setBounds(0, 0, 230, 230);
        add(image2);
        
        JLabel username=new JLabel("Username");
        username.setBounds(300,20,100,20);
        add(username);
         F1=new JTextField();
        F1.setBounds(400,20,150,20);
        add(F1);
        
        JLabel pass=new JLabel("Password");
        pass.setBounds(300,60,100,20);
        add(pass);
        F2=new JTextField();
        F2.setBounds(400,60,150,20);
        add(F2);
        
        JLabel login1=new JLabel("Loggin in as");
        login1.setBounds(300,100,100,20);
        add(login1);
        
        login2=new Choice();
        login2.add("Admin");
        login2.add("Customer");
        login2.setBounds(400,100,150,20);
        add(login2);
        
        b1=new JButton("Login");
        b1.setBounds(330,150,100,30);
        b1.addActionListener(this);
        add(b1);
         b2=new JButton("Cancel");
        b2.setBounds(450,150,100,30);
        b2.addActionListener(this);
        add(b2);
         b3=new JButton("Signup");
        b3.setBounds(380,200,100,30);
        b3.addActionListener(this);
        add(b3);
        
        setSize(640,300);
        setLocation(400,200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String s1=F1.getText();
            String s2=F2.getText();
            String s3=login2.getSelectedItem();
        
            try{
                Conn c=new Conn();
                String query="select*from login where username ='"+s1+"' and password ='"+s2+"'and user='"+s3+"'";
                ResultSet rs= c.s.executeQuery(query);
               if(rs.next()){
                   String meter=rs.getString("meter_no");
                   setVisible(false);
                   new Project(s3,meter);
               }else{
                   JOptionPane.showMessageDialog(null,"Invalid login");
                   F1.setText("");
                   F2.setText("");
               }
               
            }catch(Exception e){
                e.printStackTrace();
            }   
        } 
        else if(ae.getSource()==b2){
            setVisible(false);
        }
        else if(ae.getSource()==b3){
            setVisible(false);
            new Signup();
        }
        
    }
    public static void main(String[] args) {
        new Login();
    }
    
}



