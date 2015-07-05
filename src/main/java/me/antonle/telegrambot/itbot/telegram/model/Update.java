package me.antonle.telegrambot.itbot.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Update {

    @JsonProperty("update_id")
    public long updateID;

    public Message message;

}
