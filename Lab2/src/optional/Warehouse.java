package optional;

public class Warehouse extends Source {
    public Warehouse(String name, int supply) {
        super(name, SourceType.WAREHOUSE, supply);
    }
}
