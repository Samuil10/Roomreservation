// ----------------------------------------------------
// ReservationManager.java - клас за управление на резервации
// ----------------------------------------------------

import java.sql.*;

public class ReservationManager {

    // Метод за създаване на резервация
    public static void createReservation(int id, String time, String date, String room_number) {
        String query = "INSERT INTO request (id, time, date, room_number) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.setString(2, time);
            pstmt.setString(3, date);
            pstmt.setString(4, room_number);

            // Изпълняваме заявката
            pstmt.executeUpdate();
            System.out.println("Резервацията е създадена успешно!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Грешка при създаване на резервация.");
        }
    }

    // Метод за четене на всички резервации
    public static void readReservations() {
        String query = "SELECT * FROM request";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String time = rs.getString("time");
                String date = rs.getString("date");
                String roomNumber = rs.getString("room_number");

                System.out.println("Резервация ID: " + id + ", Време: " + time + ", Дата: " + date + ", Стая: " + roomNumber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Грешка при четене на резервации.");
        }
    }

    // Метод за изтриване на резервация
    public static void deleteReservation(int id) {
        String query = "DELETE FROM request WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Резервацията е изтрита успешно!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Грешка при изтриване на резервация.");
        }
    }
}