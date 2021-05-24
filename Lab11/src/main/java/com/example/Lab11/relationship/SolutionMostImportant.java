package com.example.Lab11.relationship;

import com.example.Lab11.person.Person;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionMostImportant {
    private final int nrNodes;
    private List<Integer>[] listaAdiacenta;
    int time = 0;
    private List<Pair<Integer, Integer>> punti = new ArrayList<>();

    public SolutionMostImportant(int nrNodes, List<Relationship> relationships) {
        this.nrNodes = nrNodes;
        listaAdiacenta = new ArrayList[nrNodes];
        for (int i = 0; i < nrNodes; ++i) {
            listaAdiacenta[i] = new ArrayList<>();
        }

        for (Relationship relationship : relationships) {
            int i = relationship.getIdPerson1().intValue() - 1;
            int j = relationship.getIdPerson2().intValue() - 1;
            listaAdiacenta[i].add(j);
            listaAdiacenta[j].add(i);
        }
    }

    public List<Person> gasestePunti(RelationshipRepository relationshipRepository) {
        boolean[] vizitat = new boolean[nrNodes];
        int[] descoperire = new int[nrNodes]; // cand a fost descoperit
        int[] low = new int[nrNodes]; // cea mai mica valoare
        int[] parent = new int[nrNodes];

        for (int i = 0; i < nrNodes; i++) {
            parent[i] = -1;
            vizitat[i] = false;
        }

        for (int i = 0; i < nrNodes; i++) {
            if (!vizitat[i]) {
                dfs(i, vizitat, descoperire, low, parent);
            }
        }

        // sunt puncte de articulatie doar capetele puntilor ce au mai mult de un vecin
        // (ca sa aiba ce sa deconecteze dupa stergere)
        Set<Person> result = new HashSet<>();
        for(Pair<Integer, Integer> pair : punti) {
            System.out.println(pair.getKey() + " " + pair.getValue());
            if(listaAdiacenta[pair.getKey()].size() > 1) {
                result.add(relationshipRepository.getPersonsWithId(pair.getKey().longValue() + 1));
            }
            if(listaAdiacenta[pair.getValue()].size() > 1) {
                result.add(relationshipRepository.getPersonsWithId(pair.getValue().longValue() + 1));
            }
        }
        return new ArrayList<>(result);
    }

    // Tarjan
    private void dfs(int node, boolean[] vizitat, int[] descoperire, int[] low, int[] parent) {
        vizitat[node] = true;
        descoperire[node] = low[node] = ++time;

        for (int v : listaAdiacenta[node]) {
            if (!vizitat[v]) { // daca nu am fost in 'v' il facem copil al lui 'node' si continuam recursia
                parent[v] = node;
                dfs(v, vizitat, descoperire, low, parent);

                low[node] = Math.min(low[node], low[v]); // subarborele lui 'v' se conecteaza cu stramosii lui 'node'

                if (low[v] > descoperire[node]) { // avem punte daca cea mai mica valoare din subarborele lui 'v' este mai mica decat 'node'
                    punti.add(new Pair<>(node, v));
                }
            }

            else if (v != parent[node]) { // verificam daca nu a aparut o noua valoare minima
                low[node] = Math.min(low[node], descoperire[v]);
            }
        }
    }
}