import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcPractice {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "$Alliswell2021$")) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO aliens (id,name,points) " +
                    "values (?,trim(?),?)");
            ps.setInt(1, 15);
            ps.setString(2, "   Ramesh   Kumar   ");
            ps.setInt(3, 5);
            ps.executeUpdate();
//            ps = con.prepareStatement("UPDATE aliens SET name = rtrim(name)");

//            int i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
