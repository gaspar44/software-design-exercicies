package volaje;

import java.util.ArrayList;
import java.util.List;

public class VoltageDividerCalculation {
  private static Object Resistor;
  private List<VoltageDivider> voltageDividers = new ArrayList<>();
  public static List<VoltageDivider> calculate(double voltageDivision, double coincidence, Series s) {
   List <VoltageDivider> result = new ArrayList<>();
   List<Resistor> resistors = s.getResistors();;
// non-optimized version at the moment and output to console
    for (Resistor r1 : resistors) {
      for (Resistor r2 : resistors) {
        if ( r1.getResistance() > r2.getResistance()) {
          double r1r2Coincidence = 0;
          VoltageDivider vd = new VoltageDivider(r1, r2, r1r2Coincidence);
          result.add(vd);
        }
      }
    }
    return result;
  }
}
