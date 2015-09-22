package me.antonle.telegrambot.itbot.properties;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum Currency {
    USDRUB("доллар", "RUB=X"),
    EURRUB("евро", "EURRUB=X");

    private String key;
    private String value;

    private static final Map<String, Currency> CURRENCY_MAP = Collections.unmodifiableMap(initialize());

    private static Map<String, Currency> initialize() {
        Map<String, Currency> map = new HashMap<>();
        for (Currency currency : Currency.values()) {
            map.put(currency.getKey(), currency);
        }
        return map;
    }


    Currency(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static Currency lookupCurrency(String key) {
        return CURRENCY_MAP.get(key);
    }

    public static Currency containCurrency(String text) {
        Set<String> keySet = CURRENCY_MAP.keySet();
        for (String s : keySet) {
            if (text.contains(s)) {
                return lookupCurrency(s);
            }
        }
        return null;
    }
}
