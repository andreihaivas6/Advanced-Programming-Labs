public class MovieGenre {
    private int idFilm;
    private int idGen;

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getIdGen() {
        return idGen;
    }

    public void setIdGen(int idGen) {
        this.idGen = idGen;
    }

    @Override
    public String toString() {
        return "TipFilme{" +
                "idFilm=" + idFilm +
                ", idGen=" + idGen +
                '}';
    }
}
