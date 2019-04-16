package domain.teacher;

public class TeacherAddress {

    private String physicalAddress;
    private String postalAddress;

    public TeacherAddress(String physicalAddress, String postalAddress) {
        this.physicalAddress = physicalAddress;
        this.postalAddress = postalAddress;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }


}
