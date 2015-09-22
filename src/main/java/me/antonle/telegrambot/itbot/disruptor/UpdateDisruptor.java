package me.antonle.telegrambot.itbot.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import me.antonle.telegrambot.itbot.properties.UpdateDisruptorProperties;
import me.antonle.telegrambot.itbot.service.MessageHandlerService;
import me.antonle.telegrambot.itbot.telegram.model.Update;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
public class UpdateDisruptor {

    @Autowired
    private MessageHandlerService messageHandler;

    private Executor executor = Executors.newCachedThreadPool();
    private Disruptor<UpdateEvent> disruptor;
    @Autowired
    private UpdateDisruptorProperties disruptorProperties;

    private static final Logger LOG = Logger.getLogger(UpdateDisruptor.class);

    public UpdateDisruptor() {
    }

    private void handleEvent(UpdateEvent event, long sequence, boolean endOfBatch) {
        Update update = event.getUpdate();
        try {
            messageHandler.handle(update);
        } catch (IOException e) {
            LOG.error("Error handling update " + update);
            e.printStackTrace();
        }
    }

    private void translate(UpdateEvent event, long sequence, Update update) {
        event.setUpdate(update);
    }

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        disruptor = new Disruptor<>(UpdateEvent::new, disruptorProperties.getBufferSize(), executor);
        disruptor.handleEventsWith(this::handleEvent);
        disruptor.start();
        LOG.info("Disruptor is started successfully");
    }

    public void processEvent(Update update) {
        RingBuffer<UpdateEvent> ringBuffer = disruptor.getRingBuffer();
        ringBuffer.publishEvent(this::translate, update);
    }

    public void setMessageHandler(MessageHandlerService messageHandler) {
        this.messageHandler = messageHandler;
    }

    public void setDisruptorProperties(UpdateDisruptorProperties disruptorProperties) {
        this.disruptorProperties = disruptorProperties;
    }
}
