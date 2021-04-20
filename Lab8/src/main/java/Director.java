public class Director extends Person{

    public Director() {
        setDiscriminant(2);
    }

    public Director(int id, String nume, String prenume) {
        super(id, nume, prenume);
        setDiscriminant(2);
    }

    @Override
    public String toString() {
        return "Director" + super.toString();
    }
}
