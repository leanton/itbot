package me.antonle.telegrambot.itbot.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Document implements Serializable {

    @JsonProperty("file_id")
    public String fileID;

    public PhotoSize thumb;

    @JsonProperty("file_name")
    public String fileName;

    @JsonProperty("mime_type")
    public String mimeType;

    @JsonProperty("file_size")
    public Integer fileSize;

    public Document() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        return fileID.equals(document.fileID);

    }

    @Override
    public int hashCode() {
        return fileID.hashCode();
    }

    @Override
    public String toString() {
        return "Document{" +
                "fileID='" + fileID + '\'' +
                ", thumb=" + thumb +
                ", fileName='" + fileName + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
