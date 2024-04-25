package database.enums;

/**
 * @author FLIGHT
 */
public enum PlayerHeader {
  FULL_NAME(4),
  IS_ACTIVE(5),
  OVERALL(7),
  TEAM(44),
  AGE(48),
  POSITION(53);


  private final int index;

  PlayerHeader(int index) {
    this.index = index;
  }

  public int getIndex() {
    return index;
  }
}
