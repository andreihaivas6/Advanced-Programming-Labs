import java.util.*;

public class TravelPlan {
    public City city;
    private List <Location> preferences;

    public TravelPlan(City city, List<Location> preferences) {
        this.city = city;
        this.preferences = preferences;

//      avem adaugate toate arcele cu costuri in Map cost
//      eliminam arcele care merg de la o locatie spre o alta locatie din stanga acesteia (in lista preferintelor)
        for(int i = 0; i < preferences.size(); ++i){
            for(int j = 0; j < i; ++j){
                Location location = city.getNodes().get(i);
                location.getCost().remove(preferences.get(j));
            }
        }
    }

    public void solve(Location source, Location destination){
        dijkstra(source);
        List <Location> result = destination.getShortestPath();
        result.add(destination);

        System.out.println("\nDrumul minim este: ");
        for(int i = 0; i < result.size() - 1; ++i){
            System.out.print(result.get(i).getName() + " ->(" + result.get(i).getCost().get(result.get(i + 1)) + ")-> ");
        }
        System.out.println(destination.getName() + " = " + destination.getDistance() + ".");
    }

    public void dijkstra(Location source) {
        source.setDistance(0);

        Set<Location> noduriAlese = new HashSet<>(); // punem aici nodurile cu distanta cea mai mica la un moment dat
        Set<Location> noduriPosibile = new HashSet<>(); // noduri vecine ce ar putea sa fie alese ca avand cea mai mica distanta
        noduriPosibile.add(source);

        while (noduriPosibile.size() != 0) {
            Location nodMinim = null; // alegem nodul cu distanta minima
            int distantaMinima = Integer.MAX_VALUE;

            for (Location node: noduriPosibile) {
                if (node.getDistance() < distantaMinima) {
                    distantaMinima = node.getDistance();
                    nodMinim = node;
                }
            }

            for (Map.Entry <Location, Integer> vecin: nodMinim.getCost().entrySet()) { // cautam prin toti vecinii:
                Location nodVecin = vecin.getKey();

                if (!noduriAlese.contains(nodVecin)) { // calculam distanta si adaugam ca noduri posibile
                    noduriPosibile.add(nodVecin);
                    calculeazaDistanta(nodMinim, nodVecin, vecin.getValue());
                }
            }

            // mutam nodul
            noduriPosibile.remove(nodMinim);
            noduriAlese.add(nodMinim);
        }
    }


    public Boolean respectaPreferinta(Location location1, Location location2){
        return preferences.indexOf(location1) < preferences.indexOf(location2);
    }

    // calculeaza distanta nodului vecin = distanta nod curent + cost(nod curent, nod vecin)
    public void calculeazaDistanta(Location nodMinim, Location nodVecin, int costArc) {
        int distantaNodMinim = nodMinim.getDistance();
        int distantaNodVecin = nodVecin.getDistance();
        int distantaNoua = distantaNodMinim + costArc;

        // prioritatea e sa gasim drumul minim, daca gasim 2 drumuri de cost egal atunci verificam preferinta turistului
        if ((distantaNoua < distantaNodVecin) || ((distantaNoua == distantaNodVecin) && respectaPreferinta(nodMinim, nodVecin))) {
            nodVecin.setDistance(distantaNoua);

            // actualizam drumul
            List<Location> newPath = new LinkedList<>(nodMinim.getShortestPath());
            newPath.add(nodMinim);
            nodVecin.setShortestPath(newPath);
        }
    }


    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Location> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Location> preferences) {
        this.preferences = preferences;
    }
}
