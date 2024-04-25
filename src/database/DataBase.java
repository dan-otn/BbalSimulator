package database;

import database.entity.Player;
import database.entity.Team;

/**
 * @author FLIGHT
 */
public interface DataBase {

  Player teamBestPlayer(Team team);

  Team selectRandomTeam();
}
