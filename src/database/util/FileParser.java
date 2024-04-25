package database.util;

import database.entity.Player;
import database.entity.Team;
import database.enums.PlayerHeader;
import database.enums.TeamHeader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author FLIGHT
 */
public class FileParser {

  private static final String COMMA_DELIMITER = ",";


  public static List<Player> readPlayers(List<Team> teams, String path) {
    Map<String, Team> teamCache = initTeamCache(teams);
    List<List<String>> records = getRawRecords(path);

    /*
     * you can see what headers there are here
     List<String> headers = records.get(0);
     */

    List<Player> players = new ArrayList<>();
    for (int rowIndex = 1; rowIndex < records.size(); ++rowIndex) {
      List<String> row = records.get(rowIndex);

      boolean isActive = Boolean.parseBoolean(row.get(PlayerHeader.IS_ACTIVE.getIndex()));
      boolean hasTeam = teamCache.containsKey(row.get(PlayerHeader.TEAM.getIndex()));

      if (isActive && hasTeam) {
        Player player = new Player.Builder()
          .withFullName(row.get(PlayerHeader.FULL_NAME.getIndex()))
          .withAge(toAge(row.get(PlayerHeader.AGE.getIndex())))
          .withPositions(row.get(PlayerHeader.POSITION.getIndex()))
          .withOverallRating(Integer.parseInt(row.get(PlayerHeader.OVERALL.getIndex())))
          .withTeam(teamCache.get(row.get(PlayerHeader.TEAM.getIndex())))
          .build();

        players.add(player);
      }
    }

    return players;
  }


  public static List<Team> readTeams(String path) {
    List<List<String>> records = getRawRecords(path);

    /*
     * you can see what headers there are here
     List<String> headers = records.get(0);
     */

    List<Team> teams = new ArrayList<>();
    for (int rowIndex = 1; rowIndex < records.size(); ++rowIndex) {
      List<String> row = records.get(rowIndex);
      Team team = new Team.Builder()
        .withFullName(row.get(TeamHeader.FULL_NAME.getIndex()))
        .build();

      teams.add(team);
    }

    return teams;
  }

  private static List<List<String>> getRawRecords(String path) {
    List<List<String>> records = new ArrayList<>();
    try (Scanner scanner = new Scanner(new File(path))) {
      while (scanner.hasNextLine()) {
        records.add(getRecordFromLine(scanner.nextLine()));
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    return records;
  }

  private static List<String> getRecordFromLine(String line) {
    List<String> values = new ArrayList<>();
    try (Scanner rowScanner = new Scanner(line)) {
      rowScanner.useDelimiter(COMMA_DELIMITER);
      while (rowScanner.hasNext()) {
        values.add(rowScanner.next());
      }
    }
    return values;
  }

  private static int toAge(String ageString) {
    return Integer.parseInt(ageString.substring(0, ageString.length() - 1));
  }

  private static Map<String, Team> initTeamCache(List<Team> teams) {
    Map<String, Team> cache = new HashMap<>();
    for (Team team : teams) {
      cache.put(team.fullName(), team);
    }
    return cache;
  }
}
