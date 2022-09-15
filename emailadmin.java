import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class emailadmin 
{       
        
        public static void sendMail(String recepient) throws Exception
        {
            System.out.println("progress");
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.starttls.enable","true");
            String  myAccountEmail = "parulmishra367@gmail.com";
            String password = "Tiger@28";
            
            
            Session session = Session.getInstance(props,new Authenticator()
            {
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication(myAccountEmail, password);
                }
            });

            Message message = prepareMessage(session,myAccountEmail,recepient);
            Transport.send(message);
            System.out.println("success");
        
            
        }
   
        private static  Message prepareMessage(Session session,String myAccountEmail,String recepient)
         {
            try
            {
                Message message =new MimeMessage(session);
                message.setFrom(new InternetAddress(myAccountEmail));
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
                message.setSubject("New Application Received");
                message.setText("trail my check");

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return null;    
        
          }
        

          public static void main(String[] args) throws Exception {
            new emailadmin();
            sendMail("parulmishra367@gmail.com");
          }
        
}