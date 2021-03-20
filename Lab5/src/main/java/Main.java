import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
          // Compulsory
//
//        Song songWithBatPath = new Song("song2", "C:\\cantec", "xx");
//
//        Catalog catalog = new Catalog("myCatalog");
//        Song song1 = new Song("song1", "C:\\users\\andre\\Desktop\\testSong.mp3", "Ludovic");
//        Book book1 = new Book("book1", "C:\\users\\andre\\Desktop\\testBook.pdf", "Robert", 2010);
//
//        catalog.add(song1);
//        catalog.add(book1);
//
//        catalog.list();
//
//        catalog.play("song1");
//
//        catalog.save("C:\\users\\andre\\Desktop\\catalog.ser");
//
//        Catalog catalog2 = new Catalog("testLoad");
//        catalog2.load("C:\\users\\andre\\Desktop\\catalog.ser");
//        catalog2.list();

        // Optional
        Catalog catalog = new Catalog("myCatalog");
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Introdu comanda:\n---> ");
            // add Song numeSong C:\\users\\andre\\Desktop\\testSong.mp3 Ludovic
            // add Book numeBook C:\\users\\andre\\Desktop\\testBook.pdf Robert 2010
            // list
            // save C:\\users\\andre\\Desktop\\catalog.ser
            // load C:\\users\\andre\\Desktop\\catalog.ser
            // play numeSong
            // report

            String line = scanner.nextLine();
            String[] result = line.split("\\s+");    /* \\s+ ->  ' '+ */

            String comanda = result[0];
            List<String> arguments = new ArrayList<>(Arrays.asList(result));
            arguments.remove(0);

            Command command;
            switch (comanda) {
                case "add"  : command = new AddCommand (arguments); break;
                case "list" : command = new ListCommand(arguments); break;
                case "play" : command = new PlayCommand(arguments); break;
                case "save" : command = new SaveCommand(arguments); break;
                case "load" : command = new LoadCommand(arguments); break;
                case "report" : command = new ReportCommand(arguments); break;
                default: throw new InvalidException("Comanda nu exista");
            }

            command.run(catalog);
            System.out.println("Comanda executata cu succes.");

        } while(true);

        // mvn package
        // java -jar Lab5-1.0-SNAPSHOT.jar
    }
}
