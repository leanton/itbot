package me.antonle.telegrambot.itbot.disruptor;

import me.antonle.telegrambot.itbot.telegram.model.Update;

public class UpdateEvent {
    private Update update;

    public Update getUpdate() {
        return update;
    }

    public void setUpdate(Update update) {
        this.update = update;
    }
}
