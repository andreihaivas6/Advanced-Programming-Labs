import java.util.*;

public class Bonus extends TravelPlan {
    private int[][] graf;

    public Bonus(City city, List<Location> preferences) {
        super(city, preferences);
    }

    public void solveBonus() {
        this.createMatrix();
        this.simulatedAnnealing();
    }

    public void createMatrix() {
        int dimensiune = super.getCity().getNodes().size();
        graf = new int[100][100];

        for (Location location : super.getCity().getNodes()) {
            int i = Integer.parseInt(location.getName().substring(1));
            for (Map.Entry<Location, Integer> pair : location.getCost().entrySet()) {
                Location destinatie = pair.getKey();
                int j = Integer.parseInt(destinatie.getName().substring(1));
                graf[i][j] = pair.getValue();
            }
        }
    }


    double evaluate(List<Integer> list) {
        double rez = 0;
        int dimensiune = super.getCity().getNodes().size();
        for (int i = 0; i < dimensiune - 1; i++)
            rez += graf[list.get(i)][list.get(i + 1)];
        return rez + graf[list.get(dimensiune - 1)][list.get(0)];
    }

    public Boolean respectaPreferinta(Location location1, Location location2){
        return super.getPreferences().indexOf(location1) < super.getPreferences().indexOf(location2);
    }

    public void simulatedAnnealing() {
        double minim = Double.MAX_VALUE;

        for (int j = 0; j < 30; ++j) {
            int it;
            int stop = 300; // iteratii bucla interioara
            double temperatura = 1000; // temperatura initiala
            int dimensiune = super.getCity().getNodes().size() ;

            Integer[] list1 = new Integer[dimensiune + 1];
            Integer[] list2 = new Integer[dimensiune + 1];
            double evaluateList1, evaluateList2;

            for (int i = 0; i < dimensiune; ++i) { // initializare vectori
                list1[i] = (int) (Math.random() * dimensiune - 1);
                list2[i] = (int) (Math.random() * dimensiune - 1);
            }
            do { // cat timp nu a scazul temperatura suficient
                it = 0;
                do { // cautam vecini care dau un rezultat mai bun
                    compute(Arrays.asList(list1), Arrays.asList(list2));
                    evaluateList1 = evaluate(Arrays.asList(list1)); // vn
                    evaluateList2 = evaluate(Arrays.asList(list2)); // vc

                    if (evaluateList1 < evaluateList2) { // vecin mai bun?
                        list2 = list1;
                    } else { // altfel verificam probabilitatea
                        double randNumber = Math.random();
                        double val = Math.exp(-Math.abs(evaluateList1 - evaluateList2) / temperatura);
                        if (randNumber < val) {
                            list2 = list1;
                        }
                    }
                } while (++it < stop);

                temperatura *= 0.9999;
            } while (temperatura > 10e-8);

            double eval = evaluate(Arrays.asList(list2));
            minim = Math.min(minim, eval);
        }
        System.out.println("Valoarea drumului minim: " + minim);
    }

    void compute(List<Integer> list1, List<Integer> list2) {
        int dimensiune = super.getCity().getNodes().size();
        int r1 = (int) (Math.random() * dimensiune);
        int r2 = (int) (Math.random() * dimensiune);
        list1 = list2;

        int aux = list1.get(r1);
        list1.set(r1, r2);
        for (int i = 0; i < dimensiune; i++)
            if (i != r1 && list1.get(i) == r2)
                list1.set(i, aux);
    }

    public int[][] getGraf() {
        return graf;
    }

    public void setGraf(int[][] graf) {
        this.graf = graf;
    }
}
