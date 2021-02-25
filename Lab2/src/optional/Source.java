package optional;

import java.util.Objects;

public abstract class Source {
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
        return "Source {" +
                "name = '" + name + '\'' +
                ", type = " + type +
                ", supply = " + supply +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return supply == source.supply && Objects.equals(name, source.name) && type == source.type;
    }

}
