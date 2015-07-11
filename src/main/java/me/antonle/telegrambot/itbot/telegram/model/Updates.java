package me.antonle.telegrambot.itbot.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class Updates implements Serializable {

    public boolean ok;

    @JsonProperty("result")
    public ArrayList<Update> result;

    public Updates() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Updates updates = (Updates) o;

        if (ok != updates.ok) return false;
        return result.equals(updates.result);

    }

    @Override
    public int hashCode() {
        int result1 = (ok ? 1 : 0);
        result1 = 31 * result1 + result.hashCode();
        return result1;
    }

    @Override
    public String toString() {
        return "Updates{" +
                "ok=" + ok +
                ", result=" + result +
                '}';
    }
}
