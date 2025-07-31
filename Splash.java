
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;//for Image class


public class Splash extends JFrame implements Runnable { //swing class Jframe //Runnable interface
        Thread t;
        Splash(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/image3.jpg"));
        //to scale image
        Image i2=i1.getImage().getScaledInstance(768,432,Image.SCALE_DEFAULT); 
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        setVisible(true);//To visible the frame
        int x=1;
        for(int i=2;i<=462;i+=4,x+=1){
            setSize(i+x,i);//swing FrameSize
            setLocation(700-((i+x)/2),400-(i/2));
            try{
                Thread.sleep(3);//
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        t=new Thread(this);
        t.start(); //start method internally call run method
        setVisible(true);
       
    }
        public void run(){ //Runnable interface abstract method override
            try{
                Thread.sleep(5000); //6s 
                setVisible(false);
            }catch(Exception e){
            }
        }
    
    public static void main(String[] args) {
        new Splash();//anonymous object
    }
    
}
