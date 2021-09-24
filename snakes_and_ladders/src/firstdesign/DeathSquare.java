package firstdesign;

public class DeathSquare extends Square {

  public DeathSquare(int pos, Game g) {
    super(pos, g);
  }

  @Override
  public boolean isDeath() {
    return true;
  }
}
