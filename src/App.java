import com.util.connectionConfig;
import java.sql.*;
// comment

public class App {
    public static void main(String[] args) {
        Connection connection = null;
        Statement stmt = null;
        try {
            connection = connectionConfig.getConnection();
            if(connection != null) {
                //System.out.println("YAS!");
                stmt = connection.createStatement();
                String sql;
                sql = "SELECT * from users";
                ResultSet rs = stmt.executeQuery(sql);

                //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                int age = rs.getInt("role");
                String first = rs.getString("name");
                String last = rs.getString("email");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
                //STEP 6: Clean-up environment
                rs.close();
                stmt.close();
                connection.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
