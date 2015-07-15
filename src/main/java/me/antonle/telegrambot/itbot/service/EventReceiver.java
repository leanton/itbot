package me.antonle.telegrambot.itbot.service;

import me.antonle.telegrambot.itbot.BotProperties;
import me.antonle.telegrambot.itbot.telegram.model.Update;
import me.antonle.telegrambot.itbot.telegram.model.Updates;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class EventReceiver {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private BotProperties botProperties;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MessageHandlerService messageHandler;

    private AtomicLong eventID = new AtomicLong(0L);
    private String getUpdatesURI = null;

    private static final Logger LOG = Logger.getLogger(EventReceiver.class);

    @PostConstruct
    public void init() {
        try {
            getUpdatesURI = botProperties.getApi() + "/getUpdates";
        } catch (NullPointerException e) {
            LOG.error("Token not found, failed to create request");
            e.printStackTrace();
            throw new BeanInitializationException("Failed to initialize EventReceiver");
        }
    }

    @Scheduled(fixedRate = 2000L)
    public void handleEvents() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getUpdatesURI)
                .queryParam("offset", eventID.get());
        HttpEntity<Object> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Updates> responseEntity = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, httpEntity, Updates.class);
        Updates updates = responseEntity.getBody();
        for (Update update : updates.result) {
            LOG.info("Received update: " + update);
            messageHandler.handle(update);
            eventID.set(update.updateID + 1);
        }
    }
}
