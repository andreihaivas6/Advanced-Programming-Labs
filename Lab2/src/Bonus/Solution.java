package Bonus;

import java.util.Arrays;

public class Solution extends Problem {
    private int totalCost;
    private int[][] units; /*
        - pe linii avem sursele
        - pe coloane avem destinatiile
        - units[i][j] = numarul de unitati trasnportate de la sursa i la destinatia j
    */
    boolean[] rowCut;
    boolean[] colCut;

    public Solution(Problem problem){
        super.setSources(problem.getSources());
        super.setDestinations(problem.getDestinations());
        super.setCosts(problem.getCosts());
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public void setUnits(int[][] units) {
        this.units = units;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public int[][] getUnits() {
        return units;
    }

    public void solve()
    {
        totalCost = 0;
        units = new int[super.getSources().size()][super.getDestinations().size()];

        int i = 0, j = 0;
        int supply = 0, demand = 0;
        /*
             strategie Greedy:
             cat timp nu am ajuns la finalul matricii de costuri
                luam sursele in ordine si livram cat de mult incape spre destinatii in ordine (ignorand costurile)
        */

        while (i < super.getSources().size() && j < super.getDestinations().size()) {
            // daca spatiul sau cererea sunt 0, trecem la urmatoarea sursa/destinatie
            if(supply == 0) {
                supply = super.getSource(i).getSupply();
            }
            if(demand == 0) {
                demand = super.getDestination(j).getDemand();
            }

            // daca destinatia cere mai putin decat incape -> scadem din supply si verificam si urmatoarea destinatie
            if (supply > demand) {
                units[i][j] = demand;
                totalCost += super.getCost(i, j) * units[i][j];
                supply -= demand;
                demand = 0;
                j++;
            }
            // daca sursa curenta nu satisface cererea destinatiei -> scadem din cerere si verificam urmatoarea sursa
            else if (supply < demand) {
                units[i][j] = supply;
                totalCost += super.getCost(i, j) * units[i][j];
                demand -= supply;
                supply = 0;
                i++;
            }
            // daca oferta satisface exact cerere -> trecem la urmatoarea sursa si urmatoarea destinatie
            else /* egalitate */ {
                units[i][j] = supply;
                totalCost += super.getCost(i, j) * units[i][j];
                supply = demand = 0;
                i++;
                j++;
            }
        }
    }

    public void solveBonus(){
        totalCost = 0;
        units = new int[getSources().size()][getDestinations().size()];

        // tinem evidenta liniilor si coloanelor 'taiate' (care au fost alese ca avand un cost minim la un moment dat)
        rowCut = new boolean[getSources().size()];
        colCut = new boolean[getDestinations().size()];
        Arrays.fill(rowCut, false);
        Arrays.fill(colCut, false);

        int supplyLeft = 0;
        for (int i = 0; i < getSources().size(); ++i) { // supply-ul total
            supplyLeft += super.getSources().get(i).getSupply();
        }

        while(supplyLeft > 0) { // cat timp mai avem de unde trimite
            int[] result = choosePenalty();
            int index0 = result[0];
            int index1 = result[1];

            // minimul dintre supply si demand de la pozitia (index0, index1)

            int supply = super.sources.get(index0).getSupply();
            int demand = super.destinations.get(index1).getDemand();
            int minim = Integer.min(supply, demand);

            // se realizeaza transportul de la sursa la destinatie,
            // deci scadem cat se transporta din supply si demand
            super.sources.get(index0).setSupply(supply - minim);
            super.destinations.get(index1).setDemand(demand - minim);

            // daca supply sau demand ajung 0 => stergem linia/coloana corespunzatoare
            if(supply == minim)
                rowCut[index0] = true;
            if(demand == minim)
                colCut[index1] = true;

            supplyLeft -= minim; // scadem din supply-ul total

            // pentru rezultat
            units[index0][index1] = minim;
            totalCost += minim * super.getCosts()[index0][index1];
        }
    }

    // array de forma [3] { diferenta in modul dintre cele mai mici 2 valori, valorea minima, pozitia minimului } de pe linie/coloana
    public int[] difference(boolean isRow, int index, int length) {
        int minim1 = Integer.MAX_VALUE, minim2 = Integer.MAX_VALUE;
        int minPoz = -1; // pozitia minimului

        for (int i = 0; i < length; ++i) {
            if((isRow && !colCut[i]) || (!isRow && !rowCut[i])) { // verificam daca linia/coloana a fost taiata
                int cost = (isRow) ? super.getCosts()[index][i] : super.getCosts()[i][index];
                if (cost < minim1) { // calculam cele mai mici 2 valori
                    minPoz = i;
                    minim2 = minim1;
                    minim1 = cost;
                } else if (cost < minim2) {
                    minim2 = cost;
                }
            }
        }
        int diferenta = minim2 - minim1;
        int[] ret = new int[] {diferenta, minim1, minPoz};
        return ret;
    }

    // array de forma [4] {index1, index2, cost minim, diferenta maxima}
    public int[] penalty(boolean isRow, int length2, int length1) {
        int minCost = -1, maxDiff = Integer.MIN_VALUE;
        int indexMinCost = -1, indexMaxDiff = -1;

        for (int i = 0; i < length1; ++i) {
            if((isRow && !rowCut[i]) || (!isRow && !colCut[i])) { // verificam daca linia/coloana a fost taiata
                int[] result = difference(isRow, i, length2);
                int differenta = result[0];

                if (differenta > maxDiff) { // daca gasim o diferenta mai mare
                    maxDiff = result[0];
                    minCost = result[1];
                    indexMaxDiff = i;
                    indexMinCost = result[2];
                }
            }
        }

        int[] result = new int[] {indexMaxDiff, indexMinCost, minCost, maxDiff};
        if (!isRow) { // daca nu suntem pe linie, interschimbam indexii
            result[0] = indexMinCost;
            result[1] = indexMaxDiff;
        }
        return result;

    }

    // alege penalty-ul dupa diferenta in modul (si daca e aceeasi, alege dupa costul minim)
    public int[] choosePenalty() {
        int[] result1 = penalty(true, super.getDestinations().size(), super.getSources().size());
        int[] result2 = penalty(false, super.getSources().size(), super.getDestinations().size());

        if (result1[3] == result2[3]) {
            if(result1[2] < result2[2]) {
                return result1;
            }
            return result2;
        }
        else {
            if (result1[3] > result2[3]) {
                return result2;
            }
            return result1;
        }
    }

}
