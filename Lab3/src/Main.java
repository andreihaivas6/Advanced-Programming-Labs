import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Compulsory
        City city = new City("Nume Oras");

        Hotel hotel1 = new Hotel("v1");
        Museum museum1 = new Museum("v2");
        Museum museum2 = new Museum("v3");
        Church church1 = new Church("v4");
        Church church2 = new Church("v5");
        Restaurant restaurant1 = new Restaurant("v6");

        hotel1.putCost(museum1, 10);
        hotel1.putCost(museum2, 50);

        museum1.putCost(museum2, 20);
        museum1.putCost(church1, 20);
        museum1.putCost(church2, 10);

        museum2.putCost(church1, 20);

        church1.putCost(church2, 30);
        church1.putCost(restaurant1, 10);

        church2.putCost(restaurant1, 20);

        church2.putCost(hotel1, 10); // TEST eliminare arce ce nu respecta lista preferintelor

        city.addLocation(hotel1);
        city.addLocation(museum1);
        city.addLocation(museum2);
        city.addLocation(church1);
        city.addLocation(church2);
        city.addLocation(restaurant1);

        System.out.println(city.toString());
        System.out.println();

        // Optional
        city.visitableNotPayable();

        long durata = Visitable.getVisitingDuration(church1.getOpeningTime(), church1.getClosingTime()).getSeconds();
        System.out.println("\nDurata: " + durata / 3600 + " ore si " + (durata % 3600) / 60 + " minute.");

        TravelPlan plan1 = new TravelPlan(city,
                new ArrayList<>(Arrays.asList(hotel1, museum1, museum2, church1, church2, restaurant1)));
        System.out.println();
        System.out.println(plan1.getCity().toString());

        plan1.solve(hotel1, restaurant1);
    }
}
