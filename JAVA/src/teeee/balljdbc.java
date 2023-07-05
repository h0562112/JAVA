package teeee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class balljdbc {
	public void balljdbc01() {
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii",prop);
			
			Statement stmt = conn.createStatement();
			int n = stmt.executeUpdate("INSERT INTO ballgame(name,score) VALUES (playerName,score_Blue)");
			System.out.println(n);
			
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		
	}

}
