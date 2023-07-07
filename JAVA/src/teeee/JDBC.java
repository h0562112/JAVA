package teeee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;

public class JDBC {

	private ArrayList<Integer> Player_id = new ArrayList<Integer>();
	public ArrayList<String> Player_name = new ArrayList<String>();
	public ArrayList<Integer> Player_score = new ArrayList<Integer>();

	public void balljdbc01() {
		
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", prop);

			String query = "INSERT INTO game01(name, score) VALUES (?, ?)";

			System.out.println("已創建table01");
			PreparedStatement stmt = conn.prepareStatement(query);
			System.out.println("已創建table02");
			// PreparedStatement stmt02 = conn.prepareStatement(database);
//			System.out.println("OK" + playerName);
//			System.out.println("OK" + playerName);
			stmt.setString(1, test1234V4.playerName);
			stmt.setInt(2, score_Blue);
			System.out.println("已創建table03");

			try {
				int n = stmt.executeUpdate();
				System.out.println("已創建table05");

			} catch (Exception e) {

			}
			
			// 其餘的程式碼...

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void queryPlayerName() {
		try {
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", prop);

			String query = "SELECT * FROM ballgame ORDER BY score DESC LIMIT 3";
			PreparedStatement stmt = conn.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Player_id.add(rs.getInt("id"));
				Player_name.add(rs.getString("name"));
				Player_score.add(rs.getInt("score"));

//    System.out.println("ID: " + Player_id);
//    System.out.println("Name: " + Player_name);
//    System.out.println("Score: " + Player_score);

			}

			// 其餘的程式碼...

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
