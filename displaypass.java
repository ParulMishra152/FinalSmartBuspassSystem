import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class displaypass extends JFrame implements ActionListener
{
    JTextField cardiddis;
    JButton search,print,back;
    JTable table;
    displaypass()
    {
      super("view bus pass holders");
      setVisible(true);
      getContentPane().setBackground(Color.WHITE);
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      setLayout(null);

      JLabel cardid= new JLabel("Search by Card ID:");
      cardid.setBounds(150,10,180,30);
      cardid.setFont(new Font("SansSerif",Font.PLAIN,17));
      add(cardid);

      cardiddis= new JTextField();
      cardiddis.setBounds(350,10,120,30);
      cardiddis.setFont(new Font("SansSerif",Font.PLAIN,15));
      add(cardiddis);
 
      search=new JButton("Search");
      search.setBounds(600,10,120,30);
      search.setFont(new Font("Tahoma",Font.BOLD,17));
      search.addActionListener(this);
      add(search);

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
       ResultSet rs= c.s.executeQuery("select * from customer");
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
     if(ae.getSource()==search)
     {
      try
      {
        conn c= new conn();
        ResultSet rs=c.s.executeQuery("select * from customer where uidno ='"+cardiddis.getText()+"'");
        table.setModel(DbUtils.resultSetToTableModel(rs));
        cardiddis.setText(" ");
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
     }
     else if(ae.getSource()==print)
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
        new displaypass();
    }
}
