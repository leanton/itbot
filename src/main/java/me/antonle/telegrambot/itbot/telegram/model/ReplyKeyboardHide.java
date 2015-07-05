package me.antonle.telegrambot.itbot.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ReplyKeyboardHide implements Serializable {

    @JsonProperty("hide_keyboard")
    public Boolean hideKeyboard;

    public Boolean selective;

    public ReplyKeyboardHide() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReplyKeyboardHide that = (ReplyKeyboardHide) o;

        if (!hideKeyboard.equals(that.hideKeyboard)) return false;
        return !(selective != null ? !selective.equals(that.selective) : that.selective != null);

    }

    @Override
    public int hashCode() {
        int result = hideKeyboard.hashCode();
        result = 31 * result + (selective != null ? selective.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReplyKeyboardHide{" +
                "hideKeyboard=" + hideKeyboard +
                ", selective=" + selective +
                '}';
    }
}
