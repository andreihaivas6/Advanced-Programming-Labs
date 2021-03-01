package Bonus;

import java.util.Arrays;

public class Bonus {
    /**
     * --- Doc comment ---
     */
    public static void main(String[] args) {
        int[][] cost = {
                {2, 3, 1},
                {5, 4, 8},
                {5, 6, 8}
        };
        Problem problem = new Problem(cost);

        problem.addSource(new Factory("S1", 10));
        problem.addSource(new Warehouse("S2", 35));
        problem.addSource(new Warehouse("S3", 25));

        problem.addDestination(new Destination("D1", 20));
        problem.addDestination(new Destination("D2", 25));
        problem.addDestination(new Destination("D3", 25));
        problem.addDestination(new Destination("D3", 25));

        System.out.println(problem.toString());

        Solution solution = new Solution(problem);
        solution.solveBonus();

        System.out.println();
        for(int[] line : solution.getUnits()) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println("Total cost: " + solution.getTotalCost());


        largeInstances();
    }

    public static void largeInstances(){
        // dimensiuni mari
        int n = 1_000, m = 1_000;

        // alegem costuri random
        int[][] costs = new int[n][m];
        for(int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                costs[i][j] = (int) (Math.random() * 10 + 1);
            }
        }
        Problem problem1 = new Problem(costs);

        // punem surse cu supply-uri random si retinem suma lor ca sa avem si aceeasi suma de demand-uri
        int totalSupply = 0;
        for(int i = 0; i < n; ++i) {
            int val = (int) (Math.random() * 50 + 1);
            problem1.addSource(new Factory("S" + i, val));
            totalSupply += val;
        }

        // punem destinatii cu demand-uri random, dar sa aiba suma egala cu suma supply-urilor
        for(int i = 0; i < m; ++i){
            int val = (int) (Math.random() * 50 + 1);
            if(val >= totalSupply){ // daca se termina supply-ul total, setam restul destinatiilor cu demand = 0
                problem1.addDestination(new Destination("D" + i, totalSupply));
                totalSupply = 0;
                for(++i; i < m; ++i){
                    problem1.addDestination(new Destination("D" + i, 0));
                }
                break;
            }
            problem1.addDestination(new Destination("D" + i, val));
            totalSupply -= val;
        }
        if(totalSupply > 0){ // in caz ca nu s-a ajuns la supply-ul total, adaugam la ultima destinatie valoarea ramasa
            int val = problem1.getDestinations().get(problem1.getDestinations().size() - 1).getDemand();
            problem1.getDestinations().get(problem1.getDestinations().size() - 1).setDemand(val + totalSupply);
        }

        Solution solution1 = new Solution(problem1);
        double t1 = System.currentTimeMillis();
        solution1.solveBonus();
        double t2 = System.currentTimeMillis();
        double spent = (t2 - t1) / 1e3;

        System.out.println();
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(solution1.getUnits()[i][j] != 0){
                    System.out.println("Sursa " + solution1.getSources().get(i).getName() + " merge spre Destinatia " +
                            solution1.getDestinations().get(j).getName() + " cu " + solution1.getUnits()[i][j] + " unitati"
                            + " si are costul " + solution1.getUnits()[i][j] * solution1.getCosts()[i][j] + ".");
                }
            }
        }

        System.out.println("Total cost: " + solution1.getTotalCost());
        System.out.println("Timp scurs: " + spent + " secunde.");

        Runtime runtime = Runtime.getRuntime();
        //runtime.gc(); // porneste Garbage Colector
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memorie utilizata: " + memory / (1024 * 1024.) + " MB");
    }
}
