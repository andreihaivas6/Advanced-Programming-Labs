package compulsory;

import java.util.Arrays;

public class Problem {
    private int nrSources, nrDestinations;
    private int[][] cost;

    public Problem(int nrSources, int nrDestinations, int[][] cost) {
        this.nrSources = nrSources;
        this.nrDestinations = nrDestinations;
        this.cost = cost;
    }

    public void setNrSources(int nrSources) {
        this.nrSources = nrSources;
    }

    public void setNrDestinations(int nrDestinations) {
        this.nrDestinations = nrDestinations;
    }

    public void setCost(int[][] cost) {
        this.cost = cost;
    }

    public int getNrSources() {
        return nrSources;
    }

    public int getNrDestinations() {
        return nrDestinations;
    }

    public int[][] getCost() {
        return cost;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("compulsory.Problem {" +
                "nrSources = " + nrSources +
                ", nrDestinations = " + nrDestinations +
                ", cost = [");

        for (int[] line : cost)
            s.append(Arrays.toString(line));
        s.append("]}");

        return s.toString();
    }
}

