import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import  java.sql.Date;


public class payment extends JFrame implements ActionListener
 {  
    
    JButton makepayment, back;
    JLabel uidno,passduration,tpayment;
    int amount;
    String cardno;
    Date date;
    payment(String cardno,String nooftrips)
    {  
       super("Make Payment");
       this.cardno=cardno;
       setVisible(true);
       getContentPane().setBackground(Color.WHITE);
       setExtendedState(JFrame.MAXIMIZED_BOTH);
       setLayout(null);
       
       JLabel heading= new JLabel("Make Payment");
       heading.setForeground(new Color(242, 46, 118));
       heading.setBounds(420,2,900,100);
       heading.setFont(new Font("SansSerif",Font.BOLD,70));
       add(heading);

       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("payment2.png"));
       Image i2=i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
       ImageIcon i3= new ImageIcon(i2);
       JLabel image= new JLabel(i3);
       image.setBounds(150,180,500,500);
       add(image);



       JPanel p= new JPanel();
       p.setBackground(new Color(145, 211, 237));
       p.setBounds(700,250,600,300);
       p.setLayout(null);
       add(p);

       long millis=System.currentTimeMillis(); 
       date = new java.sql.Date(millis); 
       
       JLabel passduartionlbl= new JLabel("Pass Duration: ");
       passduartionlbl.setForeground(Color.BLACK);
       passduartionlbl.setBounds(180,90,180,20);
       passduartionlbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(passduartionlbl);
       passduration= new JLabel(nooftrips);
       passduration.setBounds(350,90,70,20);
       passduration.setForeground(Color.BLACK);
       passduration.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(passduration);

       int trip=Integer.parseInt(nooftrips);
       

       JLabel tpaymentlbl= new JLabel("Total Payment: ");
       tpaymentlbl.setForeground(Color.BLACK);
       tpaymentlbl.setBounds(180,130,180,20);
       tpaymentlbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(tpaymentlbl);

       if(trip==60)
       {
        amount=60*16;
       }
       else if(trip==180)
       {
        amount=120*16;
       }
       else if(trip==360)
       {
        amount=360*16;
       }
       tpayment= new JLabel();
       tpayment.setBounds(350,130,80,20);
       tpayment.setForeground(Color.BLACK);
       tpayment.setFont(new Font("SansSerif",Font.BOLD,15));
       tpayment.setText(""+amount);
       p.add(tpayment);

      
       
       back = new JButton("Back");
       back.setForeground(Color.WHITE);
       back.setBackground(Color.RED);
       back.setBounds(150,200,100,30);
       back.setFont(new Font("SansSerif",Font.BOLD,15));
       back.addActionListener(this);
       p.add(back);

       makepayment = new JButton("Make Payment");
       makepayment.setForeground(Color.WHITE);
       makepayment.setBackground(Color.BLACK);
       makepayment.setBounds(290,200,150,30);
       makepayment.setFont(new Font("SansSerif",Font.BOLD,15));
       makepayment.addActionListener(this);
       p.add(makepayment);

    }

  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==back)
    {
        setVisible(false);
        new newcustomer("");
    }
    if(ae.getSource()==makepayment)
    {   
        
       String amnt= tpayment.getText();
       String id=cardno;
       Date d=date;

        try
        {
          conn c=new conn(); 
          String query1= "update customer set payment ='"+amnt+"',PaymentDate ='"+d+"' where uidno ='"+id+"'";
          c.s.executeUpdate(query1);
          new emailadmin();
          new paytm();
          JOptionPane.showMessageDialog(null, "Application has been submitted successfully. Your pass will be generated once the deatils are verified");
          setVisible(false);
          
        }
       catch(Exception e)
       {
          e.printStackTrace();
          
       }
         
       }
  }

    public static void main(String[] args)
    {
        new payment("","");
    }
}
