// ----------------------------------------------------
// Reservation.java - клас за резервации
// ----------------------------------------------------

public class Reservation {
    private int id;               // Идентификатор на резервацията
    private String time;          // Час на резервацията (datetime)
    private String date;          // Дата на резервацията
    private String room_number;   // Номер на стаята (room_number)

    // Конструктор
    public Reservation(int id, String time, String date, String room_number) {
        this.id = id;
        this.time = time;
        this.date = date;
        this.room_number = room_number;
    }

    // Гетъри и сетъри
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }
}
