package optional;

public class Solution extends Problem{
    private int totalCost;
    private int[][] units; /*
        - pe linii avem sursele
        - pe coloane avem destinatiile
        - units[i][j] = numarul de unitati trasnportate de la sursa i la destinatia j
    */

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
}
