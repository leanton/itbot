package me.antonle.telegrambot.itbot.controller;

import me.antonle.telegrambot.itbot.BotProperties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BasicEventController {

    @Autowired
    private BotProperties botProperties;

    private static final AtomicLong updateID = new AtomicLong();
    private static final Logger LOGGER = LogManager.getLogger(BasicEventController.class);
}
