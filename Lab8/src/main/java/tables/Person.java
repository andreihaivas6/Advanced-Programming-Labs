package tables;

public abstract class Person {
    private int id;
    private String nume;
    private String prenume;
    private int discriminant;

    public Person() {}

    public Person(int id, String nume, String prenume) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getDiscriminant() {
        return discriminant;
    }

    public void setDiscriminant(int discriminant) {
        this.discriminant = discriminant;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", discriminant=" + discriminant +
                '}';
    }
}
