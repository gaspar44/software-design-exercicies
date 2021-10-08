public class Log implements  Expression{
  private Expression expression;

  public Log(Expression expression) {
    this.expression = expression;
  }

  @Override
  public DualNumber evaluate(DualNumber dualNumber) {
    DualNumber dn = expression.evaluate(dualNumber);
    double log = Math.log(dn.u);
    return new DualNumber(log, dn.uprime/dn.u);
  }
}
