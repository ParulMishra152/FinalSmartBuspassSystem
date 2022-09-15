import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;



public  class paytm  extends JFrame implements ActionListener {
    JButton back;
    paytm()
    {   
        super("Make Payment");
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JEditorPane j= new JEditorPane();
        j.setEditable(false);
        try
        {
         j.setPage("https://paytm.com/recharge");
        }
        catch(Exception e)
        {
           j.setContentType("text/html");
           j.setText("<html>Could not load the page</html>");
        }

        JScrollPane pane=new JScrollPane(j);
        add(pane);

        back= new JButton("Back");
        back.setBackground(new Color(6,61,250));
        back.setForeground(Color.WHITE);
        back.setFont(new Font(Font.SANS_SERIF,Font.BOLD,18));
        back.setBounds(1200,20,100,25);
        j.add(back);
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
        new paytm();
    }
}
