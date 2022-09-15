import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Choice;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;


public class login extends JFrame implements ActionListener{
    JButton login, cancel, signup;
    JTextField enterusrname,enterpassword;
    Choice logging;
    JTextField uid;
    String name;
    login()
    {   
        super("Login Page");
        getContentPane().setBackground(Color.BLACK);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new FlowLayout());
        setVisible(true);
       

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("internal.jpg"));
        Image i2= i1.getImage().getScaledInstance(1536, 800, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        add(image);
        image.setLayout(null);
        //image.setBounds(0,0,1536,700);

        JLabel heading= new JLabel("Welcome Back!");
        heading.setBounds(500,5,900,80);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("SansSerif",Font.BOLD,70));
        image.add(heading);

        JLabel logginginas= new JLabel("Logging in as: ");
        logginginas.setBounds(570,150,120,30);
        logginginas.setForeground(Color.WHITE);
        logginginas.setFont(new Font("SansSerif",Font.BOLD,17));
        image.add(logginginas);
        logging = new Choice();
        logging.add("Bus Pass Holder");
        logging.add("Admin");
        logging.setBounds(690,150,180,30);
        logging.setFont(new Font("SansSerif",Font.BOLD,17));
        image.add(logging);

        JLabel usrname= new JLabel("Username: ");
        usrname.setBounds(570,210,100,30); 
        usrname.setForeground(Color.WHITE);
        usrname.setFont(new Font("SansSerif",Font.BOLD,17));
        image.add(usrname);
        enterusrname=new JTextField();
        enterusrname.setBounds(690,210,180,30);
        enterusrname.setFont(new Font("SansSerif",Font.BOLD,17));
        image.add(enterusrname);

        JLabel password= new JLabel("Password: ");
        password.setBounds(570,270,100,30); 
        password.setForeground(Color.WHITE);
        password.setFont(new Font("SansSerif",Font.BOLD,17));
        image.add(password);
        enterpassword=new JTextField();
        enterpassword.setBounds(690,270,180,30);
        enterpassword.setFont(new Font("SansSerif",Font.BOLD,17));
        image.add(enterpassword);

        JLabel luid= new JLabel("UID: ");
        luid.setBounds(570,330,100,30); 
        luid.setForeground(Color.WHITE);
        luid.setFont(new Font("SansSerif",Font.BOLD,17));
        image.add(luid);
        uid= new JTextField("");
        uid.setBounds(690,330,180,30); 
        uid.setForeground(Color.BLACK);
        uid.setFont(new Font("SansSerif",Font.BOLD,17));
        uid.setEditable(false);
        image.add(uid);
        
        logging.addItemListener(new ItemListener()
       {
        public void itemStateChanged(ItemEvent ie)
        {
          String usertype=logging.getSelectedItem();
          if(usertype.equals("Admin"))
          {
             uid.setVisible(false);
             luid.setVisible(false);
          }
          else
          {
            uid.setVisible(true);
            luid.setVisible(true);
          }
        }
      }); 

        enterpassword.addFocusListener(new FocusListener()
        {
          public void focusGained(FocusEvent fe)
          {

          }
          public void focusLost(FocusEvent fe)
          {
            try
            {
              conn c = new conn();
              ResultSet rs=c.s.executeQuery("select * from newuser where username='"+enterusrname.getText()+"' and password='"+enterpassword.getText()+"'");
              while(rs.next())
              {
                uid.setText(rs.getString("uidno"));
                name=rs.getString("name");
              }
            }
            catch(Exception e)
            {
              e.printStackTrace();
            }
          }
          
        });
    
        login= new JButton("Login");
        login.setBounds(720,410,100,30);
        image.add(login);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("SansSerif",Font.BOLD,17));
        login.addActionListener(this);

        cancel= new JButton("Cancel");
        cancel.setBounds(600,410,100,30);
        image.add(cancel);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("SansSerif",Font.BOLD,17));
        cancel.addActionListener(this);
        
        JLabel newuser = new JLabel("Don't have a Smart Bus Pass?");
        newuser.setBounds(500,510,2500,30);
        newuser.setFont(new Font("SansSerif",Font.BOLD,17));
        newuser.setForeground(Color.BLACK);
        image.add(newuser);
        signup= new JButton("Apply Now!");
        signup.setBounds(770,510,180,30);
        signup.setBackground(Color.BLUE);
        signup.setForeground(Color.WHITE);
        signup.setFont(new Font("SansSerif",Font.BOLD,17));
        image.add(signup);
        signup.addActionListener(this);

    
    }

    public void actionPerformed(ActionEvent ae)
     { 
       if(ae.getSource()== login)
       {
        if(enterusrname.getText().isEmpty() || enterpassword.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(null, "Please fill all the details");
        }
        else
        {
          String usr= enterusrname.getText();
         String pass= enterpassword.getText();
         String loggedinas= logging.getSelectedItem();
         String userID=uid.getText();

         try
         {
           conn c= new conn();
           String query = "select * from newuser where username ='"+usr+"' and password ='"+pass+"' and atype ='"+loggedinas+"' ";
           ResultSet rs=c.s.executeQuery(query);
           

           if (rs.next())
           {
            setVisible(false);
            new afterlogin(loggedinas,userID,name);
           }
           else
           {
            JOptionPane.showMessageDialog(null, "Invalid credentials, either username or password is wrong");
             enterusrname.setText(" ");
             enterpassword.setText(" ");
           }
         }
         catch(Exception e)
         {
          e.printStackTrace();
         }
        }
       }
       
       else if(ae.getSource()==signup)
       {
         setVisible(false);
         new signup();
       }
       else if(ae.getSource()==cancel)
       {
         setVisible(false);
        
       }
     }
    public static void main(String args[]) 
    {
      new login();
        
    }
}

