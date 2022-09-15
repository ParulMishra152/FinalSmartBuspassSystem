import java.sql.*;


public class conn {
    Connection c;        //interface
    Statement s;
 conn()
{
  try
  {
    c=DriverManager.getConnection("jdbc:mysql://localhost:3306/sbps","root","blackleo");
    s=c.createStatement();
}
  catch(Exception e)
  {
    e.printStackTrace();
  }
   
}
}
