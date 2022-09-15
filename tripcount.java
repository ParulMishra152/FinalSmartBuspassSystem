import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class tripcount extends JFrame implements ActionListener
{
    JLabel name,tfrom,tto,ntrips,uid;
    String id,totalnooftrips;
    JButton back;
    int tduration;
    tripcount(String id)
    {
      this.id=id;  
      setVisible(true);
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);

      JLabel heading = new JLabel("Trip Details");
      heading.setBounds(520,2,900,100);
      heading.setForeground(new Color(242, 46, 118));
      heading.setFont(new Font("SansSerif",Font.BOLD,70));
      add(heading);

      ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("pass.png"));
      Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
      ImageIcon i3= new ImageIcon(i2);
      JLabel image= new JLabel(i3);
      image.setBounds(30,250,500,300);
      add(image);
      

      JPanel p= new JPanel();
      p.setBounds(680,250,500,250);
      p.setBackground(new Color(145, 211, 237));
      p.setLayout(null);
      add(p);
      
      JLabel luid = new JLabel("UID :");
      luid.setBounds(20,10,80,20);
      luid.setForeground(Color.BLACK);
      luid.setFont(new Font("SansSerif",Font.BOLD,17));
      p.add(luid);
      uid= new JLabel("");
      uid.setBounds(190,10,80,20);
      uid.setForeground(Color.BLACK);
      uid.setFont(new Font("SansSerif",Font.BOLD,17));
      p.add(uid);

      JLabel lname = new JLabel("Name :");
      lname.setBounds(20,60,160,20);
      lname.setForeground(Color.BLACK);
      lname.setFont(new Font("SansSerif",Font.BOLD,17));
      p.add(lname);
      name = new JLabel("");
      name.setBounds(190,60,160,20);
      name.setForeground(Color.BLACK);
      name.setFont(new Font("SansSerif",Font.BOLD,17));
      p.add(name);

      JLabel lfrom = new JLabel("Traveling From :");
      lfrom.setBounds(20,110,160,20);
      lfrom.setForeground(Color.BLACK);
      lfrom.setFont(new Font("SansSerif",Font.BOLD,17));
      p.add(lfrom);
      tfrom = new JLabel("");
      tfrom.setBounds(190,110,160,20);
      tfrom.setForeground(Color.BLACK);
      tfrom.setFont(new Font("SansSerif",Font.BOLD,17));
      p.add(tfrom);

      JLabel lto = new JLabel("Travelling To :");
      lto.setBounds(20,160,160,20);
      lto.setForeground(Color.BLACK);
      lto.setFont(new Font("SansSerif",Font.BOLD,17));
      p.add(lto);
      tto = new JLabel("");
      tto.setBounds(190,160,160,20);
      tto.setForeground(Color.BLACK);
      tto.setFont(new Font("SansSerif",Font.BOLD,17));
      p.add(tto);

      JLabel ltrips = new JLabel("No of Trips :");
      ltrips.setBounds(20,210,160,20);
      ltrips.setForeground(Color.BLACK);
      ltrips.setFont(new Font("SansSerif",Font.BOLD,17));
      p.add(ltrips);
      ntrips = new JLabel("");
      ntrips.setBounds(190,210,160,20);
      ntrips.setForeground(Color.BLACK);
      ntrips.setFont(new Font("SansSerif",Font.BOLD,17));
      p.add(ntrips);

      try
      { 
        String userid=id; 
        conn c= new conn();
        ResultSet rs= c.s.executeQuery("select customer.uidno, customer.frompoint, customer.topoint,customer.passduration,newuser.name from customer  INNER JOIN newuser on newuser.uidno = customer.uidno and customer.uidno='"+userid+"'");
        while(rs.next())
        {   
            totalnooftrips=rs.getString("passduration");
            tduration=Integer.parseInt(totalnooftrips);
            tduration=tduration-1;
            name.setText(rs.getString("name"));
            tfrom.setText(rs.getString("frompoint"));
            tto.setText(rs.getString("topoint"));
            ntrips.setText(""+tduration);
            uid.setText(rs.getString("uidno"));
        }
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }

       back= new JButton("Back");
       back.setBackground(new Color(6,61,250));
       back.setForeground(Color.WHITE);
       back.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
       back.setBounds(1200,90,100,25);
       add(back);
       back.addActionListener(this);
 
    }

    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource()==back)
      {
        setVisible(false);
        
      }
    }
     
       
public static void main(String[] args)
{
  new tripcount("");  
}
}

