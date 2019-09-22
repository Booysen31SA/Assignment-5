package com.Booysen31SA.domain.teacher.user;

import com.Booysen31SA.domain.teacher.interfaces.TeacherIdentity;
import com.Booysen31SA.domain.teacher.interfaces.TeacherName;
import sun.launcher.resources.launcher_sv;

import java.util.Objects;

public class User implements TeacherIdentity, TeacherName {

    private String persal_Number = "";
    private long id = 0;
    private String first_Name = "";
    private String last_Name = "";

    public User(Builder build){
        this.persal_Number = build.persal_Number;
        this.id = build.id;
        this.first_Name = build.first_Name;
        this.last_Name = build.last_Name;
    }


    @Override
    public String getPersal_Number() {
        return persal_Number;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getFirst_Names() {
        return first_Name;
    }

    @Override
    public String getLast_Name() {
        return last_Name;
    }

    public static class Builder{
        private String persal_Number = "";
        private long id = 0;
        private String first_Name = "";
        private String last_Name = "";

        public Builder persal_Number(String persal_Number) {
            this.persal_Number = persal_Number;
            return this;
        }
        public Builder id(long id) {
            this.id = id;
            return this;
        }
        public Builder first_Name(String first_Name) {
            this.first_Name = first_Name;
            return this;
        }

        public Builder last_Name(String last_Name) {
            this.last_Name = last_Name;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Builder)) return false;
        Builder builder = (Builder) o;
        return id == builder.id &&
                persal_Number.equals(builder.persal_Number) &&
                Objects.equals(first_Name, builder.first_Name) &&
                Objects.equals(last_Name, builder.last_Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persal_Number, id);
    }

}
