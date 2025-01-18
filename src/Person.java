// ----------------------------------------------------
// Person.java - основен клас за потребител
// ----------------------------------------------------

public class Person {
    private int id;         // Идентификатор на потребителя
    private String name;    // Име на потребителя
    private String username; // Потребителско име
    private String password; // Парола на потребителя

    // Конструктор
    public Person(int id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    // Гетъри и сетъри
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}