public class NBodySimulator {


  // client to simulate a universe
  // In IntelliJ : Run -> Run... -> Edit configurations -> Program arguments 1000 data/3body.txt
  public static void main(String[] args) {
    double distance = Double.parseDouble(args[0]);
    System.out.println("dt=" + distance);
    String fname = args[1];

    Universe newton;
    newton = new Universe(fname);
    startSimulation(distance, newton);
  }

  private static void startSimulation(double distance, Universe universe) {
    StdDraw.enableDoubleBuffering();
    int pause = 0;
    while (true) {
      StdDraw.clear();
      universe.increaseTime(distance);
      universe.draw();
      StdDraw.show();
      StdDraw.pause(pause);
    }
  }

}
