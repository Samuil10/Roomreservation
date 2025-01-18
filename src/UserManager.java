import java.sql.*;

public class UserManager {

    // Метод за създаване на потребител и автоматично добавяне на съответния user
    public static void createUser(int id, String name, String username, String password) {
        String queryPerson = "INSERT INTO person (id, name, username, password) VALUES (?, ?, ?, ?)";
        String queryUser = "INSERT INTO user (person_id) VALUES (?)";  // Добавяне на запис в таблицата user
        Connection conn = null;  // Декларираме conn извън try блока

        try {
            conn = DatabaseConnection.connect();
            // Започваме транзакция, за да сме сигурни, че и двете операции ще се случат успешно
            conn.setAutoCommit(false);
            // Първо създаваме новия потребител в таблица person
            try (PreparedStatement pstmtPerson = conn.prepareStatement(queryPerson, PreparedStatement.RETURN_GENERATED_KEYS)) {
                pstmtPerson.setInt(1, id);
                pstmtPerson.setString(2, name);
                pstmtPerson.setString(3, username);
                pstmtPerson.setString(4, password);
                pstmtPerson.executeUpdate();

                // Вземаме генерирания ID за новия потребител
                ResultSet rs = pstmtPerson.getGeneratedKeys();
                int personId = 0;
                if (rs.next()) {
                    personId = rs.getInt(1);  // Получаваме id на новия потребител
                }

                // След това добавяме съответния запис в таблица user
                try (PreparedStatement pstmtUser = conn.prepareStatement(queryUser)) {
                    pstmtUser.setInt(1, personId);
                    pstmtUser.executeUpdate();
                    System.out.println("Потребителят е създаден успешно в person и user!");
                }
            }
            // Потвърдете транзакцията
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Грешка при създаване на потребител.");
            try {
                // Ако има грешка, откатваме транзакцията
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
            // Затваряме връзката в блока finally
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Метод за преименуване на потребител
    public static void renameUser(int id, String newName) {
        String query = "UPDATE person SET name = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, newName);
            pstmt.setInt(2, id);

            // Изпълняваме заявката
            pstmt.executeUpdate();
            System.out.println("Потребителят е преименуван успешно!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Грешка при преименуване на потребител.");
        }
    }

    // Метод за смяна на паролата
    public static void changePassword(int id, String newPassword) {
        String query = "UPDATE person SET password = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, newPassword);
            pstmt.setInt(2, id);

            // Изпълняваме заявката
            pstmt.executeUpdate();
            System.out.println("Паролата е променена успешно!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Грешка при смяна на паролата.");
        }
    }

    // Метод за четене на всички потребители
    public static void readUsers() {
        String query = "SELECT * FROM person";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String username = rs.getString("username");

                System.out.println("Потребител ID: " + id + ", Име: " + name + ", Потребителско име: " + username);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Грешка при четене на потребители.");
        }
    }

    // Метод за изтриване на потребител
    public static void deleteUser(int id) {
        String query = "DELETE FROM person WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Потребителят е изтрит успешно!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Грешка при изтриване на потребител.");
        }
    }
}