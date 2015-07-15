package me.antonle.telegrambot.itbot.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class UserProfilePhotos implements Serializable {

    @JsonProperty("total_count")
    public Integer totalCount;

    public ArrayList<ArrayList<PhotoSize>> photos;

    public UserProfilePhotos() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserProfilePhotos that = (UserProfilePhotos) o;

        if (!totalCount.equals(that.totalCount)) return false;
        return photos.equals(that.photos);

    }

    @Override
    public int hashCode() {
        int result = totalCount.hashCode();
        result = 31 * result + photos.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserProfilePhotos{" +
                "totalCount=" + totalCount +
                ", photos=" + photos +
                '}';
    }
}
