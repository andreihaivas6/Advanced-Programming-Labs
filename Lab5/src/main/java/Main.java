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

        boolean exit = false;
        do {
            System.out.print("Introdu comanda:\n---> ");
            // add Song numeSong C:\\users\\andre\\Desktop\\testSong.mp3 Ludovic
            // add Book numeBook C:\\users\\andre\\Desktop\\testBook.pdf Robert 2010
            // list
            // save catalog.ser
            // load catalog.ser
            // play numeSong
            // report
            // info

            String line = scanner.nextLine();
            String[] result = line.split("\\s+");    /* \\s+ ->  ' '+ */

            String comanda = result[0];
            List<String> arguments = new ArrayList<>(Arrays.asList(result));
            arguments.remove(0);

            Command command = null;
            switch (comanda) {
                case "add"    -> command = new AddCommand(arguments);
                case "list"   -> command = new ListCommand(arguments);
                case "play"   -> command = new PlayCommand(arguments);
                case "save"   -> command = new SaveCommand(arguments);
                case "load"   -> command = new LoadCommand(arguments);
                case "report" -> command = new ReportCommand(arguments);
                case "info"   -> command = new InfoCommand(arguments); // Bonus I
                case "exit"   -> exit = true;
                default       -> throw new InvalidException("Comanda nu exista");
            }
            if (exit) break;

            command.run(catalog);
            System.out.println("Comanda executata cu succes.");

        } while (true);
        // mvn package
        // java -jar Lab5-1.0-SNAPSHOT.jar


        // Bonus II
        GraphBonus graph = new GraphBonus(catalog);
        graph.createGraph();
        graph.solve();
        for(int[] line : graph.getMatriceAdiacenta()) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println(graph);
        // Am testat grafuri mari in GraphBonusTest
    }
}


