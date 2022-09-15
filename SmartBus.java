import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.*;


class SmartBus extends JFrame implements ActionListener
{
    SmartBus()                      //Constructor to open the first frame immediately
    { 
       super("Mian Page");
       setExtendedState(JFrame.MAXIMIZED_BOTH);
       setLayout(new FlowLayout());
       setVisible(true);

       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("sixth.jpg"));
       Image i2= i1.getImage().getScaledInstance(1500,800,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image= new JLabel(i3);
       add(image);
       
    
       JLabel text= new JLabel("Smart Bus Pass System");
       image.add(text);
       text.setBounds(60,10,1000,100);
       text.setFont(new Font("serif",Font.BOLD,100));
       text.setForeground(new Color(219, 25, 11));

       JButton next= new JButton("Next");
       image.add(next);
       next.setBounds(1320,30,70,30);
       next.setFont(new Font("serif",Font.BOLD,18));
       next.setForeground(Color.WHITE);
       Color btnbgcolor= new Color(236, 10, 7);
       next.setBackground(btnbgcolor);
       next.addActionListener(this);

       while(true)
       {
          text.setVisible(false);
          try
          {
            Thread.sleep(1000);
          }
          catch(Exception e)
          {
            e.printStackTrace();
          }
          text.setVisible(true);

          try
          {
            Thread.sleep(1000);
          }
          catch(Exception e)
          {
            e.printStackTrace();
          }  
          text.setVisible(true);
       }
    }

public  void actionPerformed(ActionEvent ae)
{
  setVisible(false);
  new login();
}


public static void main(String args[])
{
    new SmartBus();                 //Object name
}
   
}