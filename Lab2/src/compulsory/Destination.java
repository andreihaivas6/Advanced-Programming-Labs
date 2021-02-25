package compulsory;

public class Destination {
    private String name;
    private int demand;

    public Destination(String name, int demand) {
        this.name = name;
        this.demand = demand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public String getName() {
        return name;
    }

    public int getDemand() {
        return demand;
    }

    @Override
    public String toString() {
        return "compulsory.Destination {" +
                "name = '" + name + '\'' +
                ", demand = " + demand +
                '}';
    }
}
