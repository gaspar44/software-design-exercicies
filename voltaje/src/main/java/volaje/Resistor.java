package volaje;

public class Resistor {
  private double resistance;
  private Series series;

  public Resistor(double resistance, Series series) {
    this.resistance = resistance;
    this.series = series;
  }

  public double getResistance() {
    return resistance;
  }

  public Series getSeries() {
    return series;
  }
  @Override
  public String toString() {
    return "Resistance " + resistance + " , series " + series.getName() + ", precision " + series.getPrecision();
  }

}
