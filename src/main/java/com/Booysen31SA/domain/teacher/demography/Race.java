package com.Booysen31SA.domain.teacher.demography;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Race {

    @Id
    private String raceId;
    private String raceDescription;

    private Race() {}

    public Race(Builder builder) {
        this.raceDescription = builder.raceDescription;
        this.raceId = builder.raceId;
    }

    public String getRaceId() {
        return raceId;
    }

    public String getRaceDescription() {
        return raceDescription;
    }

    @Override
    public String toString() {
        return "Race{" +
                "raceId='" + raceId + '\'' +
                ", raceDescription='" + raceDescription + '\'' +
                '}';
    }

    public static class Builder {
        private String raceId, raceDescription;

        public Builder raceId(String raceId) {
            this.raceId = raceId;
            return this;
        }

        public Builder raceDescription(String raceDescription) {
            this.raceDescription = raceDescription;
            return this;
        }

        public Race build() {
            return new Race(this);
        }

        public Builder copy(Race race) {
            this.raceDescription = race.raceDescription;
            this.raceId = race.raceId;
            return this;
        }
    }
}
