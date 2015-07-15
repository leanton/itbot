package me.antonle.telegrambot.itbot.service;

import junit.framework.TestCase;

public class MessageHandlerServiceTest extends TestCase {

    private MessageHandlerService messageHandlerService;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        messageHandlerService = new MessageHandlerService();
    }

    public void testGenerateReply_ПашиСука() throws Exception {
        String text = "Парни, комп не пашет";
        assertEquals("ПАШИ СУКА", messageHandlerService.generateReply(text));

        text = "Я ГОВОРЮ КОМП НЕ ПАШЕТ";
        assertEquals("ПАШИ СУКА", messageHandlerService.generateReply(text));

        text = "ВЫ ДЕБИЛЫ ЧТОЛИ???";
        assertEquals("Посоны, мы пока в КС играем, сорян!", messageHandlerService.generateReply(text));

    }
}