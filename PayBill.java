
package electricity.billing.system;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
public class PayBill extends JFrame implements ActionListener{
    Choice dropbox1;
    JButton b1,b2;
    String meter;
       PayBill(String meter){
           this.meter=meter;
           setLayout(null);
           setBounds(300,150,900,600);
           JLabel heading=new JLabel("Pay Bill");
           heading.setFont(new Font("Arial",Font.BOLD,24));
           heading.setBounds(120,5,400,30);
           add(heading);
           
           JLabel meternum1=new JLabel("Meter Number");
           meternum1.setBounds(35,80,200,20);
           add(meternum1);
           JLabel meternum2=new JLabel("");
           meternum2.setBounds(300,80,200,20);
           add(meternum2);
           
           JLabel name1=new JLabel("Name");
           name1.setBounds(35,140,200,20);
           add(name1);
           JLabel name2=new JLabel("");
           name2.setBounds(300,140,200,20);
           add(name2);
           
           JLabel month1=new JLabel("Month");
           month1.setBounds(35,200,200,20);
           add(month1);
           dropbox1=new Choice();
           dropbox1.setBounds(300,200,200,20);
           dropbox1.add("January");
           dropbox1.add("February");
           dropbox1.add("March");
           dropbox1.add("April");
           dropbox1.add("May");
           dropbox1.add("June");
           dropbox1.add("July");
           dropbox1.add("August");
           dropbox1.add("September");
           dropbox1.add("October");
           dropbox1.add("November");
           dropbox1.add("December");
           add(dropbox1);
           
           JLabel unit1=new JLabel("Units");
           unit1.setBounds(35,260,200,20);
           add(unit1);
           JLabel unit2=new JLabel("");
           unit2.setBounds(300,260,200,20);
           add(unit2);
           
           JLabel totalbill1=new JLabel("Total Bill");
           totalbill1.setBounds(35,320,200,20);
           add(totalbill1);
           JLabel totalbill2=new JLabel("");
           totalbill2.setBounds(300,320,200,20);
           add(totalbill2);
           
           JLabel status1=new JLabel("Status");
           status1.setBounds(35,380,200,20);
           add(status1);
           JLabel status2=new JLabel("");
           status2.setBounds(300,380,200,20);
           status2.setForeground(Color.red);
           add(status2);
           
           try{
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select * from customer where meter_no = '"+meter+"'");
           while(rs.next()){
               meternum2.setText(meter);
               name2.setText(rs.getString("name"));
           }
           rs=c.s.executeQuery("select * from bill where meter_no = '"+meter+"'and month = '"+dropbox1.getSelectedItem()+"'");
           while(rs.next()){
               unit2.setText(rs.getString("units"));
               totalbill2.setText(rs.getString("totalbill"));
               status2.setText(rs.getString("status"));
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
          dropbox1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
            try{
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select * from bill where meter_no = '"+meter+"'and month = '"+dropbox1.getSelectedItem()+"'");
           while(rs.next()){
               unit2.setText(rs.getString("units"));
               totalbill2.setText(rs.getString("totalbill"));
               status2.setText(rs.getString("status"));
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
              }
          });
           
          b1=new JButton("Pay");
          b1.setBackground(Color.BLACK);
          b1.setForeground(Color.WHITE);
          b1.setBounds(100,460,100,25);
          b1.addActionListener(this);
          add(b1);
          b2=new JButton("Back");
          b2.setBackground(Color.BLACK);
          b2.setForeground(Color.WHITE);
          b2.setBounds(230,460,100,25);
          b2.addActionListener(this);
          add(b2);
          getContentPane().setBackground(Color.WHITE);
          ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
          Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
          ImageIcon i3=new ImageIcon(i2);
          JLabel image=new JLabel(i3);
          image.setBounds(400,120,600,300);
          add(image);
          setVisible(true);
       }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==b1){
                 try{
                     Conn c=new Conn();
                     c.s.executeUpdate("update bill set status = 'Paid' where meter_no='"+meter+"'and month='"+dropbox1.getSelectedItem()+"'");
                 }catch(Exception e){
                   e.printStackTrace();
                 }setVisible(false); }
               else{
                setVisible(false);
               }
              }
    public static void main(String[] args) {
        new PayBill("");
    }
}
