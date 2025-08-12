
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class GenerateBill extends JFrame implements ActionListener{
    String meter;
    JButton bill,print;
    Choice dropbox1;
    JTextArea area;
       GenerateBill(String meter){
       this.meter=meter;
       setSize(500,700);
       setLocation(550,30);
       setLayout(new BorderLayout());
       JPanel panel=new JPanel();
       JLabel heading=new JLabel("Generate Bill");
       JLabel meternum=new JLabel(meter);
       
           dropbox1=new Choice();
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
        
        area=new JTextArea(50,15);
        area.setText("\n\n\t-------Click on the-------\n\t Generate Bill Button to get\n\tthe Bill of the Selected Month");
        area.setFont(new Font("Calibri",Font.ITALIC,18));
        JScrollPane pane=new JScrollPane(area);
        bill=new JButton("Generate Bill");
        bill.addActionListener(this);
        
        print=new JButton("Print");
        print.addActionListener(this);
        
        panel.add(heading);
        panel.add(meternum);
        panel.add(dropbox1);
        add(panel, "North");
        add(pane, "Center");
        add(bill,"South");
        panel.add(print,""); 
        
        setVisible(true);
       }
       public void actionPerformed(ActionEvent ae){
           if (ae.getSource() == bill) {
        try{
            Conn c=new Conn();
            String month=dropbox1.getSelectedItem();
            area.setText("ELECTRICITY BILL GENERATED FOR THE MONTH \t\t\nOF "+month+",2025\n\n");  
            ResultSet rs=c.s.executeQuery("select * from customer where meter_no ='"+meter+"'");
            if(rs.next()){
                area.append("\n   Customer Name: "+rs.getString("name"));
                area.append("\n   Meter Number : "+rs.getString("meter_no"));
                area.append("\n   Address      : "+rs.getString("address"));
                area.append("\n   City         : "+rs.getString("city"));
                area.append("\n   State        : "+rs.getString("state"));
                area.append("\n   Email        : "+rs.getString("email"));
                area.append("\n   Phone        : "+rs.getString("phone"));
                area.append("\n--------------------------------------\n");}
            rs=c.s.executeQuery("select * from meter_info where meter_no ='"+meter+"'");
            if(rs.next()){
                area.append("\n   Meter Location: "+rs.getString("meter_location"));
                area.append("\n   Meter Type    : "+rs.getString("meter_type"));
                area.append("\n   Phase Code    : "+rs.getString("pashe_code"));
                area.append("\n   Bill Type     : "+rs.getString("bill_type"));
                area.append("\n   Days          : "+rs.getString("days"));
                area.append("\n--------------------------------------\n");}
            rs=c.s.executeQuery("select * from tax");
            if(rs.next()){
                area.append("\n   Cost Per Unit  : "+rs.getString("cost_per_unit"));
                area.append("\n   Meter Rent     : "+rs.getString("meter_rent"));
                area.append("\n   Service Charge : "+rs.getString("service_charge"));
                area.append("\n   Fixed Tax      : "+rs.getString("fixed_tax"));
                area.append("\n--------------------------------------\n");}
            rs=c.s.executeQuery("select * from bill where meter_no='"+meter+"' and month='"+month+"'");
            if(rs.next()){
                area.append("\n   Current Month     : "+rs.getString("month"));
                area.append("\n   Units Consumed    : "+rs.getString("units"));
                area.append("\n--------------------------------------");
                area.append("\n   Total Bill        : "+rs.getString("totalbill"));
                area.append("\n");} 
            else {
                area.append("\n   No bill found for the selected month.\n");
               }
            } catch(Exception e){
            e.printStackTrace();}
           }else if (ae.getSource() == print) {
        try{
            area.print();
        }catch (Exception e) {
            e.printStackTrace();
             }}
            }
       public static void main(String[] args) {
        new GenerateBill("");
    }
    
}
