package me.antonle.telegrambot.itbot.telegram.model;

import java.io.Serializable;

public class Location implements Serializable {

    public Double longitude;

    public Double latitude;

    public Location() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (!longitude.equals(location.longitude)) return false;
        return latitude.equals(location.latitude);

    }

    @Override
    public int hashCode() {
        int result = longitude.hashCode();
        result = 31 * result + latitude.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
