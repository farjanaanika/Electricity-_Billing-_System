
package electricity.billing.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
public class ViewInformation extends JFrame implements ActionListener {
    JButton cancel;
    ViewInformation(String meter){
        setBounds(350,150,850,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading=new JLabel("View Customer Information");
        heading.setBounds(250,0,500,40);
        heading.setFont(new Font("Calibri",Font.PLAIN,30));
        add(heading);
        
        JLabel name1=new JLabel("Name");
        name1.setBounds(70,80,100,20);
        add(name1);
        JLabel name2=new JLabel("");
        name2.setBounds(250,80,100,20);
        add(name2);
        
        JLabel meternum1=new JLabel("Meter Number");
        meternum1.setBounds(70,140,100,20);
        add(meternum1);
        JLabel meternum2=new JLabel("");
        meternum2.setBounds(250,140,100,20);
        add(meternum2);
        
        JLabel address1=new JLabel("Address");
        address1.setBounds(70,200,100,20);
        add(address1);
        JLabel address2=new JLabel("");
        address2.setBounds(250,200,100,20);
        add(address2);
        
        JLabel city1=new JLabel("City");
        city1.setBounds(70,260,100,20);
        add(city1);
        JLabel city2=new JLabel("");
        city2.setBounds(250,260,100,20);
        add(city2);
        
        JLabel state1=new JLabel("State");
        state1.setBounds(500,80,100,20);
        add(state1);
        JLabel state2=new JLabel("");
        state2.setBounds(650,80,100,20);
        add(state2);
        
        JLabel email1=new JLabel("Email");
        email1.setBounds(500,140,100,20);
        add(email1);
        JLabel email2=new JLabel("");
        email2.setBounds(650,140,100,20);
        add(email2);
        
        JLabel phone1=new JLabel("Phone");
        phone1.setBounds(500,200,100,20);
        add(phone1);
        JLabel phone2=new JLabel("");
        phone2.setBounds(650,200,100,20);
        add(phone2);
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where meter_no ='"+meter+"'");
            while(rs.next()){
                name2.setText(rs.getString("name"));
                meternum2.setText(rs.getString("meter_no")); 
                address2.setText(rs.getString("address")); 
                city2.setText(rs.getString("city"));
                state2.setText(rs.getString("state")); 
                email2.setText(rs.getString("email")); 
                phone2.setText(rs.getString("phone")); 
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(300,340,100,25);
        add(cancel);
        cancel.addActionListener(this);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(20,350,600,300);
        add(image);
        
        
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae){
         setVisible(false);
     }
    public static void main(String[] args) {
        new ViewInformation("");
    }
    
    
}
