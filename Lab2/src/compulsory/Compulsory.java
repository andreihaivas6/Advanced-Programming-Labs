package compulsory;

public class Compulsory {
    public static void main(String[] args) {
        Source source1 = new Source("S1", SourceType.FACTORY, 10);
        Source source2 = new Source("S2", SourceType.WAREHOUSE, 35);
        Source source3 = new Source("S3", SourceType.WAREHOUSE, 25);

        Destination destination1 = new Destination("D1", 20);
        Destination destination2 = new Destination("D2", 25);
        Destination destination3 = new Destination("D3", 25);

        int[][] cost = {
                {2, 3, 1},
                {5, 4, 8},
                {5, 6, 8}
        };
        Problem problem1 = new Problem(3, 3, cost);

        System.out.println(source1.toString());
        System.out.println(source2.toString());
        System.out.println(source3.toString());
        System.out.println(destination1.toString());
        System.out.println(destination2.toString());
        System.out.println(destination3.toString());
        System.out.println(problem1.toString());
    }
}
