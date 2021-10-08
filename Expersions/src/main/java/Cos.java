public class Cos implements Expression{
  private Expression expr;

  public Cos(Expression expr) {
    this.expr = expr;
  }

  @Override
  public DualNumber evaluate(DualNumber dualNumber) {
    return null;
  }
}