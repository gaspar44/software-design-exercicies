public class Main {
  private static double f(double x) {
    return Math.sin(Math.PI/2.0 + x*x);
  }
  private static double df(double x) {
    return Math.cos(Math.PI/2.0 + x*x)*2*x;
  }

  private static double dfLog(double x) {
    return 4*x / ((2*x*x) + Math.PI );
  }

  public static void main(String[] args) {
    double x0 = 4.0;
    double valorReal = f(x0);
    double derivadaReal = df(x0);

    Expression x = new X();
    Expression commonExpression = new Add(new Constant(Math.PI / 2.0), new Multiply(x, x));
    Expression expr = new Sin(commonExpression);
    DualNumber res = expr.evaluate(new DualNumber(x0, 1.0));
    System.out.println("running sen expresion");
    runSimulation(x0,valorReal,derivadaReal,res);
    valorReal = Math.log(x0);
    derivadaReal = dfLog(x0);
    expr = new Log(commonExpression) ;
    res = expr.evaluate(new DualNumber(x0,1.0));
    System.out.println("running log expresion");
    runSimulation(x0,valorReal,derivadaReal,res);



  }

  public static void runSimulation(double x0,double valorReal, double derivadaReal, DualNumber res) {
    System.out.println("real");
    System.out.println("f(" + x0 +") = "+valorReal);
    System.out.println("f'(" + x0 + ") = "+derivadaReal);
    System.out.println("calculat");
    System.out.println("f(" + x0 + ") = "+res.u);
    System.out.println("f'(" + x0 + ") = "+res.uprime);
    System.out.println("diferencia valor "
        + (valorReal - res.u));
    System.out.println("diferencia derivada "
        + (derivadaReal - res.uprime));

    System.out.println("derivada per diferencies finites");
    final double[] epsilons = {1e-6, 1e-8, 1e-10, 1e-12};
    for (int i=0; i<epsilons.length; i++) {
      double derivadaDifFinites = (f(x0 + epsilons[i]) - f(x0)) / epsilons[i];
      System.out.println("per epsilon " + epsilons[i]
          + ", " + derivadaDifFinites + ", "
          + "diferencia "
          + (derivadaReal - derivadaDifFinites));
    }
  }
}
