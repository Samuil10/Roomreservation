import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Данни за връзка с базата данни
    private static final String URL = "jdbc:mysql://localhost:3306/reserveroom";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Метод за връзка с базата данни
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}