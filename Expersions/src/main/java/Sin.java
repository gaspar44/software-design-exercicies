public class Sin implements Expression{
  private Expression expr;

  public Sin(Expression expr) {
    this.expr = expr;
  }

  @Override
  public DualNumber evaluate(DualNumber dualNumber) {
    DualNumber dn1 = expr.evaluate(dualNumber);
    double senoDerivate = Math.sin(dn1.u);
    double cos = Math.cos(dn1.u);

    return new DualNumber(senoDerivate, dn1.uprime * cos);
  }
}
