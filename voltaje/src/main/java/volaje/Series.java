package volaje;

import java.util.ArrayList;
import java.util.List;

public class Series {
  private List<Resistor> resistors = new ArrayList<Resistor>();
  private String name;
  private double precision;
  private double[] normalizedValues;
  private static final double[] POWER_FACTORS = {1.,10.,100.,1000.,1.0e+04,1.0e+05,1.0e+06};

  public Series(String name, double[] normalizedValues, double precision) {
    this.name = name;
    this.normalizedValues = normalizedValues;
    this.precision = precision;
    makeResistors();
  }

  private void makeResistors() {
    for (double powerFactor: POWER_FACTORS  ) {
      Resistor resitor = new Resistor(powerFactor,this);
      resistors.add(resitor);
    }
  }

  public double getPrecision() {
    return this.precision;
  }

  public String getName() {
    return this.name;
  }

  public List getResistors() {
    return this.resistors;
  }

  @Override
  public String toString() {
    String res = "Series " + name + "\nNormalizedValues ";

    for (int i = 0; i < normalizedValues.length; i++){
      res += normalizedValues[i] + " , ";
    }
    return res + "\nPrecision " + precision;
  }
}
