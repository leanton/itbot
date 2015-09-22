package me.antonle.telegrambot.itbot.service;

import me.antonle.telegrambot.itbot.properties.BotProperties;
import me.antonle.telegrambot.itbot.properties.Currency;
import me.antonle.telegrambot.itbot.telegram.model.Update;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import yahoofinance.YahooFinance;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Service
public class MessageHandlerService {

    @Bean(name = "senderRestTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    private static final Logger LOG = Logger.getLogger(MessageHandlerService.class);

    @Resource(name = "senderRestTemplate")
    private RestTemplate restTemplate;
    @Autowired
    private BotProperties botProperties;
    private String sendMessageURI;

    @PostConstruct
    public void init() {
        sendMessageURI = botProperties.getApi() + "/sendMessage";
    }

    public void handle(Update update) {
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("chat_id", update.message.chat.id);
        form.add("text", encodeCyrillic(generateReply(update.message.text)));
        form.add("cyrillic_text", generateReply(update.message.text));
        form.add("reply_to_message_id", update.message.messageID);
        restTemplate.postForLocation(sendMessageURI, form);
        LOG.info("Sent reply: " + form);
    }

    String generateReply(String text) {
        if (text.toLowerCase().contains("не пашет")) {
            return "ПАШИ СУКА";
        }
        Currency currency = Currency.containCurrency(text);
        if (currency != null) {
            StringBuilder stringBuilder = new StringBuilder(currency.getKey()).append(" нынче по ");
            String price = null;
            try {
                price = YahooFinance.getFx(currency.getValue()).getPrice().toString();
            } catch (IOException e) {
                LOG.error("Error getting FX rate for " + currency.getValue());
                e.printStackTrace();
                price = "хрен знает сколько";
            }
            stringBuilder.append(price);
            return stringBuilder.toString();
        }
        return "Посоны, мы пока в КС играем, сорян!";
    }

    private String encodeCyrillic(String reply) {
        String value = null;
        try {
            byte bytes[] = reply.getBytes("UTF-8");
            value = new String(bytes, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            LOG.error("Failed to encode to ISO-8859-1");
            e.printStackTrace();
        }
        return value;
    }
}
