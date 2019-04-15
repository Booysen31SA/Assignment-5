package factory.TransferFactory;

import domain.School.Transfer;

public class TransferFactory {

    public static Transfer TransferSchool(int pasalNumber, String previousSchool, String transferToSchool, int teacherAmount){
        return new Transfer.Builder().setPasalNumber(pasalNumber)
                                   .setPreviousSchool(previousSchool)
                                   .setSchoolName(transferToSchool)
                                   .setTeacherAmount((teacherAmount)+1).build();

    }
}
