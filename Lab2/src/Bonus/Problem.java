package Bonus;

import java.util.Arrays;
import java.util.Vector;

public class Problem {
    protected Vector<Source> sources = new Vector<>();
    protected Vector<Destination> destinations = new Vector<>();
    protected int[][] costs;

    public Problem() { }

    public Problem(int[][] costs) {
        this.costs = costs;
    }

    public void setCosts(int[][] costs) {
        this.costs = costs;
    }

    public void setSources(Vector<Source> sources) {
        this.sources = sources;
    }

    public void setDestinations(Vector<Destination> destinations) {
        this.destinations = destinations;
    }

    public int[][] getCosts() {
        return costs;
    }

    public Vector<Source> getSources() {
        return sources;
    }

    public Vector<Destination> getDestinations() {
        return destinations;
    }

    public int getCost(int i, int j) {
        return costs[i][j];
    }

    public Source getSource(int index) {
        return sources.get(index);
    }

    public Destination getDestination(int index) {
        return destinations.get(index);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Problem {" +
                "\nsources = " + sources +
                ", \ndestinations = " + destinations +
                ", \ncost = [");

        for (int[] line : costs) // afisam randurile din matrice pe rand
            s.append(Arrays.toString(line));
        s.append("]}");

        return s.toString();
    }

    public void addSource(Source s) {
        for (Source source : sources) { // verificam existenta sursei
            if (source.equals(s)) {
                return;
            }
        }
        sources.add(s);
    }

    public void addDestination(Destination d) {
        for (Destination destination : destinations) { // verificam existenta destinatiei
            if (destination.equals(d)) {
                return;
            }
        }
        destinations.add(d);
    }
}

