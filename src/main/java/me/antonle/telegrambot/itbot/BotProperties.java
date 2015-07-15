package me.antonle.telegrambot.itbot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("bot")
public class BotProperties {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getApi() {
        if (token == null) {
            throw new NullPointerException("token should be populated");
        }
        return "https://api.telegram.org/bot" + token;
    }
}
