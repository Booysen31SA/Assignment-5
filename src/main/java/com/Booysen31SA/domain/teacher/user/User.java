package com.Booysen31SA.domain.teacher.user;

import com.Booysen31SA.domain.teacher.interfaces.TeacherIdentity;
import com.Booysen31SA.domain.teacher.interfaces.TeacherName;

import java.util.Objects;

public class User implements TeacherIdentity, TeacherName {

    private String persal_Number = "";
    private String id;
    private String first_Names = "";
    private String last_Name = "";

    public User(Builder build){
        this.persal_Number = build.persal_Number;
        this.id = build.id;
        this.first_Names = build.first_Names;
        this.last_Name = build.last_Name;
    }

    public User(String persal_Number, String id, String first_Names, String last_Name) {
        this.persal_Number = persal_Number;
        this.id = id;
        this.first_Names = first_Names;
        this.last_Name = last_Name;
    }

    @Override
    public String getPersal_Number() {
        return persal_Number;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getFirst_Names() {
        return first_Names;
    }

    @Override
    public String getLast_Name() {
        return last_Name;
    }

    public static class Builder{
        private String persal_Number = "";
        private String id;
        private String first_Names = "";
        private String last_Name = "";

        public Builder persal_Number(String persal_Number) {
            this.persal_Number = persal_Number;
            return this;
        }
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder first_Names(String first_Names) {
            this.first_Names = first_Names;
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
                Objects.equals(first_Names, builder.first_Names) &&
                Objects.equals(last_Name, builder.last_Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(persal_Number, id);
    }

}
