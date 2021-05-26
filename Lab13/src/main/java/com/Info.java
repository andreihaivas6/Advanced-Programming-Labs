package com;

import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class Info {
    public static void displayInfo(ResourceBundle resourceBundle) {
        String message = resourceBundle.getString("info");
        String output = new MessageFormat(message).format(new Locale[]{Locale.getDefault()});
        System.out.println(output);

        Locale locale = Locale.getDefault();
        System.out.println("Country: " + locale.getDisplayCountry(locale));
        System.out.println("Language: " + locale.getDisplayLanguage());
        System.out.println("Currency: " + NumberFormat.getCurrencyInstance(locale).getCurrency().getDisplayName());

        System.out.print("Week days : ");
        for(DayOfWeek day : DayOfWeek.values()) {
            System.out.print(day.getDisplayName(TextStyle.FULL, locale) + ", ");
        }
        System.out.println();

        String[] months = new DateFormatSymbols(locale).getMonths();
        System.out.println("Months: " + Arrays.toString(months));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(locale);
        System.out.println("Today : " + LocalDateTime.now().format(dateTimeFormatter));
    }
}
