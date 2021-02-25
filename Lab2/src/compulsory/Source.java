package compulsory;

public class Source {
    private String name;
    private SourceType type;
    private int supply;

    public Source(String name, SourceType type, int supply) {
        this.name = name;
        this.type = type;
        this.supply = supply;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(SourceType type) {
        this.type = type;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    public String getName() {
        return name;
    }

    public SourceType getType() {
        return type;
    }

    public int getSupply() {
        return supply;
    }

    @Override
    public String toString() {
        return "compulsory.Source {" +
                "name = '" + name + '\'' +
                ", type = " + type +
                ", supply = " + supply +
                '}';
    }
}
