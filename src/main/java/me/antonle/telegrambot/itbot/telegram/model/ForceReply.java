package me.antonle.telegrambot.itbot.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ForceReply implements Serializable {

    @JsonProperty("force_replay")
    public Boolean forceReplay;

    public Boolean selective;

    public ForceReply() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForceReply that = (ForceReply) o;

        if (!forceReplay.equals(that.forceReplay)) return false;
        return !(selective != null ? !selective.equals(that.selective) : that.selective != null);

    }

    @Override
    public int hashCode() {
        int result = forceReplay.hashCode();
        result = 31 * result + (selective != null ? selective.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ForceReply{" +
                "forceReplay=" + forceReplay +
                ", selective=" + selective +
                '}';
    }
}
