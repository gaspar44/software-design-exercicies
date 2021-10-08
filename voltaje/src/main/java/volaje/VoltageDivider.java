package volaje;

public class VoltageDivider {
  private Resistor resistor1;

  public Resistor getResistor1() {
    return resistor1;
  }

  public Resistor getResistor2() {
    return resistor2;
  }

  public double getCoincidence() {
    return coincidence;
  }

  private Resistor resistor2;
  private double coincidence;


  public VoltageDivider(Resistor r1, Resistor r2, double coincidence) {
    resistor1 = r1;
    resistor2 = r2;
    this.coincidence = coincidence;
  }
  @Override
  public String toString() {
    return resistor1 + ", " + resistor2 + "\nvoltage division "
        + resistor2.getResistance() / (resistor1.getResistance()
        + resistor2.getResistance())
        + "\ncoincidence " + coincidence + "\n";
  }
}
