package database.entity;

/**
 * @author FLIGHT
 */
public record Player(String fullName, Team team, int age, int overallRating, String positions) {

  public static class Builder {

    private String fullName;

    private Team team;

    private int age;

    private int overallRating;

    private String positions;


    public Builder() {
    }

    public Player build() {
      return new Player(
        fullName,
        team,
        age,
        overallRating,
        positions
      );
    }

    public Builder withFullName(String fullName) {
      this.fullName = fullName;
      return this;
    }

    public Builder withTeam(Team team) {
      this.team = team;
      return this;
    }

    public Builder withAge(int age) {
      this.age = age;
      return this;
    }

    public Builder withOverallRating(int overallRating) {
      this.overallRating = overallRating;
      return this;
    }

    public Builder withPositions(String positions) {
      this.positions = positions;
      return this;
    }
  }
}
