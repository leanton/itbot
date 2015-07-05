package me.antonle.telegrambot.itbot.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Sticker implements Serializable {

    @JsonProperty("file_id")
    public String fileID;

    public Integer width;

    public Integer height;

    public PhotoSize thumb;

    @JsonProperty("file_size")
    public Integer fileSize;

    public Sticker() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sticker sticker = (Sticker) o;

        return fileID.equals(sticker.fileID);

    }

    @Override
    public int hashCode() {
        return fileID.hashCode();
    }

    @Override
    public String toString() {
        return "Sticker{" +
                "fileID='" + fileID + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", thumb=" + thumb +
                ", fileSize=" + fileSize +
                '}';
    }
}
