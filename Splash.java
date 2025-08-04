
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;


public class Splash extends JFrame implements Runnable { 
        Thread t;
        Splash(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/image3.jpg"));
        
        Image i2=i1.getImage().getScaledInstance(768,432,Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        JLabel image1=new JLabel(i3);
        add(image1);
        
        setVisible(true);
        int x=1;
        for(int i=2;i<=462;i+=4,x+=1){
            setSize(i+x,i);
            setLocation(700-((i+x)/2),400-(i/2));
            try{
                Thread.sleep(3);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        t=new Thread(this);
        t.start();
        setVisible(true);
       
    }
        public void run(){ 
            try{
                Thread.sleep(5000);
                setVisible(false);
                new Login();
            }catch(Exception e){
            }
        }
    
    public static void main(String[] args) {
        new Splash();
    }
    
}


