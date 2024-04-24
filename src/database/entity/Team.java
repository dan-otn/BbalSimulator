package database.entity;

/**
 * @author FLIGHT
 */
public record Team(String fullName) {

  public static class Builder {

    private String fullName;

    public Team build() {
      return new Team(fullName);
    }

    public Builder withFullName(String fullName) {
      this.fullName = fullName;
      return this;
    }
  }

  @Override
  public String toString() {
    return fullName;
  }
}
