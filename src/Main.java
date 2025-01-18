// ----------------------------------------------------
// Main.java - клас за стартиране на приложението
// ----------------------------------------------------

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Създаваме Scanner за вход от потребителя
        Scanner scanner = new Scanner(System.in);

        // Примерен избор на потребителя в менюто
        while (true) {
            System.out.println("\n--- Меню ---");
            System.out.println("1. Създаване на потребител");
            System.out.println("2. Създаване на резервация");
            System.out.println("3. Четене на всички потребители");
            System.out.println("4. Четене на всички резервации");
            System.out.println("5. Изтриване на потребител");
            System.out.println("6. Изтриване на резервация");
            System.out.println("7. Преименуване на потребител");
            System.out.println("8. Смяна на паролата на потребител");
            System.out.println("9. Изход");
            System.out.print("Изберете опция: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Четене на новия ред

            switch (option) {
                case 1:
                    // Създаване на потребител
                    System.out.print("Въведете ID на потребителя: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();  // Четене на новия ред
                    System.out.print("Въведете име на потребителя: ");
                    String userName = scanner.nextLine();
                    System.out.print("Въведете потребителско име: ");
                    String username = scanner.nextLine();
                    System.out.print("Въведете парола: ");
                    String password = scanner.nextLine();

                    UserManager.createUser(userId, userName, username, password);
                    break;

                case 2:
                    // Създаване на резервация
                    System.out.print("Въведете ID на резервацията: ");
                    int reservationId = scanner.nextInt();
                    scanner.nextLine();  // Четене на новия ред
                    System.out.print("Въведете време на резервацията: ");
                    String time = scanner.nextLine();
                    System.out.print("Въведете дата на резервацията: ");
                    String date = scanner.nextLine();
                    System.out.print("Въведете номер на стаята: ");
                    String roomNumber = scanner.nextLine();

                    ReservationManager.createReservation(reservationId, time, date, roomNumber);
                    break;

                case 3:
                    // Четене на всички потребители
                    UserManager.readUsers();
                    break;

                case 4:
                    // Четене на всички резервации
                    ReservationManager.readReservations();
                    break;

                case 5:
                    // Изтриване на потребител
                    System.out.print("Въведете ID на потребителя за изтриване: ");
                    int deleteUserId = scanner.nextInt();
                    scanner.nextLine();  // Четене на новия ред
                    UserManager.deleteUser(deleteUserId);
                    break;

                case 6:
                    // Изтриване на резервация
                    System.out.print("Въведете ID на резервацията за изтриване: ");
                    int deleteReservationId = scanner.nextInt();
                    scanner.nextLine();  // Четене на новия ред
                    ReservationManager.deleteReservation(deleteReservationId);
                    break;

                case 7:
                    // Преименуване на потребител
                    System.out.print("Въведете ID на потребителя за преименуване: ");
                    int renameUserId = scanner.nextInt();
                    scanner.nextLine();  // Четене на новия ред
                    System.out.print("Въведете ново име на потребителя: ");
                    String newUserName = scanner.nextLine();
                    UserManager.renameUser(renameUserId, newUserName);
                    break;

                case 8:
                    // Смяна на парола на потребител
                    System.out.print("Въведете ID на потребителя за смяна на паролата: ");
                    int changePasswordUserId = scanner.nextInt();
                    scanner.nextLine();  // Четене на новия ред
                    System.out.print("Въведете нова парола: ");
                    String newPassword = scanner.nextLine();
                    UserManager.changePassword(changePasswordUserId, newPassword);
                    break;

                case 9:
                    // Изход от програмата
                    System.out.println("Изход от програмата...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Невалиден избор. Моля, опитайте отново.");
            }
        }
    }
}