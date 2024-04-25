package database.enums;

/**
 * @author FLIGHT
 */
public enum TeamHeader {

  FULL_NAME(5);

  private final int index;

  TeamHeader(int index) {
    this.index = index;
  }

  public int getIndex() {
    return index;
  }
}
