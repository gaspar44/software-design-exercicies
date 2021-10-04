package volaje;

import java.util.ArrayList;
import java.util.List;

public class VoltageDividerCalculation {
  public static List<VoltageDivider> calculate(double voltageDivision, double coincidence, Series s) {
   List <VoltageDivider> result = new ArrayList<>();
   List<Resistor> resistors = s.getResistors();
   double porcentaje = coincidence / 100;
   double topIntervalValue = voltageDivision + (porcentaje * voltageDivision);
   double lowerIntervalValue = voltageDivision - (porcentaje * voltageDivision);
    for (Resistor r1 : resistors) {
      for (Resistor r2 : resistors) {
        double r1r2Coincidence = r2.getResistance() / ( r1.getResistance() + r2.getResistance());
        if ( lowerIntervalValue < r1r2Coincidence && r1r2Coincidence < topIntervalValue) {
          VoltageDivider vd = new VoltageDivider(r1, r2, r1r2Coincidence);
          result.add(vd);
        }
      }
    }
    return result;
  }
}
