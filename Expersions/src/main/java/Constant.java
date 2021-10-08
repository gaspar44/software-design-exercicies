public class Constant implements Expression{
  private double value;

  public Constant(double value) {
    this.value = value;
  }
  @Override
  public DualNumber evaluate(DualNumber dualNumber) {
    return new DualNumber(value,0.0);
  }
}
