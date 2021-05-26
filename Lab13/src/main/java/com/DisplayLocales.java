package com;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales {
    public static void displayLocales(ResourceBundle resourceBundle){
        System.out.println(resourceBundle.getString("locales"));
        for(Locale locale : Locale.getAvailableLocales()){
            if(!locale.getDisplayCountry().equals("")) {
                System.out.println("Country: " + locale.getDisplayCountry() +
                        " has language: " + locale.getDisplayLanguage(locale));
            }
        }
    }
}
