
package electricity.billing.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
public class DepositDetails extends JFrame implements ActionListener{
    Choice dropbox1,dropbox2;
    JTable table;
    JButton search,print;
    DepositDetails(){
      super("Deposit Details");
      setSize(750,700);
      setLocation(400,100);
      setLayout(null);
      getContentPane().setBackground(Color.WHITE);
      
      JLabel meternum=new JLabel("Search By Meter Number");
      meternum.setBounds(20,20,150,20);
      add(meternum);
      dropbox1=new Choice();
      dropbox1.setBounds(180,20,150,20);
      add(dropbox1);
      try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                dropbox1.add(rs.getString("meter_no"));
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
      JLabel month=new JLabel("Search By Month");
      month.setBounds(360,20,100,20);
      add(month);
      dropbox2=new Choice();
      dropbox2.setBounds(500,20,150,20);
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
        add(dropbox2);
        
        table=new JTable();
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from bill");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(table);
        sp.setBounds(0,100,750,700);
        add(sp);
        
       
        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
      
      setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="select * from bill where meter_no='"+dropbox1.getSelectedItem()+"'and month='"+dropbox2.getSelectedItem()+"'";
            try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
            }
        }
        else{
            try{
                table.print();
            }catch(Exception e){
              e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
       new DepositDetails();
    }
    
}
