package mm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mm.db.Provider;
import mm.db.User;

public class Check {

	public static int emailCheck(User u) throws Exception
	{
		System.out.println("==============Check.java====================");
		int status=0;
		Connection con=Provider.getOracleConnection();
		String sql="select name from users where EMAILID=?";
		PreparedStatement pst=con.prepareStatement(sql);
		System.out.println(u.getEmail_id());
		pst.setString(1,u.getEmail_id());
		ResultSet rs=pst.executeQuery();
		if (rs.next()) 
		{
			status=1;
		}
		return status;
	}
}
