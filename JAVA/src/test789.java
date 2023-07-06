import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class test789 {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "root");
        try {
            // 1. 註冊 JDBC 驅動程式
        	
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii",prop);
			
            // 3. 建立 Statement 物件
            statement = connection.createStatement();

            // 4. 執行 SQL 查詢
            String sql = "SELECT * FROM users";
            resultSet = statement.executeQuery(sql);

            // 5. 處理查詢結果
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
                System.out.println("------------------");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 釋放資源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}