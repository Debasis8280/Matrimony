package mm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mm.db.Provider;
import mm.db.RegisterAboutDetails;
import mm.db.RegisterPersonalDetails;
import mm.db.RegisterProefssionalDetails;
import mm.db.RegisterReligionDetails;
import mm.db.User;

public class Dao 
{

	public static int insertUser1(User u) throws Exception{
		int status=0;
		PreparedStatement pst,pst1,pst2,pst3;
			Connection con=Provider.getOracleConnection();
			status=Check.emailCheck(u);
			if (status>0) 
			{
				return 0;
			}
			else {
				String sql="insert into users(MATRIMONYPROFILEFOR,NAME,EMAILID,DATEOFBIRTH,PASSWORD) values(?,?,?,?,?)";
				pst=con.prepareStatement(sql);
				pst.setString(1, u.getMatrimony_profile_for());
				pst.setString(2, u.getName());
				pst.setString(3, u.getEmail_id());
				pst.setString(4, u.getDate_of_birth());
				pst.setString(5, u.getPassword());
				int result=pst.executeUpdate();
				
				if (result>0) {
					status=1;
				}
			}
		return status;
	}


	public static int insertUser2(User u) throws Exception{
		int status=0;
		PreparedStatement pst;
		System.out.println(u.getEmail_id()+"\t for register2 userDao");
			Connection con=Provider.getOracleConnection();
			String sql="update users set GENDER=?, MOBILENO=?,RELIGION=?,MOTHERTONGUE=?,COUNTRYLIVINGIN=? where EMAILID=?";
			pst=con.prepareStatement(sql);
			pst.setString(1, u.getGender());
			pst.setString(2, u.getMobile_no());
			pst.setString(3, u.getReligion());
			pst.setString(4, u.getMother_tongue());
			pst.setString(5, u.getCountry_living_in());
			pst.setString(6, u.getEmail_id());
			int result=pst.executeUpdate();
			if (result>0) {
				status=1;
			}
	return status;
	}


	public static int insertRegisterReligion(RegisterReligionDetails rr,User u) throws Exception{
		int status=0;
			System.out.println(u.getEmail_id()+"\t userDao");
			Connection con=Provider.getOracleConnection();
			String sql="insert into Religion_detail values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, rr.getCast());
			pst.setString(2,rr.getSubcast());
			pst.setString(3, rr.getGothra());
			pst.setString(4, rr.getDosh_no_yes_dontknow());
			pst.setString(5, rr.getDosh_yes_manglik());
			pst.setString(6, rr.getDosh_yes_sarpadosh());
			pst.setString(7, rr.getDosh_yes_kalasarapsosh());
			pst.setString(8,rr.getDosh_yes_rahudosh());
			pst.setString(9, rr.getDosh_yes_kethudosh());
			pst.setString(10, rr.getDosh_yes_kalathradosh());
			pst.setString(11, u.getEmail_id());
			int result=pst.executeUpdate();
			if(result>0)
			{
				status=1;
			}
		return status;
	}


	public static int insertPersonalDetail(RegisterPersonalDetails rp, User u)throws Exception {
		int status=0;
			Connection con=Provider.getOracleConnection();
			String sql="insert into personal_details values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, rp.getMarital_status());
			pst.setString(2, rp.getMarital_status_numberofchildren());
			pst.setString(3, rp.getMarital_status_with_or_not());
			pst.setString(4, rp.getHeight());
			pst.setString(5, rp.getFamily_status());
			pst.setString(6, rp.getFamily_type());
			pst.setString(7,rp.getFamily_values());
			pst.setString(8, rp.getAny_disability());
			pst.setString(9, u.getEmail_id());
			int result=pst.executeUpdate();
			if (result>0) {
				status=1;
			}
		return status;
	}


	public static int insertRegisterprofessional(RegisterProefssionalDetails rpf, User u)throws Exception {
		int status=0;
			Connection con=Provider.getOracleConnection();
			String sql="insert into professional_details values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, rpf.getHighest_education());
			pst.setString(2, rpf.getEmployed_in());
			pst.setString(3, rpf.getOccupation_status());
			pst.setString(4, rpf.getAnnual_income());
			pst.setString(5, rpf.getWork_locationcountry());
			pst.setString(6, rpf.getWork_locationcitizenship());
			pst.setString(7, rpf.getBrides_locationcountry());
			pst.setString(8, rpf.getBrides_currentcitizenship());
			pst.setString(9, u.getEmail_id());
			int result=pst.executeUpdate();
			if (result>0) {
				status=1;
			}
		return status;
	}


	public static int insertAbout(RegisterAboutDetails ra, User u)throws Exception {
		int status=0;
			Connection con=Provider.getOracleConnection();
			String sql="insert into RegisterAbout values(?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, ra.getAbout());
			pst.setString(2, u.getEmail_id());
			int result=pst.executeUpdate();
			if (result>0) {
				status=1;
			}
		return status;
	}


	public static int checkLogin(User u) throws Exception
	{
		int status=0;
			Connection con=Provider.getOracleConnection();
			String sql="select emailid from users where password=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, u.getPassword());
			ResultSet rs=pst.executeQuery();
			if (rs.next()) 
			{
				status=1;
			}
		return status;
	}


	public static int forgotPassword(User u) throws Exception
	{
		int status=0;
			Connection con=Provider.getOracleConnection();
			String sql="update users set password=? where emailid=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, u.getPassword());
			pst.setString(2, u.getEmail_id());
			int result=pst.executeUpdate();
			if (result>0)
			{
				status=1;
			}
		return status;
	}
}
