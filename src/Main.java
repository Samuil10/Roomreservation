import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Създаваме Scanner за вход от потребителя
        Scanner scanner = new Scanner(System.in);

        // Потребителят въвежда потребителско име и парола
        System.out.print("Въведете потребителско име: ");
        String username = scanner.nextLine();
        System.out.print("Въведете парола: ");
        String password = scanner.nextLine();

        // Проверяваме дали съществува потребител с това потребителско име и парола
        int userId = authenticateUser(username, password);

        if (userId != -1) {
            System.out.println("Успешно влязохте в системата!");

            // Проверяваме дали потребителят е администратор
            boolean isAdmin = UserManager.checkIfAdmin(userId);

            // Примерно меню
            while (true) {
                System.out.println("\n--- Меню ---");
                System.out.println("1. Създаване на резервация");
                System.out.println("2. Четене на всички резервации");
                System.out.println("3. Изтриване на резервация");

                if (isAdmin) {
                    // Меню с опции за администратори
                    System.out.println("4. Създаване на потребител");
                    System.out.println("5. Изтриване на потребител");
                    System.out.println("6. Преименуване на потребител");
                    System.out.println("7. Смяна на паролата на потребител");
                }

                System.out.println("8. Изход");
                System.out.print("Изберете опция: ");
                int option = scanner.nextInt();
                scanner.nextLine();  // Четене на новия ред

                switch (option) {
                    case 1:
                        // Създаване на резервация
                        System.out.print("Въведете час на резервацията: ");
                        int time = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Въведете дата на резервацията: ");
                        String date = scanner.nextLine();
                        System.out.print("Въведете номер на стаята: ");
                        String roomNumber = scanner.nextLine();

                        int requestId = getNextId("request");
                        ReservationManager.createReservation(requestId, time, date, roomNumber);
                        break;

                    case 2:
                        // Четене на всички резервации
                        ReservationManager.readReservations();
                        break;

                    case 3:
                        // Изтриване на резервация
                        System.out.print("Въведете ID на резервацията за изтриване: ");
                        int deleteRequestId = scanner.nextInt();
                        scanner.nextLine();  // Четене на новия ред
                        ReservationManager.deleteReservation(deleteRequestId);
                        break;

                    // Администраторски опции
                    case 4:
                        if (isAdmin) {
                            System.out.print("Въведете име на потребителя: ");
                            String name = scanner.nextLine();
                            System.out.print("Въведете потребителско име: ");
                            String newUsername = scanner.nextLine();
                            System.out.print("Въведете парола: ");
                            String newPassword = scanner.nextLine();

                            int userIdForNewUser = getNextId("person");
                            UserManager.createUser(userIdForNewUser, name, newUsername, newPassword);
                        }
                        break;

                    case 5:
                        if (isAdmin) {
                            System.out.print("Въведете ID на потребителя за изтриване: ");
                            int deleteUserId = scanner.nextInt();
                            scanner.nextLine();  // Четене на новия ред
                            UserManager.deleteUser(deleteUserId);
                        }
                        break;

                    case 6:
                        if (isAdmin) {
                            System.out.print("Въведете ID на потребителя за преименуване: ");
                            int renameUserId = scanner.nextInt();
                            scanner.nextLine();  // Четене на новия ред
                            System.out.print("Въведете ново име на потребителя: ");
                            String newUserName = scanner.nextLine();
                            UserManager.renameUser(renameUserId, newUserName);
                        }
                        break;

                    case 7:
                        if (isAdmin) {
                            System.out.print("Въведете ID на потребителя за смяна на паролата: ");
                            int changePasswordUserId = scanner.nextInt();
                            scanner.nextLine();  // Четене на новия ред
                            System.out.print("Въведете нова парола: ");
                            String newPassword = scanner.nextLine();
                            UserManager.changePassword(changePasswordUserId, newPassword);
                        }
                        break;

                    case 8:
                        // Изход от програмата
                        System.out.println("Изход от програмата...");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Невалиден избор. Моля, опитайте отново.");
                }
            }
        } else {
            System.out.println("Невалидно потребителско име или парола.");
        }
    }

    // Метод за автентикация на потребителя
    public static int authenticateUser(String username, String password) {
        String query = "SELECT id FROM person WHERE username = ? AND password = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id"); // Връщаме ID на потребителя
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Грешка при автентикацията.");
        }

        return -1;  // Връщаме -1 ако няма такъв потребител
    }

    // Метод за получаване на следващия ID за дадена таблица
    public static int getNextId(String tableName) {
        String query = "SELECT MAX(id) FROM " + tableName;

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                int maxId = rs.getInt(1);
                return maxId + 1; // Увеличаваме с 1 за следващия ID
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Грешка при получаване на максимален ID.");
        }

        return 1; // Ако таблицата е празна, връщаме 1
    }
}
