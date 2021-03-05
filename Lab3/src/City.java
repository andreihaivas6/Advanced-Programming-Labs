import java.util.ArrayList;
import java.util.List;

public class City{
    /**
     * Graful va fi unul aciclic pentru a modela preferintele turistului:
     * -> Dupa ce a vizitat o locatie, nu are voie sa viziteze alta din stanga ei (in lista preferintelor).
     *
     * In map-ul cu costuri al unei locatii, vom avea doar locatii care se afla in dreapta acesteia (in lista preferintelor).
     */

    private String name;
    private List <Location> nodes = new ArrayList<>();

    public City(String name) {
        this.name = name;
    }

    public void addLocation(Location node) {
        nodes.add(node);
    }

    public void visitableNotPayable(){
        List <Location> result = new ArrayList<>();
        for(Location location : nodes){
            if((location instanceof Visitable) && !((location instanceof Payable))){
                result.add(location);
            }
        }

        result.sort(Location::compareByOpeningHour);
        System.out.println("Locatii care sunt Visitable si nu sunt Payable:");
        for(Location location : result)
            System.out.println(location);

//        result.sort((location1, location2) -> {
//            if((location1 instanceof Visitable) && (location2 instanceof Visitable)) {
//                if(((Visitable) location1).getOpeningTime() == null)
//                    return 0;
//                return ((Visitable) location1).getOpeningTime().compareTo(((Visitable) location2).getOpeningTime());
//            }
//            return 0;
//        });
    }

    public String getName() {
        return name;
    }

    public List<Location> getNodes() {
        return nodes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNodes(List<Location> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "City {" +
                "name = '" + name + '\'' +
                ", nodes = " + nodes +
                '}';
    }
}
