package firstdesign;

public class LadderOrSnake extends Square {
  private int transportation;

  public LadderOrSnake(int pos, Game g,int trans) {
    super(pos, g);
    transportation = trans;
  }
}
