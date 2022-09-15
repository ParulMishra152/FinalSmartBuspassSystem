import javax.swing.*;
import javax.swing.border.*;
import java.util.*;


import java.awt.event.*;
import java.awt.*;



public class signup extends JFrame implements ActionListener
{  
   JButton back, create;
   Choice accounttype;
   JTextField entername,entermobileno,enteremail,enterusername,enterpassword;
   Long number;
   signup()
   {
      super("Sign up");
      getContentPane().setBackground(Color.WHITE);
      setBounds(0,0,1536,700);
      setVisible(true);
      setLayout(null);

      JLabel heading= new JLabel("Personal Details");
      heading.setForeground(new Color(242, 46, 118));
      heading.setBounds(420,0,900,100);
      heading.setFont(new Font("SansSerif",Font.BOLD,70));
      add(heading);

      JPanel panel= new JPanel();
      panel.setBounds(550,130,700,500);
      panel.setBorder(new TitledBorder(new LineBorder(new Color(219, 25, 11),3),"Create Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(219, 25, 11)));
      panel.setLayout(null);
      panel.setBackground(new Color(145, 211, 237));
      add(panel);

      ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("signup.png"));
      Image i2= i1.getImage().getScaledInstance(260,380, Image.SCALE_DEFAULT);
      ImageIcon i3= new ImageIcon(i2);
      JLabel image= new JLabel(i3);
      image.setBounds(400,70,260,380);
      panel.add(image);

      ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("sign.png"));
      Image i5= i4.getImage().getScaledInstance(500,450, Image.SCALE_DEFAULT);
      ImageIcon i6= new ImageIcon(i5);
      JLabel image1= new JLabel(i6);
      image1.setBounds(10,180,500,450);
      add(image1);

      Random ran=new Random();
      number= Math.abs(ran.nextLong() % 1000000);

      JLabel name= new JLabel("Name:");
      name.setFont(new Font("Tahoma", Font.BOLD,15));
      name.setForeground(Color.BLACK);
      name.setBounds(70,170,180,20);
      panel.add(name);
      entername= new JTextField();
      entername.setFont(new Font("Tahoma",Font.PLAIN,15));
      entername.setForeground(Color.BLACK);
      entername.setBounds(190,170,180,25);
      panel.add(entername);

      JLabel mobileno= new JLabel("Mobile no:");
      mobileno.setFont(new Font("Tahoma", Font.BOLD,15));
      mobileno.setForeground(Color.BLACK);
      mobileno.setBounds(70,220,180,20);
      panel.add(mobileno);
      entermobileno= new JTextField();
      entermobileno.setFont(new Font("Tahoma",Font.PLAIN,15));
      entermobileno.setForeground(Color.BLACK);
      entermobileno.setBounds(190,220,180,25);
      panel.add(entermobileno);

      JLabel email= new JLabel("Email ID");
      email.setFont(new Font("Tahoma", Font.BOLD,15));
      email.setForeground(Color.BLACK);
      email.setBounds(70,270,180,20);
      panel.add(email);
      enteremail= new JTextField();
      enteremail.setFont(new Font("Tahoma",Font.PLAIN,15));
      enteremail.setForeground(Color.BLACK);
      enteremail.setBounds(190,270,180,25);
      panel.add(enteremail);

      JLabel username= new JLabel("Username:");
      username.setFont(new Font("Tahoma", Font.BOLD,15));
      username.setForeground(Color.BLACK);
      username.setBounds(70,320,180,20);
      panel.add(username);
      enterusername= new JTextField();
      enterusername.setFont(new Font("Tahoma",Font.PLAIN,15));
      enterusername.setForeground(Color.BLACK);
      enterusername.setBounds(190,320,180,25);
      panel.add(enterusername);

      JLabel password= new JLabel("Password:");
      password.setFont(new Font("Tahoma", Font.BOLD,15));
      password.setForeground(Color.BLACK);
      password.setBounds(70,370,180,20);
      panel.add(password);
      enterpassword= new JTextField();
      enterpassword.setFont(new Font("Tahoma",Font.PLAIN,15));
      enterpassword.setForeground(Color.BLACK);
      enterpassword.setBounds(190,370,180,25);
      panel.add(enterpassword);


      create = new JButton("NEXT");
      create.setBackground(Color.BLACK);
      create.setBounds(250,430,100,25);
      create.setForeground(Color.WHITE);
      create.setFont(new Font("Tahoma", Font.BOLD,15));
      panel.add(create);
      create.addActionListener(this);

      back = new JButton("BACK");
      back.setBackground(Color.RED);
      back.setBounds(90,430,100,25);
      back.setForeground(Color.WHITE);
      back.setFont(new Font("Tahoma", Font.BOLD,15));
      panel.add(back);
      back.addActionListener(this);

   } 
   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==back)
       {
         setVisible(false);
         new login();
       }
       else if(ae.getSource()==create)
       { 
        if(entername.getText().isEmpty() || entermobileno.getText().isEmpty() || enteremail.getText().isEmpty() || enterusername.getText().isEmpty() || enterpassword.getText().isEmpty())
        {
          JOptionPane.showMessageDialog(null, "Please fill all the details");
        }
        else
        {
         String account="Bus Pass holder";
         String name= entername.getText();
         String mobileno=entermobileno.getText();
         String email=enteremail.getText();
         String username=enterusername.getText();
         String password=enterpassword.getText();
         String uid=number+"";
         String status="pending";
    
       try
       {
         conn c= new conn();      //establishing connection with conn class
         String query="insert into newuser values('"+uid+"','"+name+"','"+mobileno+"','"+email+"','"+username+"','"+password+"','"+account+"','"+status+"')";
         c.s.executeUpdate(query);

         setVisible(false);
         new newcustomer(uid);
        }
       catch(Exception e)
       {
        e.printStackTrace();
       }
       } 
      }
   }
   public static void main(String args[])
    {
      new signup();
    }

}

