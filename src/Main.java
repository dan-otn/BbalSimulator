import BBallUtils.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();
        player1.setSalaryThisSeason(100000);
        player1.setName("Jordan Poole");

        player1.stats = new HashMap<>();
        player1.stats.put("ppg", 20F);
        player1.stats.put("rpg", 3F);
        player1.stats.put("apg", 4F);
        player1.stats.put("to", 2.1F);

        Player player2 = new Player();
        player2.setSalaryThisSeason(1000000);
        player2.setName("Jason Tatum");

        player2.stats = new HashMap<>();
        // TODO: add exception for absent keys
        // System.out.println(player1.statByAttribute("benchMinutes"));

        Team team1 = new Team();
        team1.teamName = "Washington Wizzards";

        team1.addPlayerToRoster(player1);
        team1.addPlayerToRoster(player1);
        team1.addPlayerToRoster(player1);
        team1.addPlayerToRoster(player1);
        team1.addPlayerToRoster(player1);
        team1.addPlayerToRoster(player2);

        System.out.println(team1.getBudget());

        team1.formStartingFive();

        team1.printRoster(true);
        team1.printRoster(false);


    }
}