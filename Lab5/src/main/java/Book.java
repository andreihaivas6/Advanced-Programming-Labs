public class Book extends Item {
    private String author;
    private int year;

    public Book(String name, String path, String author, int year) {
        super(name, path);
        this.author = author;

        if (year < 0 || year > 2021) {
            throw new InvalidException("An incorect.");
        }
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + super.getName() + '\'' +
                ", path='" + super.getPath() + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                "}\n";
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 0 || year > 2021) {
            throw new InvalidException("An incorect.");
        }
        this.year = year;
    }
}
