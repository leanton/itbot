package me.antonle.telegrambot.itbot.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Audio implements Serializable {

    @JsonProperty("file_id")
    public String fileID;

    public Integer duration;

    @JsonProperty("mime_type")
    public String mimeType;

    @JsonProperty("file_size")
    public Integer fileSize;

    public Audio() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Audio audio = (Audio) o;

        return fileID.equals(audio.fileID);

    }

    @Override
    public int hashCode() {
        return fileID.hashCode();
    }

    @Override
    public String toString() {
        return "Audio{" +
                "fileID='" + fileID + '\'' +
                ", duration=" + duration +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
