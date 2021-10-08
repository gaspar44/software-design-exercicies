public class X implements Expression{

  @Override
  public DualNumber evaluate(DualNumber dualNumber) {
    return new DualNumber(dualNumber.u,1.0);
  }
}
