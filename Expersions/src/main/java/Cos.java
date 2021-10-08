public class Cos implements Expression{
  private Expression expr;

  public Cos(Expression expr) {
    this.expr = expr;
  }

  @Override
  public DualNumber evaluate(DualNumber dualNumber) {
    DualNumber dn1 = expr.evaluate(dualNumber);
    double cos = Math.cos(dn1.u);
    double sin = Math.sin(dn1.u);

    return new DualNumber(cos, dn1.uprime * sin * -1);
  }
}