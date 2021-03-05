public class Restaurant extends Location implements Classifiable{
    private int rank;

    public Restaurant(String name) {
        super(name);
    }

    @Override
    public int getRank() {
        return rank;
    }

    @Override
    public void setRank(int rank) {
        this.rank = rank;
    }
}
