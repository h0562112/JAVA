package tw.org.iii.tutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBC8 {

	public static void main(String[] args) {
		try {
		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii",prop);
		}catch 
	}

}
