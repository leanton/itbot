package me.antonle.telegrambot.itbot.telegram.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class Message implements Serializable {

    @JsonProperty("message_id")
    public Long messageID;

    @JsonProperty("from")
    public User from;

    public Long date;

    public User chat;

    public User forwardFrom;

    public Long forwardDate;

    @JsonProperty("reply_to_message")
    public Message replyToMessage;

    public String text;

    public Audio audio;

    public Document document;

    public List<PhotoSize> photo;

    public Sticker sticker;

    public Video video;

    public Contact contact;

    public Location location;

    @JsonProperty("new_chat_participant")
    public User newChatParticipant;

    @JsonProperty("left_chat_participant")
    public User leftChatParticipant;

    @JsonProperty("new_chat_title")
    public String newChatTitle;

    @JsonProperty("new_chat_photo")
    public List<PhotoSize> newChatPhoto;

    @JsonProperty("delete_chat_photo")
    public boolean deleteChatPhoto;

    @JsonProperty("group_chat_created")
    public boolean groupChatCreated;

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageID=" + messageID +
                ", from=" + from +
                ", date=" + date +
                ", chat=" + chat +
                ", forwardFrom=" + forwardFrom +
                ", forwardDate=" + forwardDate +
                ", replyToMessage=" + replyToMessage +
                ", text='" + text + '\'' +
                ", audio=" + audio +
                ", document=" + document +
                ", photo=" + photo +
                ", sticker=" + sticker +
                ", video=" + video +
                ", contact=" + contact +
                ", location=" + location +
                ", newChatParticipant=" + newChatParticipant +
                ", leftChatParticipant=" + leftChatParticipant +
                ", newChatTitle='" + newChatTitle + '\'' +
                ", newChatPhoto=" + newChatPhoto +
                ", deleteChatPhoto=" + deleteChatPhoto +
                ", groupChatCreated=" + groupChatCreated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        return messageID.equals(message.messageID);

    }

    @Override
    public int hashCode() {
        return messageID.hashCode();
    }
}
