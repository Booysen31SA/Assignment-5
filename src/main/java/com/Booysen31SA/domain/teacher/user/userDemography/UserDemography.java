package com.Booysen31SA.domain.teacher.user.userDemography;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class UserDemography {
    @Id
    private String persal_Number;
    private String genderId;
    private String raceId;

    public UserDemography() {
    }

    public UserDemography(String persal_Number, String genderId, String raceId) {
        this.persal_Number = persal_Number;
        this.genderId = genderId;
        this.raceId = raceId;
    }

    public String getPersal_Number() {
        return persal_Number;
    }

    public void setPersal_Number(String persal_Number) {
        this.persal_Number = persal_Number;
    }

    public String getGenderId() {
        return genderId;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }

    @Override
    public String toString() {
        return "UserDemography{" +
                "email='" + persal_Number + '\'' +
                ", genderId='" + genderId + '\'' +
                ", raceId='" + raceId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDemography that = (UserDemography) o;
        return persal_Number.equals(that.persal_Number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persal_Number);
    }
}
