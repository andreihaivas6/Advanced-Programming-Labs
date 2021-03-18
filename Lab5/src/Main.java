public class Main {

    public static void main(String[] args) throws Exception {
//        Song songWithBatPath = new Song("song2", "C:\\cantec", "xx");

        Catalog catalog = new Catalog("myCatalog");
        Song song1 = new Song("song1", "C:\\users\\andre\\Desktop\\testSong.mp3", "Ludovic");
        Book book1 = new Book("book1", "C:\\users\\andre\\Desktop\\testBook.pdf", "Robert", 2010);

        catalog.add(song1);
        catalog.add(book1);

        catalog.list();

//        catalog.play(song1);

        catalog.save();

        Catalog catalog2 = new Catalog("testLoad");
        catalog2.load("D:\\Facultate\\MATERII\\An 2 Sem2\\3. PA\\Laboratoare\\Lab5\\catalog.ser");
//        catalog2.list();
    }
}
