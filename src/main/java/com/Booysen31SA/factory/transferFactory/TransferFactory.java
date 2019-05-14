package com.Booysen31SA.factory.transferFactory;

import com.Booysen31SA.domain.school.Transfer;

public class TransferFactory {

    public static Transfer TransferSchool(int pasalNumber, String previousSchool, String transferToSchool, int teacherAmount, String status){
        return new Transfer.Builder().setPasalNumber(pasalNumber)
                                   .setPreviousSchool(previousSchool)
                                   .setSchoolName(transferToSchool)
                                   .setTeacherAmount((teacherAmount)+1)
                                   .setStatus(status).build();

    }


}
