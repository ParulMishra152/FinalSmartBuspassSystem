import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;



public class newcustomer extends JFrame implements ActionListener
 {  JTextField customername,phoneno,nameofinstitution,dob,from,to;
    JTextArea address;
    Choice category,passduration;
    JButton submit, cancel;
    JLabel uidno;
    String uid;
    newcustomer(String uid)
    {  
       super("New Cutomer Login");
       this.uid=uid;
       setVisible(true);
       getContentPane().setBackground(Color.WHITE);
       setExtendedState(JFrame.MAXIMIZED_BOTH);
       setLayout(null);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("bus3.jpg"));
       Image i2=i1.getImage().getScaledInstance(550, 500, Image.SCALE_DEFAULT);
       ImageIcon i3= new ImageIcon(i2);
       JLabel image= new JLabel(i3);
       image.setBounds(10,180,550,500);
       add(image);

       JLabel heading= new JLabel("Trip Details");
       heading.setForeground(new Color(242, 46, 118));
       heading.setBounds(450,2,900,100);
       heading.setFont(new Font("SansSerif",Font.BOLD,70));
       add(heading);

       JPanel p= new JPanel();
       p.setBackground(new Color(145, 211, 237));
       p.setBounds(700,120,500,500);
       p.setLayout(null);
       add(p);

       JLabel catlbl= new JLabel("Category");
       catlbl.setForeground(Color.BLACK);
       catlbl.setBounds(50,60,80,20);
       catlbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(catlbl);
       category= new Choice();
       category.add("Student");
       category.add("Employee");
       category.add("Senior Citizen");
       category.setForeground(Color.BLACK);
       category.setBounds(240,60,200,25);
       category.setFont(new Font("SansSerif",Font.PLAIN,15));
       p.add(category);

       category.addItemListener(new ItemListener()
       {
        public void itemStateChanged(ItemEvent ie)
        {
          String usertype=category.getSelectedItem();
          if(usertype.equals("Senior Citizen"))
          {
            nameofinstitution.setEditable(false);
          }
          else
          {
            nameofinstitution.setEditable(true);
          }
        }
      });

       JLabel in= new JLabel("Name of Organisation");
       in.setForeground(Color.BLACK);
       in.setBounds(50,100,180,20);
       in.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(in);
       nameofinstitution=new JTextField();
       nameofinstitution.setForeground(Color.BLACK);
       nameofinstitution.setBounds(240,100,200,25);
       nameofinstitution.setFont(new Font("SansSerif",Font.PLAIN,15));
       p.add(nameofinstitution);

       JLabel doblbl= new JLabel("Date of Birth:");
       doblbl.setForeground(Color.BLACK);
       doblbl.setBounds(50,140,180,20);
       doblbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(doblbl);
       dob =new JTextField();
       dob.setForeground(Color.BLACK);
       dob.setBounds(240,140,200,25);
       dob.setFont(new Font("SansSerif",Font.PLAIN,15));
       p.add(dob);
       
       JLabel passduartionlbl= new JLabel("No. of trips required: ");
       passduartionlbl.setForeground(Color.BLACK);
       passduartionlbl.setBounds(50,180,180,20);
       passduartionlbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(passduartionlbl);
       passduration= new Choice();
       passduration.add("60");
       passduration.add("180");
       passduration.add("360");
       passduration.setForeground(Color.BLACK);
       passduration.setBounds(240,180,200,25);
       passduration.setFont(new Font("SansSerif",Font.PLAIN,15));
       p.add(passduration);

       JLabel fromlbl= new JLabel("Travel from: ");
       fromlbl.setForeground(Color.BLACK);
       fromlbl.setBounds(50,220,180,20);
       fromlbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(fromlbl);
       from =new JTextField();
       from.setForeground(Color.BLACK);
       from.setBounds(240,220,200,25);
       from.setFont(new Font("SansSerif",Font.PLAIN,15));
       p.add(from);

       JLabel tolbl= new JLabel("Travel to: ");
       tolbl.setForeground(Color.BLACK);
       tolbl.setBounds(50,260,180,20);
       tolbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(tolbl);
       to =new JTextField();
       to.setForeground(Color.BLACK);
       to.setBounds(240,260,200,25);
       to.setFont(new Font("SansSerif",Font.PLAIN,15));
       p.add(to);
       
       JLabel addlbl= new JLabel("Corresponding Address: ");
       addlbl.setForeground(Color.BLACK);
       addlbl.setBounds(50,300,180,20);
       addlbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(addlbl);
       address =new JTextArea();
       address .setForeground(Color.BLACK);
       address .setBounds(240,300,200,80);
       address .setFont(new Font("SansSerif",Font.PLAIN,15));
       p.add(address);

       cancel = new JButton("BACK");
       cancel.setForeground(Color.WHITE);
       cancel.setBackground(Color.RED);
       cancel.setBounds(80,440,100,30);
       cancel.setFont(new Font("SansSerif",Font.BOLD,15));
       cancel.addActionListener(this);
       p.add(cancel);

       submit = new JButton("Next");
       submit.setForeground(Color.WHITE);
       submit.setBackground(Color.BLACK);
       submit.setBounds(250,440,100,30);
       submit.setFont(new Font("SansSerif",Font.BOLD,15));
       submit.addActionListener(this);
       p.add(submit);

    }

  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==cancel)
    {
        setVisible(false);
        new signup();
    }
    if(ae.getSource()==submit)
    {   
      if( nameofinstitution.getText().isEmpty() || dob.getText().isEmpty() || from.getText().isEmpty() || to.getText().isEmpty() || address.getText().isEmpty())
      {
        JOptionPane.showMessageDialog(null, "Please fill all the details");
      }
      else
      { 
        
        String institutionname=nameofinstitution.getText();
        String doblbl=dob.getText();
        String passdurationname=passduration.getSelectedItem();
        String frompoint=from.getText();
        String topoint= to.getText();
        String caddress=address.getText();
        String atype=category.getSelectedItem();
        String customeridno=uid;
        String status="pending";
        
        String query1= "insert into customer values('"+institutionname+"','"+doblbl+"','"+passdurationname+"','"+frompoint+"','"+topoint+"','"+caddress+"','"+atype+"','"+customeridno+"','"+" "+"','"+ " "+"','"+status+"')";
        
        try
        {
          conn c=new conn(); 
          c.s.executeUpdate(query1); 
          setVisible(false);
          new payment(customeridno,passdurationname);
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
        new newcustomer("");
    }
}
