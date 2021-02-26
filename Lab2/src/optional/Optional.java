package optional;

import java.util.Arrays;

public class Optional {
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
        solution.solve();

        for(int[] line : solution.getUnits()) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println("Total cost: " + solution.getTotalCost());
    }
}
