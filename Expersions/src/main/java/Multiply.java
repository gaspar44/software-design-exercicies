public class Multiply extends  BinaryOperator{

  public Multiply(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public DualNumber evaluate(DualNumber dualNumber) {
    DualNumber dn1 = left.evaluate(dualNumber);
    DualNumber dn2 = right.evaluate(dualNumber);
    return new DualNumber(dn1.u*dn2.u, dn1.uprime*dn2.u + dn1.u*dn2.uprime);
  }
}
