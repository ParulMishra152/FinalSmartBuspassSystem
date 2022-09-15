import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;


public class editprofie extends JFrame implements ActionListener
{
    JTextField customername,phoneno,nameofinstitution,mob,emails,eusername,epassword,from,to;
    JTextArea eaddressArea;
    Choice category,passduration;
    JButton submit, cancel;
    JLabel uidno;
    String uid;
    editprofie(String uid)
    {  
       super("New Cutomer Login");
       this.uid=uid;
       setVisible(true);
       getContentPane().setBackground(Color.WHITE);
       setExtendedState(JFrame.MAXIMIZED_BOTH);
       setLayout(null);
       
       
       JLabel heading= new JLabel("Edit Profile");
       heading.setForeground(new Color(242, 46, 118));
       heading.setBounds(490,2,900,100);
       heading.setFont(new Font("SansSerif",Font.BOLD,70));
       add(heading);

       JPanel p= new JPanel();
       p.setBackground(new Color(145, 211, 237));
       p.setBounds(130,130,1100,500);
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
       in.setBounds(50,120,180,20);
       in.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(in);
       nameofinstitution=new JTextField();
       nameofinstitution.setForeground(Color.BLACK);
       nameofinstitution.setBounds(240,120,200,25);
       nameofinstitution.setFont(new Font("SansSerif",Font.PLAIN,15));
       p.add(nameofinstitution);

       JLabel moblbl= new JLabel("Mobile Number:");
       moblbl.setForeground(Color.BLACK);
       moblbl.setBounds(50,180,180,20);
       moblbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(moblbl);
       mob =new JTextField();
       mob.setForeground(Color.BLACK);
       mob.setBounds(240,180,200,25);
       mob.setFont(new Font("SansSerif",Font.PLAIN,15));
       p.add(mob);
       
       JLabel emaillbl= new JLabel("Email Address: ");
       emaillbl.setForeground(Color.BLACK);
       emaillbl.setBounds(50,240,180,20);
       emaillbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(emaillbl);
       emails =new JTextField();
       emails.setForeground(Color.BLACK);
       emails.setBounds(240,240,200,25);
       emails.setFont(new Font("SansSerif",Font.PLAIN,15));
       p.add(emails);

       JLabel userlbl= new JLabel("Username: ");
       userlbl.setForeground(Color.BLACK);
       userlbl.setBounds(50,300,180,20);
       userlbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(userlbl);
       eusername =new JTextField();
       eusername.setForeground(Color.BLACK);
       eusername.setBounds(240,300,200,25);
       eusername.setFont(new Font("SansSerif",Font.PLAIN,15));
       p.add(eusername);

       JLabel passlbl= new JLabel("Password: ");
       passlbl.setForeground(Color.BLACK);
       passlbl.setBounds(590,60,180,20);
       passlbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(passlbl);
       epassword=new JTextField();
       epassword.setForeground(Color.BLACK);
       epassword.setBounds(780,60,200,25);
       epassword.setFont(new Font("SansSerif",Font.PLAIN,15));
       p.add(epassword);

       JLabel fromlbl= new JLabel("Travel from: ");
       fromlbl.setForeground(Color.BLACK);
       fromlbl.setBounds(590,120,180,20);
       fromlbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(fromlbl);
       from =new JTextField();
       from.setForeground(Color.BLACK);
       from.setBounds(780,120,200,25);
       from.setFont(new Font("SansSerif",Font.PLAIN,15));
       p.add(from);

       JLabel tolbl= new JLabel("Travel to: ");
       tolbl.setForeground(Color.BLACK);
       tolbl.setBounds(590,180,180,20);
       tolbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(tolbl);
       to =new JTextField();
       to.setForeground(Color.BLACK);
       to.setBounds(780,180,200,25);
       to.setFont(new Font("SansSerif",Font.PLAIN,15));
       p.add(to);
       
       JLabel addlbl= new JLabel("Corresponding Address: ");
       addlbl.setForeground(Color.BLACK);
       addlbl.setBounds(590,240,180,20);
       addlbl.setFont(new Font("SansSerif",Font.BOLD,15));
       p.add(addlbl);
       eaddressArea=new JTextArea();
       eaddressArea.setForeground(Color.BLACK);
       eaddressArea.setBounds(780,240,200,100);
       eaddressArea.setFont(new Font("SansSerif",Font.PLAIN,15));
       p.add(eaddressArea);

       try
       {
        String userID=uid;
        conn c = new conn();
        ResultSet rs= c.s.executeQuery("select customer.institutionname,customer.frompoint,customer.topoint,customer.address, newuser.mobileno,newuser.email,newuser.username,newuser.password from customer INNER JOIN newuser where customer.uidno=newuser.uidno and customer.uidno='"+userID+"'");
        while(rs.next())
        {
          nameofinstitution.setText(rs.getString("institutionname"));
          from.setText(rs.getString("frompoint"));
          to.setText(rs.getString("topoint"));
          eaddressArea.setText(rs.getString("address"));
          mob.setText(rs.getString("mobileno"));
          emails.setText(rs.getString("email"));
          eusername.setText(rs.getString("username"));
          epassword.setText(rs.getString("password"));
       
        }
      }
      catch(Exception e)
       {
        e.printStackTrace();
       }

      
         
       cancel = new JButton("BACK");
       cancel.setForeground(Color.WHITE);
       cancel.setBackground(Color.RED);
       cancel.setBounds(380,440,100,30);
       cancel.setFont(new Font("SansSerif",Font.BOLD,15));
       cancel.addActionListener(this);
       p.add(cancel);

       submit = new JButton("UPDATE");
       submit.setForeground(Color.WHITE);
       submit.setBackground(Color.BLACK);
       submit.setBounds(550,440,100,30);
       submit.setFont(new Font("SansSerif",Font.BOLD,15));
       submit.addActionListener(this);
       p.add(submit);

    }

  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==cancel)
    {
        setVisible(false);
        
    }
    if(ae.getSource()==submit)
    {   
      if(customername.getText().isEmpty()|| phoneno.getText().isEmpty()|| nameofinstitution.getText().isEmpty()|| mob.getText().isEmpty()|| emails.getText().isEmpty()|| eusername.getText().isEmpty()|| epassword.getText().isEmpty()|| from.getText().isEmpty()|| to.getText().isEmpty() || eaddressArea.getText().isEmpty())
       { 
          JOptionPane.showMessageDialog(null, "Please fill all the details");
        }
        else
        {
          String Insname=nameofinstitution.getText();
          String emailid=emails.getText();
          String usr=eusername.getText();
          String pswd=epassword.getText();
          String fpoint=from.getText();
          String tpoint= to.getText();
          String caddress=eaddressArea.getText();
          String atype=category.getSelectedItem();
          String mobno=mob.getText();
          String CID=uid;

        try
        {
          conn c=new conn(); 
          c.s.executeUpdate("update customer c,newuser n SET c.institutionname ='"+Insname+"', c.frompoint ='"+fpoint+"', c.topoint ='"+tpoint+"',c.address ='"+caddress+"',c.accouttype ='"+atype+"', n.email ='"+emailid+"', n.mobileno ='"+mobno+"',n.username ='"+usr+"',n.password ='"+pswd+"' where c.uidno = n.uidno and c.uidno='"+CID+"'"); 
          JOptionPane.showMessageDialog(null, "Details have been updated successfully");
          setVisible(false);
          setVisible(false);
        }
         
       
       catch(Exception ep)
       {
          ep.printStackTrace();
       }
      }
    }  
  }

  public static void main(String[] args)
  {
     new editprofie("");
  }
}





