package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Messages", Locale.getDefault());

        boolean stop = false;
        do {
            System.out.print(resourceBundle.getString("prompt"));
            String command = scanner.nextLine();

            switch (command.split(" ")[0]) {
                case "getLocales" : DisplayLocales.displayLocales(resourceBundle); break;
                case "setLocale"  : resourceBundle = SetLocale.setLocale(command.split(" ")[1], resourceBundle); break;
                case "getInfo"    : Info.displayInfo(resourceBundle); break;
                case "exit"       : stop = true; break;
                default           : System.out.println(resourceBundle.getString("invalid")); break;
            }
        } while (!stop);
    }
}
