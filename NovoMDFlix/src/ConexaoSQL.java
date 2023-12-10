import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ConexaoSQL {

   public static Connection getCon(){
       
       try{
           
           Class.forName("com.mysql.cj.jdbc.Driver");
           java.sql.Connection conec = DriverManager.getConnection("jdbc:mysql://localhost:3306/streeming","root","");
           return conec;
       }
       catch(Exception e) {
           
           System.out.println(e);
           return null;
       }
   }

  
     
}
