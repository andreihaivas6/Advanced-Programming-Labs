public class School implements Comparable<School> {
    private String name;
    private int capacity;

    public School(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public int compareTo(School other) {
        if(other.getName() == null){
            return 0;
        }
        return this.getName().compareTo(other.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                '}';
    }
}
