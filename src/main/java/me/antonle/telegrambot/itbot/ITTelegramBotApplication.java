package me.antonle.telegrambot.itbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ITTelegramBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(ITTelegramBotApplication.class, args);
    }
}
