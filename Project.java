
package electricity.billing.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    String user,meter;
    Project(String user,String meter){
        this.user=user;
        this.meter=meter;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/pp.jpg"));
        Image i5=i4.getImage().getScaledInstance(1550,850,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image3=new JLabel(i6);
        add(image3);
        
        JMenuBar mb=new JMenuBar();
        setJMenuBar(mb);
        JMenu menu1=new JMenu("Master");
        menu1.setForeground(Color.BLUE);
        
        //In menu 1
        JMenuItem item1=new JMenuItem("New Customer");
        menu1.add(item1);
        item1.setBackground(Color.LIGHT_GRAY);
        item1.addActionListener(this);
        ImageIcon customer1=new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image customer2=customer1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT); 
        item1.setIcon(new ImageIcon( customer2));
        
        JMenuItem item2=new JMenuItem("Customer Details");
        menu1.add(item2);
        item2.setBackground(Color.LIGHT_GRAY);
        item2.addActionListener(this);
        ImageIcon details1 =new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image details2=details1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT); 
        item2.setIcon(new ImageIcon(details2));
        
        JMenuItem item3=new JMenuItem("Deposit Details");
        menu1.add(item3);
        item3.setBackground(Color.LIGHT_GRAY);
        item3.addActionListener(this);
        ImageIcon deposit1 =new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image deposit2=deposit1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT); 
        item3.setIcon(new ImageIcon(deposit2));
        
        JMenuItem item4=new JMenuItem("Calculate Bills");
        menu1.add(item4);
        item4.setBackground(Color.LIGHT_GRAY);
        item4.addActionListener(this);
        ImageIcon calculate1=new ImageIcon(ClassLoader.getSystemResource("icon/icon5.png"));
        Image calculate2=calculate1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT); 
        item4.setIcon(new ImageIcon(calculate2));
        
       
        JMenu menu2=new JMenu("Information");
        menu2.setForeground(Color.GREEN);
        
        JMenuItem item6=new JMenuItem("View Information");
        menu2.add(item6);
        item6.setBackground(Color.LIGHT_GRAY);
        ImageIcon view1=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image view2=view1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT); 
        item6.setIcon(new ImageIcon(view2));
        item6.addActionListener(this);
        //in menu3
        JMenu menu3=new JMenu("User");
        menu3.setForeground(Color.red);
        
        
        JMenuItem item7=new JMenuItem("Pay Bill");
        menu3.add(item7);
        item7.setBackground(Color.LIGHT_GRAY);
        ImageIcon bill1=new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image bill2=bill1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT); 
        item7.setIcon(new ImageIcon(bill2));
        item7.addActionListener(this);
        
        JMenuItem item8=new JMenuItem("Bill Details");
        menu3.add(item8);
        item8.setBackground(Color.LIGHT_GRAY);
        ImageIcon billDetails1=new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image billDetails2 =billDetails1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT); 
        item8.setIcon(new ImageIcon(billDetails2));
        item8.addActionListener(this);
        //in menu4
        JMenu menu4=new JMenu("Report");
        menu4.setForeground(Color.BLUE);
       
        JMenuItem item9=new JMenuItem("Generate Bill");
        menu4.add(item9);
        item9.setBackground(Color.LIGHT_GRAY);
        ImageIcon generate1=new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image generate2 =generate1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT); 
        item9.setIcon(new ImageIcon(generate2));
        item9.addActionListener(this);
       
        //exit menu
        JMenu menu6=new JMenu("Exit");
        menu6.setForeground(Color.RED);
        JMenuItem item12=new JMenuItem("Exit");
        menu6.add(item12);
        item12.setBackground(Color.LIGHT_GRAY);
        ImageIcon exit1=new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image exit2 =exit1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT); 
        item12.setIcon(new ImageIcon(exit2));
        item12.addActionListener(this);
        
        if(user.equals("Admin")){
        mb.add(menu1);
        }
        else{
        mb.add(menu2);
        mb.add(menu3);
        mb.add(menu4);
        }
        mb.add(menu6);
        
        
        setLayout(new FlowLayout());
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
                String msg=ae.getActionCommand();
                if(msg.equals("New Customer")){
                    new NewCustomer();
                }
                else if(msg.equals("Customer Details")){
                   new CustomerDetails();
                }
                else if(msg.equals("Deposit Details")){
                    new DepositDetails();
                }
                else if(msg.equals("Calculate Bills")){
                    new CalculateBill();
                }else if(msg.equals("View Information")){
                    new ViewInformation(meter);
                }else if(msg.equals("Bill Details")){
                     new BillDetails(meter);
                }else if(msg.equals("Exit")){
                    setVisible(false);
                    new Login();
                }else if(msg.equals("Pay Bill")){
                    new PayBill(meter);
                }else if(msg.equals("Generate Bill")){
                    new GenerateBill(meter);
                }
    }
    
    public static void main(String[] args) {
        new Project("","");
    }
    
}
