
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MeterInfo extends JFrame implements ActionListener{
    JButton b1;
    Choice location2,type2,phase2,bill2;
    String meternum;
         MeterInfo(String meternum){
          this.meternum=meternum;
        setSize(600,450);
        setLocation(400,180);
        
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(Color.LIGHT_GRAY);
        add(p);
        JLabel heading=new JLabel("Meter Information");
        heading.setBounds(180,15,200,25);
        heading.setFont(new Font("Calibri",Font.PLAIN,24));
        p.add(heading);
        
        JLabel meternum1=new JLabel("Meter Number");
        meternum1.setBounds(100,80,100,20);
        p.add(meternum1);
        JLabel meternum2=new JLabel(meternum);
         meternum2.setBounds(240,80,100,20);
        p.add( meternum2);
        
        JLabel location1=new JLabel("Meter Location");
        location1.setBounds(100,120,100,20);
        p.add(location1);
        location2=new Choice();
        location2.add("Outside");
        location2.add("Inside");
        location2.setBounds(200,120,180,20);
        p.add(location2);
    
        JLabel type1=new JLabel("Meter Type");
        type1.setBounds(100,160,100,20);
        p.add(type1);
        type2=new Choice();
        type2.add("Smart Meter");
        type2.add("Digital Meter");
        type2.add("Prepaid Meter");
        type2.setBounds(200,160,180,20);
        p.add(type2);
        
        JLabel phase1=new JLabel("Phase code");
        phase1.setBounds(100,200,100,20);
        p.add(phase1);
        phase2=new Choice();
        phase2.add("011");
        phase2.add("022");
        phase2.add("033");
        phase2.add("044");
        phase2.add("055");
        phase2.add("066");
        phase2.add("077");
        phase2.add("088");
        phase2.add("099");
        phase2.setBounds(200,200,180,20);
        p.add(phase2);
        
        JLabel bill1type=new JLabel("Bill Type");
        bill1type.setBounds(100,240,100,20);
        p.add(bill1type);
        bill2=new Choice();
        bill2.add("Normal");
        bill2.add("Industrial");
        bill2.setBounds(200,240,180,20);
        p.add(bill2);
        
        JLabel days1=new JLabel("Days");
        days1.setBounds(100,280,100,20);
        p.add(days1);
        JLabel days2=new JLabel("30 Days");
        days2.setBounds(200,280,100,20);
        p.add(days2);    
        //Buttons
        b1=new JButton("Submit");
        b1.setBounds(220,340,100,25);
        b1.addActionListener(this);
        p.add(b1);
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String s1=meternum;
            String s2=location2.getSelectedItem();
            String s3=type2.getSelectedItem();
            String s4=phase2.getSelectedItem();
            String s5=bill2.getSelectedItem();
            String s6="30";
            String query="insert into meter_info values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')";
        try{
            Conn c=new Conn();
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Meter Information Added Successfully");
            setVisible(false);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        }
    else{
          setVisible(false);
           }
    }
    
    public static void main(String[] args) {
        new MeterInfo("");
    }
    
}
