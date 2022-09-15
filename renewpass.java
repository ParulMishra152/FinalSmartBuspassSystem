import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import  java.sql.Date;


public class renewpass extends JFrame implements ActionListener
 {  
    
    JButton makepayment, back;
    JLabel uid,tpayment,Uname;
    Choice passduration;
    int amount;
    String cardno,nooftrips;
    Date date;
    String name;
    JTextField from,to;
    renewpass(String cardno,String name)
    {  
       super("Renew Smart Bus Pass");
       this.cardno=cardno;
       this.name=name;
       setVisible(true);
       getContentPane().setBackground(Color.WHITE);
       setExtendedState(JFrame.MAXIMIZED_BOTH);
       setLayout(null);
       
       JLabel heading= new JLabel("Renew Smart Bus Pass");
       heading.setForeground(new Color(242, 46, 118));
       heading.setBounds(320,2,900,100);
       heading.setFont(new Font("SansSerif",Font.BOLD,70));
       add(heading);

       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("payment2.png"));
       Image i2=i1.getImage().getScaledInstance(470, 500, Image.SCALE_DEFAULT);
       ImageIcon i3= new ImageIcon(i2);
       JLabel image= new JLabel(i3);
       image.setBounds(70,180,470,500);
       add(image);

       JPanel p= new JPanel();
       p.setBackground(new Color(145, 211, 237));
       p.setBounds(650,250,550,370);
       p.setLayout(null);
       add(p);

       JLabel luid = new JLabel("UID :");
       luid.setBounds(20,10,80,20);
       luid.setForeground(Color.BLACK);
       luid.setFont(new Font("SansSerif",Font.BOLD,17));
       p.add(luid);
       uid= new JLabel(cardno);
       uid.setBounds(190,10,80,20);
       uid.setForeground(Color.BLACK);
       uid.setFont(new Font("SansSerif",Font.BOLD,17));
       p.add(uid);

      JLabel lname = new JLabel("Name :");
      lname.setBounds(20,60,160,20);
      lname.setForeground(Color.BLACK);
      lname.setFont(new Font("SansSerif",Font.BOLD,17));
      p.add(lname);
      Uname = new JLabel(name);
      Uname.setBounds(190,60,160,20);
      Uname.setForeground(Color.BLACK);
      Uname.setFont(new Font("SansSerif",Font.BOLD,17));
      p.add(Uname);


       JLabel fromlbl= new JLabel("Travel from: ");
       fromlbl.setForeground(Color.BLACK);
       fromlbl.setBounds(20,110,180,20);
       fromlbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(fromlbl);
       from =new JTextField();
       from.setForeground(Color.BLACK);
       from.setBounds(190,110,200,25);
       from.setFont(new Font("SansSerif",Font.PLAIN,15));
       p.add(from);

       JLabel tolbl= new JLabel("Travel to: ");
       tolbl.setForeground(Color.BLACK);
       tolbl.setBounds(20,160,180,20);
       tolbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(tolbl);
       to =new JTextField();
       to.setForeground(Color.BLACK);
       to.setBounds(190,160,200,25);
       to.setFont(new Font("SansSerif",Font.PLAIN,15));
       p.add(to);

       long millis=System.currentTimeMillis(); 
       date = new java.sql.Date(millis);
       
       JLabel tpaymentlbl= new JLabel("Total Payment: ");
       tpaymentlbl.setForeground(Color.BLACK);
       tpaymentlbl.setBounds(20,260,180,20);
       tpaymentlbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(tpaymentlbl);

       tpayment= new JLabel();
       tpayment.setBounds(290,260,80,20);
       tpayment.setForeground(Color.BLACK);
       tpayment.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(tpayment);

       
       JLabel passduartionlbl= new JLabel("Pass Duration: ");
       passduartionlbl.setForeground(Color.BLACK);
       passduartionlbl.setBounds(20,210,150,20);
       passduartionlbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(passduartionlbl);
       passduration= new Choice();
       passduration.add("60");
       passduration.add("180");
       passduration.add("360");
       passduration.setForeground(Color.BLACK);
       passduration.setBounds(190,210,200,25);
       passduration.setFont(new Font("SansSerif",Font.PLAIN,15));
       p.add(passduration);
       passduration.addItemListener(new ItemListener()
       {
         public void itemStateChanged(ItemEvent ie)
         {
            nooftrips=passduration.getSelectedItem();
            int trip=Integer.parseInt(nooftrips);
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
            tpayment.setText(""+amount);
            
         }
       });
      
       back = new JButton("Back");
       back.setForeground(Color.WHITE);
       back.setBackground(Color.RED);
       back.setBounds(110,310,100,30);
       back.setFont(new Font("SansSerif",Font.BOLD,15));
       back.addActionListener(this);
       p.add(back);

       makepayment = new JButton("Make Payment");
       makepayment.setForeground(Color.WHITE);
       makepayment.setBackground(Color.BLACK);
       makepayment.setBounds(250,310,150,30);
       makepayment.setFont(new Font("SansSerif",Font.BOLD,15));
       makepayment.addActionListener(this);
       p.add(makepayment);

    }

  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==back)
    {
        setVisible(false);
       
    }
    if(ae.getSource()==makepayment)
    {   
      if(from.getText().isEmpty() || to.getText().isEmpty())
      {
        JOptionPane.showMessageDialog(null, "Please fill all the details");
      }
      else
      { 
       String amnt= tpayment.getText();
       String id=cardno;
       Date d=date;
       String frompoint=from.getText();
       String topoint=to.getText();
       String duration=passduration.getSelectedItem();

        try
        {
          conn c=new conn(); 
          String query1= "update customer set passduration ='"+duration+"',frompoint = '"+frompoint+"',topoint ='"+topoint+"',PaymentDate ='"+d+"',payment ='"+amnt+"' where uidno ='"+id+"'";
          c.s.executeUpdate(query1);
          JOptionPane.showMessageDialog(null, "Smart Bus Passn has been renewed successfully.");
          setVisible(false);
          new paytm();  
        }
       catch(Exception e)
       {
          e.printStackTrace();
          
       }
         
       }
      }
  }

    public static void main(String[] args)
    {
        new renewpass("","");
    }
}
