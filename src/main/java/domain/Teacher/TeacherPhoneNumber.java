package domain.Teacher;

public class TeacherPhoneNumber {

    private String cellNumber;
    private String homeNumber;

    public TeacherPhoneNumber(String cellNumber, String homeNumber) {
        this.cellNumber = cellNumber;
        this.homeNumber = homeNumber;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }
}
