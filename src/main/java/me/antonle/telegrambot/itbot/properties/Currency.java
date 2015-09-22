package me.antonle.telegrambot.itbot.properties;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum Currency {
    USDRUB("доллар", "RUB=X"),
    EURRUB("евро", "EURRUB=X");

    private String key;
    private String value;

    private static final Map<String, Currency> CURRENCY_MAP = new HashMap<>();

    static {
        for (Currency currency : CURRENCY_MAP.values()) {
            CURRENCY_MAP.put(currency.getKey(), currency);
        }
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
