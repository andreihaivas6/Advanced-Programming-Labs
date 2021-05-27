import java.util.Arrays;
import java.util.Map;

public class StructuralCohesion {
    private int nrNoduri;
    private Map<Account, Integer> idAccount;
    private AccountsList accountsList;

    private int[][] matriceAdiacenta;

    public StructuralCohesion(int nrNoduri, Map<Account, Integer> idAccount, AccountsList accountsList) {
        this.nrNoduri = nrNoduri;
        this.idAccount = idAccount;
        this.accountsList = accountsList;
        createGraph();
    }

    public void createGraph() {
        matriceAdiacenta = new int[nrNoduri][nrNoduri];
        for(int i = 0; i < nrNoduri; ++i) {
            Arrays.fill(matriceAdiacenta[i], 0);
        }

        for(Account account : accountsList.getAccounts()) {
            for(Account accountFriend : account.getFriends()) {
                matriceAdiacenta[idAccount.get(account)][idAccount.get(accountFriend)] = 1;
            }
        }
    }

    public Integer solve() { // Lab5
        // Rezultatul este dat de (numarMinimDeCulori - 1)
        int nrColors = 0;
        int[] itemsColors = new int[nrNoduri];
        Arrays.fill(itemsColors, -1);

        itemsColors[0] = 0;
        nrColors = 1;

        for (int i = 1; i < nrNoduri; ++i) {
            boolean[] neighboursColors = new boolean[nrColors + 1]; // memoram ce culori au vecinii
            Arrays.fill(neighboursColors, false);

            for (int j = 0; j < nrNoduri; ++j) { // luam toti vecinii care au deja culori
                if (matriceAdiacenta[i][j] == 1 && itemsColors[j] != -1) {
                    neighboursColors[itemsColors[j]] = true;
                }
            }

            for (int k = 0; k < neighboursColors.length; ++k) { // cautam prima culoare disponibila
                if (!neighboursColors[k]) {
                    itemsColors[i] = k;
                    if (k == nrColors) {
                        nrColors++;
                    }
                    break;
                }
            }
        }

        return nrColors - 1;
    }
}
