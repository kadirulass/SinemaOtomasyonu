import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dbCon {
	 Connection myCon;
	 Statement myStat;
	public dbCon() {
		try {
			myCon=DriverManager.getConnection("jdbc:mysql://localhost:3306/sinema","root","kadirulaþ");
			myStat=myCon.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
