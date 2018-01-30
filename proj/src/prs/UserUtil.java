package prs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class UserUtil {
	private DataSource datasource;

	public UserUtil(DataSource thedatasource) {
		datasource = thedatasource;
	}

	public ArrayList<User> getUsers() throws Exception {

		ArrayList<User> Users = new ArrayList<>();

		Connection con = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// get a connection
			
			PreparedStatement ps;
			Class.forName("com.mysql.jdbc.Driver");
		 con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/PRSDB", "root",
					"12345678");

			Statement stmt = (Statement) con.createStatement();
			ps = con.prepareStatement("UPDATE userinfo SET Berth_Availability='no' where Coach_id=? AND Berth_id=?");
		
			ResultSet rs = stmt.executeQuery("SELECT * FROM userinfo");

			// create sql statement
			String sql = "SELECT * FROM userinfo";

			myStmt = con.createStatement();

			// execute query
			myRs = myStmt.executeQuery(sql);

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int Train_no = myRs.getInt("Train_no");
				String Journey_date = myRs.getString("Journey_date");
				String Class = myRs.getString("Class");
				String Coach_id = myRs.getString("Coach_id");
				int Berth_id = myRs.getInt("Berth_id");
				String Berth_Availability = myRs.getString("Berth_Availability");

				// create new student object
				User tempUser = new User(Train_no, Journey_date, Class, Coach_id, Berth_id, Berth_Availability);

				// add it to the list of students
				Users.add(tempUser);
			}

			return Users;
		} finally {
			// close JDBC objects
			close(con, myStmt, myRs);
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close();
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
