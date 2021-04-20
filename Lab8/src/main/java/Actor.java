public class Actor extends Person{

    public Actor() {
        setDiscriminant(1);
    }

    public Actor(int id, String nume, String prenume) {
        super(id, nume, prenume);
        setDiscriminant(1);
    }

    @Override
    public String toString() {
        return "Actor" + super.toString();
    }
}
