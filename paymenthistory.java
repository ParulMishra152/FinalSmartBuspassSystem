import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class paymenthistory extends JFrame implements ActionListener
{
    
    JButton print,back;
    JTable table;
    String id;
    paymenthistory(String id)
    {
      super("View Payment history");
      this.id=id;
      setVisible(true);
      getContentPane().setBackground(Color.WHITE);
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      setLayout(null);

      print=new JButton("Print");
      print.setBounds(750,10,120,30);
      print.setFont(new Font("Tahoma",Font.BOLD,17));
      print.addActionListener(this);
      add(print);

      back=new JButton("Back");
      back.setBounds(1200,10,120,30);
      back.setFont(new Font("Tahoma",Font.BOLD,17));
      back.addActionListener(this);
      add(back);

      table = new JTable();
      table.setBounds(150,100,1000,800);
      table.setFont(new Font("Tahoma",Font.PLAIN,15));

      try
      {
       conn c = new conn();
       ResultSet rs= c.s.executeQuery("select PaymentDate,frompoint,topoint,passduration,payment from customer where uidno='"+id+"'");
       table.setModel(DbUtils.resultSetToTableModel(rs));
      }
      catch(Exception e)
      {
       e.printStackTrace();
      }

     JScrollPane sp= new JScrollPane(table);
     sp.setBounds(0,100,1400,800);
     add(sp);


    }

   public void actionPerformed(ActionEvent ae)
   {
      if(ae.getSource()==print)
     {
      try
      {
        table.print();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
     }
     else if(ae.getSource()==back)
     {
      setVisible(false);
      
     }
   }
  public static void main(String[] args)
    {
        new paymenthistory("");
    }
}
