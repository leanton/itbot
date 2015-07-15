package me.antonle.telegrambot.itbot.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class ReplyKeyboardMarkup implements Serializable {

    public ArrayList<ArrayList<String>> keyboard;

    @JsonProperty("resize_keyboard")
    public Boolean resizeKeyboard;

    @JsonProperty("one_time_keyboard")
    public Boolean oneTimeKeyboard;

    public Boolean selective;

    public ReplyKeyboardMarkup() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReplyKeyboardMarkup that = (ReplyKeyboardMarkup) o;

        if (!keyboard.equals(that.keyboard)) return false;
        if (resizeKeyboard != null ? !resizeKeyboard.equals(that.resizeKeyboard) : that.resizeKeyboard != null)
            return false;
        if (oneTimeKeyboard != null ? !oneTimeKeyboard.equals(that.oneTimeKeyboard) : that.oneTimeKeyboard != null)
            return false;
        return !(selective != null ? !selective.equals(that.selective) : that.selective != null);

    }

    @Override
    public int hashCode() {
        int result = keyboard.hashCode();
        result = 31 * result + (resizeKeyboard != null ? resizeKeyboard.hashCode() : 0);
        result = 31 * result + (oneTimeKeyboard != null ? oneTimeKeyboard.hashCode() : 0);
        result = 31 * result + (selective != null ? selective.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReplyKeyboardMarkup{" +
                "keyboard=" + keyboard +
                ", resizeKeyboard=" + resizeKeyboard +
                ", oneTimeKeyboard=" + oneTimeKeyboard +
                ", selective=" + selective +
                '}';
    }
}
