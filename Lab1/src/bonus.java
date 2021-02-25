import java.util.*;

public class bonus {
    public static void main(String[] args) {
        //int n = (int)(Math.random() * 10) + 1;  // alegem numar de noduri
        int n = 10;
        int[][] mat = new int[n][n];
        for(int i = 0; i < n; ++i)
            mat[i][i] = 1;

        Vector <Integer> noduri = new Vector<>(); // nodurile care inca nu au fost puse
        Vector <Integer> noduriAlese = new Vector<>(); // nodurile care au fost puse la arbore
        for(int i = 0; i < n; ++i)
            noduri.add(i);

        // alegem un nod radacina
        int ind = (int)(Math.random() * noduri.size());
        int root = noduri.get(ind);
        noduri.removeElement(root);
        noduriAlese.add(root);

        for(int i = 0; i < n - 1; ++i) // alegem n - 1 muchii (implicit si cele n - 1 noduri ramase => conex)
        {
            // alegem un nod care nu e inca in arbore
            int ind1 = (int)(Math.random() * noduri.size());
            int k1 = noduri.get(ind1);

            // alegem un nod care e in arbore
            int ind2 = (int)(Math.random() * noduriAlese.size());
            int k2 = noduriAlese.get(ind2);

            // o muchie de la arbore la un nod izolat nu genereaza cicluri
            mat[k1][k2] = mat[k2][k1] = 1;
            noduri.removeElement(k1);
            noduriAlese.add(k1);
        }

        optional.printMat(mat, n);
        boolean[] vizitat = new boolean[n];
        Arrays.fill(vizitat, false);
        DFS(root, n, 0, vizitat, mat);
    }

    public static void DFS(int k, int n, int h, boolean[] vizitat, int[][] mat)
    {
        for(int j = 0; j < 3 * h; ++j) // h = adancimea nodului curent
            System.out.print(" ");
        System.out.println("|-> " + k);

        vizitat[k] = true;
        for(int i = 0; i < n; ++i)
            if(mat[i][k] == 1 && !vizitat[i])
                DFS(i, n, h + 1,  vizitat, mat);
    }
}
