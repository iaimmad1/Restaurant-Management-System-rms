package rms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class first {
    public static void main(String args[]) {
        
    try{
            	
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.print("Hello");
		
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_management","root","Iloveyou@Raa");
				Statement stmt=con.createStatement();
				String sql="select max(Uid) from login";
				ResultSet rs=stmt.executeQuery(sql);
			
            	
				int Id = 0;
				if(rs.next())// our table is not then '
          		{
					Id = rs.getInt(1);
					if(Id > 0)
					{
						login.main(null);
					}
					else{
              
						adminreg.main(null);
					}
              
          		}
          
            }	catch(SQLException e)
            	{
            		JOptionPane.showMessageDialog(null,e);
            	}
    } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
            
    }
}