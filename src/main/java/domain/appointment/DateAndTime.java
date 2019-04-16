package domain.appointment;

public class DateAndTime {

    private String date;
    private String time;

    public DateAndTime(String date, String time) {
        this.date = date;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
