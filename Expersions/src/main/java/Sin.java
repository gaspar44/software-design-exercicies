public class Sin implements Expression{
  private Expression expr;

  public Sin(Expression expr) {
    this.expr = expr;
  }

  @Override
  public DualNumber evaluate(DualNumber dualNumber) {
    return null;
  }
}
