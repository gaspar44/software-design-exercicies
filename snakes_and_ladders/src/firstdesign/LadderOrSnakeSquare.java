package firstdesign;

public class LadderOrSnakeSquare extends Square {
  private int transportation;

  public LadderOrSnakeSquare(int pos, Game g, int trans) {
    super(pos, g);
    transportation = trans;
  }
}
