package me.antonle.telegrambot.itbot.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PhotoSize implements Serializable {

    @JsonProperty("file_id")
    public String fileID;

    public Integer width;

    public Integer height;

    @JsonProperty("file_size")
    public Integer fileSize;

    public PhotoSize() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhotoSize photoSize = (PhotoSize) o;

        return fileID.equals(photoSize.fileID);

    }

    @Override
    public int hashCode() {
        return fileID.hashCode();
    }

    @Override
    public String toString() {
        return "PhotoSize{" +
                "fileID='" + fileID + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", fileSize=" + fileSize +
                '}';
    }
}
