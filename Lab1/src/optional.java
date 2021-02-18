import java.util.Arrays;
import java.util.Scanner;

public class optional {
    public static void main(String[] args) {
        long t1 = System.nanoTime(); // start cronometru

        // citire numar + validare
        int n;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.print("Numarul de noduri al grafului: ");
            n = scan.nextInt();
            if(n <= 0)
                System.out.println("Valoarea trebuie sa fie strict pozitiva.");
        }while(n <= 0);
        scan.close();

        // creare matrice
        int[][] mat = new int[n][n];
        double prob = 0.5;
        for(int i = 0; i < n; ++i)
        {
            mat[i][i] = 1;
            for(int j = i + 1; j < n; ++j)
                mat[i][j] = mat[j][i] = ((Math.random() < prob) ? 0 : 1);
        }

        // afisare matrice
        printMat(mat, n);

        // numarare componente conexe
        int nrCc = 0;
        int[][] cc = new int[n][n + 1];    // fiecare linie o comp conexa; cc[k][0] -> nr de noduri din comp k
        boolean[] vizitat = new boolean[n];
        Arrays.fill(vizitat, false);
        for(int i = 0; i < n; ++i)
            if(!vizitat[i])
            {
                cc[nrCc][0] = 0;
                DFS(i, n, mat, vizitat, nrCc, cc);
                nrCc++;
            }

        // verificare conexitate, afisare comp conexe
        if(nrCc == 1)
            System.out.println("Graful este conex.");
        else
        {
            for(int i = 0; i < nrCc; ++i)
            {
                System.out.print(i + 1 + ": ");
                for(int j = 1; j <= cc[i][0]; ++j)
                    System.out.print(cc[i][j] + " ");
                System.out.println();
            }
        }

        // crearea arbore partial
        if(nrCc == 1)
        {
            int[][] treeMat = new int[n][n];
            for (int i = 0; i < n; ++i)
            {
                Arrays.fill(treeMat[i], 0);
                treeMat[i][i] = 1;
            }
            Arrays.fill(vizitat, false);
            DFS(0, n, mat, vizitat, treeMat);
            printMat(treeMat, n);
        }

        // masurare timp executie
        long t2 = System.nanoTime();
        System.out.println("Timpul de executie al aplicatiei: " + (t2 - t1) + " nanosecunde.");
    }

    public static void printMat(int [][] mat, int n)
    {
        if(n >= 30_000)
            return;

        System.out.print("\u250C ");
        for(int i = 0; i < n + 1; ++i)
            System.out.print("\u2500 ");
        System.out.println("\u2510 ");
        System.out.print("\u2502   ");

        for(int i = 0; i < n; ++i)
            System.out.print(i + " ");
        System.out.print("\u2502");
        System.out.println();

        for(int i = 0; i < n; ++i)
        {
            System.out.print("\u2502 ");
            System.out.print(i + " ");

            for(int j = 0; j < n; ++j)
            {
                if(mat[i][j] == 0)
                    System.out.print(". ");
                else
                    System.out.print("\u25CF ");
            }

            System.out.print("\u2502");
            System.out.println();
        }

        System.out.print("\u2514 ");
        for(int i = 0; i < n + 1; ++i)
            System.out.print("\u2500 ");
        System.out.println("\u2518 ");
    }

    public static void DFS(int k, int n, int[][] mat, boolean[] vizitat, int nrCc, int[][] cc)
    {
        vizitat[k] = true;
        int lung = ++cc[nrCc][0];
        cc[nrCc][lung] = k;
        for(int i = 0; i < n; ++i)
            if(mat[i][k] == 1 && !vizitat[i])
                DFS(i, n, mat, vizitat, nrCc, cc);
    }

    public static void DFS(int k, int n, int[][] mat, boolean[] vizitat, int[][] treeMat)
    {
        vizitat[k] = true;
        for(int i = 0; i < n; ++i)
            if(mat[i][k] == 1 && !vizitat[i])
            {
                treeMat[k][i] = treeMat[i][k] = 1;
                DFS(i, n, mat, vizitat, treeMat);
            }
    }
}
