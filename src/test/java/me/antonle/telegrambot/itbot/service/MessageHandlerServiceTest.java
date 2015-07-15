package me.antonle.telegrambot.itbot.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageHandlerServiceTest {

    private MessageHandlerService messageHandlerService;

    @Before
    public void setUp() throws Exception {
        messageHandlerService = new MessageHandlerService();
    }

    @Test
    public void testGenerateReply_ПашиСука() throws Exception {
        String text = "Парни, комп не пашет";
        assertEquals("ПАШИ СУКА", messageHandlerService.generateReply(text));

        text = "Я ГОВОРЮ КОМП НЕ ПАШЕТ";
        assertEquals("ПАШИ СУКА", messageHandlerService.generateReply(text));

        text = "ВЫ ДЕБИЛЫ ЧТОЛИ???";
        assertEquals("Посоны, мы пока в КС играем, сорян!", messageHandlerService.generateReply(text));

    }
}