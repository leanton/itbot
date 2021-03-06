package me.antonle.telegrambot.itbot.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Update implements Serializable {

    @JsonProperty("update_id")
    public Long updateID;

    public Message message;

    public Update() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Update update = (Update) o;

        return updateID.equals(update.updateID);

    }

    @Override
    public int hashCode() {
        return updateID.hashCode();
    }

    @Override
    public String toString() {
        return "Update{" +
                "updateID=" + updateID +
                ", message=" + message +
                '}';
    }
}
