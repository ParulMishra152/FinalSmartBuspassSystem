import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;


public class pendingrequest extends JFrame   {
    JLabel Cardid,heading; 
    JButton View;
    JTable uids;
    
    
    
    pendingrequest()
    { 
      super("Pending Passes");
      setVisible(true);
      getContentPane().setBackground(Color.WHITE);
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      setLayout(null);

      heading= new JLabel("Pending requests");
      heading.setBounds(400,2,900,100);
      heading.setForeground(new Color(242, 46, 118));
      heading.setFont(new Font("SansSerif",Font.BOLD,70));
      add(heading);

      Border blackline = BorderFactory.createLineBorder(Color.black);

      Cardid = new JLabel("Card ID",JLabel.CENTER);
      Cardid.setBounds(300,150,800,20);
      Cardid.setOpaque(true);
      Cardid.setBackground(new Color(145, 211, 237));
      Cardid.setForeground(Color.BLACK);
      Cardid.setFont(new Font("Tahoma",Font.PLAIN,15));
      Cardid.setBorder(blackline);
      add(Cardid);

      
      uids = new JTable();
      uids.setBackground(new Color(145, 211, 237));
      uids.setForeground(Color.BLACK);
      uids.setFont(new Font("Tahoma",Font.PLAIN,15));
      uids.setBounds(300,170,800,800);
      add(uids);
      uids.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int row = uids.rowAtPoint(evt.getPoint());
            new individualdetaildisplay();
           
        }
    });

      try
      {
        conn c= new conn();
        ResultSet rs=c.s.executeQuery("select uidno from customer where status='pending' ");
        uids.setModel(DbUtils.resultSetToTableModel(rs));
      }
      catch(Exception e)
      {
       e.printStackTrace();
      }
      
      JScrollPane b= new JScrollPane();
      b.setBounds(300,170,800,800);
      add(b);

}

    public static void main(String[] args)
    {
        new pendingrequest();
    }

    
}
