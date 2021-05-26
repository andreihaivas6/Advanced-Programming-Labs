package com;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class SetLocale {
    public static ResourceBundle setLocale(String language, ResourceBundle resourceBundle) {
        Locale.setDefault(Locale.forLanguageTag(language));
        String message = resourceBundle.getString("locale.set");

        String output = new MessageFormat(message).format(new Locale[]{Locale.getDefault()});
        System.out.println(output);

        if (language.equals("ro")) {
            return ResourceBundle.getBundle("Messages_ro", Locale.getDefault());
        }
        return ResourceBundle.getBundle("Messages", Locale.getDefault());
    }
}
