package friday;
import java.sql.*;
public class DBconn 
{
	static String friday_output1="";
	static String query(String user_input)
	{
		try
		{
			//Connection
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/friday?autoReconnect=true&useSSL=false",	"root",	"Sarala@1970");
			//creating a statement
			Statement stmt=connection.createStatement();
			//Quering the data
			ResultSet friday_output=stmt.executeQuery("select Answer from friday.common_questions where question = "+"\""+user_input+"\"");
			while(friday_output.next())
			{
				friday_output1=friday_output.getString("Answer");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);

		}
		return friday_output1;
	}
}
