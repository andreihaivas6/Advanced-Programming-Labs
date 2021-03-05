import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class Location { // implements Comparable <Location> {
    private String name;
    private Map <Location, Integer> cost = new HashMap<>();

    private int distance = Integer.MAX_VALUE;
    private List<Location> shortestPath = new LinkedList<>();


    public Location(String name) {
        this.name = name;
    }

    public void putCost(Location location, int value) {
        cost.put(location, value);
    }

//    public static int compareByName(Location location1, Location location2) {
//        if(location1.getName() == null)
//            return 0;
//        return location1.getName().compareTo(location2.getName());
//    }

    public static int compareByOpeningHour(Location location1, Location location2){
        if((location1 instanceof Visitable) && (location2 instanceof Visitable)) {
            if(((Visitable) location1).getOpeningTime() == null)
                return 0;
            return ((Visitable) location1).getOpeningTime().compareTo(((Visitable) location2).getOpeningTime());
        }
        return 0;
    }

//    @Override
//    public int compareTo(Location o) {
//        return 0;
//    }

    public String getName() {
        return name;
    }

    public Map<Location, Integer> getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Map<Location, Integer> cost) {
        this.cost = cost;
    }

    public List<Location> getShortestPath() {
        return shortestPath;
    }

    public int getDistance() {
        return distance;
    }

    public void setShortestPath(List<Location> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }


    @Override
    public String toString() {
        StringBuilder string= new StringBuilder("Location {" +  "name = " + name + " cost: ");
        for(Map.Entry <Location, Integer> i : cost.entrySet()){
            string.append(i.getKey().getName()).append("->").append(i.getValue()).append(", ");
        }
        string.append("}");
        return string.toString();
    }
}
