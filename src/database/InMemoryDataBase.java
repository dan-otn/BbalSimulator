package database;

import database.entity.Player;
import database.entity.Team;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * @author FLIGHT
 */

public class InMemoryDataBase implements DataBase {

  private final Random random = new Random();

  private final List<Player> players;

  private final List<Team> teams;

  public InMemoryDataBase(List<Player> players, List<Team> teams) {
    this.players = players;
    this.teams = teams;
  }

  @Override
  public Player teamBestPlayer(Team team) {
    return players.stream()
      .filter(player -> player.team().equals(team))
      .max(Comparator.comparing(Player::overallRating))
      .orElseThrow(RuntimeException::new);
  }

  @Override
  public Team selectRandomTeam() {
    return teams.get(random.nextInt(teams.size()));
  }
}
