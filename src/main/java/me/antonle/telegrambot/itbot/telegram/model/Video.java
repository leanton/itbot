package me.antonle.telegrambot.itbot.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Video implements Serializable {

    @JsonProperty("file_id")
    public String fileID;

    public Integer width;

    public Integer height;

    public Integer duration;

    public PhotoSize thumb;

    @JsonProperty("mime_type")
    public String mimeType;

    @JsonProperty("file_size")
    public Integer fileSize;

    public String capture;

    public Video() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Video video = (Video) o;

        return fileID.equals(video.fileID);

    }

    @Override
    public int hashCode() {
        return fileID.hashCode();
    }

    @Override
    public String toString() {
        return "Video{" +
                "fileID='" + fileID + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                ", thumb=" + thumb +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                ", capture='" + capture + '\'' +
                '}';
    }
}
