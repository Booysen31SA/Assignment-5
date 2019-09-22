package com.Booysen31SA.factory.school;

import com.Booysen31SA.domain.school.Transfer;

public class TransferFactory {
    public static Transfer buildTransfer(String pasalNumber, String previousSchool, String schoolName, int teacherAmount){
        return new Transfer.Builder()
                .setPasalNumber(pasalNumber)
                .setPreviousSchool(previousSchool)
                .setSchoolName(schoolName)
                .setTeacherAmount(teacherAmount)
                .build();
    }
}