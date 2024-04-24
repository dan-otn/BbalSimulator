package BBallUtils;

import java.util.*;

public class Team {
    public String teamName;

    private Float totalBudget = 0F;
    // TODO: replace roster list to priority que
    private ArrayList<Player> roster = new ArrayList<>();
    private List<Player> startingFive = new ArrayList<>();

    public float getBudget() {
        return totalBudget;
    }

    public void addPlayerToRoster(Player playerForAdd) {
        roster.add(playerForAdd);
        totalBudget += playerForAdd.getSalaryThisSeason();
        System.out.printf("%s joined %s team.%n", playerForAdd.getName(), teamName);
    }

    public void printRoster(Boolean startFiveOnly) {
        if (startFiveOnly) {
            System.out.printf("Starting five of %s:%n", teamName);
            for (Player player: startingFive) {
                System.out.println(player.getName());
            }
        }
        else {
            System.out.printf("Roster of %s:%n", teamName);
            for (Player player: roster) {
                System.out.println(player.getName());
            }
        }
    }

    public void formStartingFive() {
        // TODO: exception if roster.length < 5
        // TODO: replace slice to python-like heapq.topk
        startingFive = roster.subList(0, 5);
    }

    public List<Player> getStartingFive() {
        return startingFive;
    }
}
