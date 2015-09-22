package me.antonle.telegrambot.itbot.disruptor;

import me.antonle.telegrambot.itbot.properties.UpdateDisruptorProperties;
import me.antonle.telegrambot.itbot.service.MessageHandlerService;
import me.antonle.telegrambot.itbot.telegram.model.Message;
import me.antonle.telegrambot.itbot.telegram.model.Update;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UpdateDisruptorCheck {

    @Mock
    private MessageHandlerService messageHandler;
    @Mock
    private UpdateDisruptorProperties disruptorProps;
    private UpdateDisruptor disruptor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(disruptorProps.getBufferSize()).thenReturn(32);
        disruptor = new UpdateDisruptor();
        disruptor.setMessageHandler(messageHandler);
        disruptor.setDisruptorProperties(disruptorProps);
    }

    @Test
    public void testProcessEvent() throws Exception {
        Update update = new Update();
        update.message = new Message();
        update.message.text = "Test text";

        disruptor.init();
        disruptor.processEvent(update);
        verify(messageHandler, times(1)).handle(update);
    }
}