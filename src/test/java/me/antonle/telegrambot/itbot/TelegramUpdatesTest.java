package me.antonle.telegrambot.itbot;

import me.antonle.telegrambot.itbot.telegram.model.Message;
import me.antonle.telegrambot.itbot.telegram.model.Update;
import me.antonle.telegrambot.itbot.telegram.model.Updates;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ITTelegramBotApplication.class)
@WebAppConfiguration
public class TelegramUpdatesTest {

    @Autowired
    private BotProperties botProperties;

    private String updateUrl;

    @Before
    public void setUp() throws Exception {
        updateUrl = botProperties.getApi() + "/getUpdates";
    }

    @Test
    public void test_incomingUpdates() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> entity = restTemplate.getForEntity(updateUrl, String.class);
        System.out.println(entity);
    }

    @Test
    public void test_incomingUpdatesParsed() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.getForEntity(updateUrl, Updates.class);

        assertEquals(Updates.class, responseEntity.getBody().getClass());

        Updates updates = (Updates) responseEntity.getBody();

        assertEquals(updates.ok, true);

        for (Update update : updates.result) {
            Message message = update.message;
            System.out.println(message.from.firstName + " " + message.from.lastName + ": " + message.text);
        }
    }
}
