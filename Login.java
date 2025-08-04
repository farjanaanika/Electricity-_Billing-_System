
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    Login(){
        super("Login Frame");
        getContentPane().setBackground(Color.WHITE);//Color in awt package
        setLayout(null);//By default output null
        
        ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i3=i2.getImage().getScaledInstance(230,230,Image.SCALE_DEFAULT); 
        ImageIcon i4=new ImageIcon(i3);
        JLabel image2=new JLabel(i4);
        image2.setBounds(0, 0, 230, 230);
        add(image2);
        
        JLabel username=new JLabel("Username");
        username.setBounds(300,20,100,20);//To set the message on the frame.This function works when default Layout is null
        add(username);
        JTextField F1=new JTextField();//to add textfield
        F1.setBounds(400,20,150,20);
        add(F1);
        
        JLabel pass=new JLabel("Password");
        pass.setBounds(300,60,100,20);
        add(pass);
        JTextField F2=new JTextField();//to add textfield
        F2.setBounds(400,60,150,20);
        add(F2);
        
        JLabel login1=new JLabel("Loggin in as");
        login1.setBounds(300,100,100,20);
        add(login1);
        
        Choice login2=new Choice();//dropbox
        login2.add("Admin");
        login2.add("Customer");
        login2.setBounds(400,100,150,20);
        add(login2);
        
        JButton b1=new JButton("Login");//to add button on the frame
        b1.setBounds(330,150,100,30);
        add(b1);
        JButton b2=new JButton("Cancel");
        b2.setBounds(450,150,100,30);
        add(b2);
        JButton b3=new JButton("Signup");
        b3.setBounds(380,200,100,30);
        add(b3);
        
        setSize(640,300);//Frame size
        setLocation(400,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }
    
}
