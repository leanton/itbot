package me.antonle.telegrambot.itbot.telegram.model;

import java.io.Serializable;

public class GroupChat implements Serializable {

    public Long id;

    public String title;

    public GroupChat() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupChat groupChat = (GroupChat) o;

        return id.equals(groupChat.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "GroupChat{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
