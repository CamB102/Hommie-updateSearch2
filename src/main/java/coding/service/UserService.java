package coding.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import coding.db.DBUtil;
import coding.entity.User;

public class UserService {
	
	
	
//	 function to use in register
	 public boolean insertUser(User user) throws SQLException { 
			Connection conn = null;
			PreparedStatement ps = null;

			try {
//				make connection to mySQL
				conn = DBUtil.makeConnection();

//				create sql for insert
				String sql = "INSERT INTO `user`(first_name, last_name, phone_number, email, password, role) value(?,?,?,?,?,?)";
				ps = conn.prepareStatement(sql);

//				set parameters
				ps.setString(1, user.getFirstName());
				ps.setString(2, user.getLastName());
				ps.setString(3, user.getPhoneNumber());
				ps.setString(4, user.getEmail());
				ps.setString(5, user.getPassword());
				ps.setString(6, user.getRole());

				ps.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			}
			return true;
		} 
	 
	 
	 
//	 function to check if email is available for new account
	 public boolean isEmailAvailable(String email) throws SQLException {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {
//				make connection to mySQL
				conn = DBUtil.makeConnection();

//				create sql for insert
				String sql = "SELECT COUNT(*) FROM `user` WHERE email =?";
				ps = conn.prepareStatement(sql);

				ps.setString(1, email);
				rs = ps.executeQuery();

				if (rs.next()) {
					int count = rs.getInt(1);
					return count == 0;
				}

			} finally {

				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}

			}
			return false;
		}
	 
	 
//		function to use in login
		 public User getUserByEmailAndPassword (String email, String password) throws SQLException {
			 Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				User user= null;

				try {
					conn = DBUtil.makeConnection();

					String sql = "SELECT * FROM `user` WHERE email= ? AND password= ?";
					ps = conn.prepareStatement(sql);

					ps.setString(1, email);
					ps.setString(2, password);

					rs = ps.executeQuery();

					if (rs.next()) {
						int id = rs.getInt("id");
						String firstName = rs.getString("first_name");
						String lastName = rs.getString("last_name");
						String role = rs.getString("role");
						user = new User(id,firstName, lastName, role);
					}

				} finally {

					if (ps != null) {
						ps.close();
					}
					if (conn != null) {
					}

				}
		
				return user;
		
		 }	
		
	
}
