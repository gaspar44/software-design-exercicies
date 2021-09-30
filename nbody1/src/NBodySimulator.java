public class NBodySimulator {

  private static Universe universe;
  // client to simulate a universe
  // In IntelliJ : Run -> Run... -> Edit configurations -> Program arguments 1000 data/3body.txt

  public static void main(String[] args) {
    if (args.length < 2 || args.length > 4 ) {
      System.out.println("Not Enough arguments");
      System.out.println("supported args: \n" +
          "dt(distantce)\n" +
          "filename\n" +
          "enable_movement(Default:false or true)\n" +
          "time(Default: 0");
      return;
    }

    System.out.println(args.length);
    double distance = Double.parseDouble(args[0]);
    System.out.println("dt=" + distance);
    String fname = args[1];

    boolean showPlanetaryTrace = Boolean.parseBoolean(args[2]);
    int pause = (args.length == 4) ? Integer.parseInt(args[3]) : 0;

    universe = new Universe(fname);
    startSimulation(distance, universe,showPlanetaryTrace, pause);
  }

  private static void startSimulation(double distance, Universe universe,boolean showPlanetaryTrace,int pause) {
    StdDraw.enableDoubleBuffering();

    while (true) {
      if (!showPlanetaryTrace) {
        StdDraw.clear();
      }

      universe.increaseTimeByTraveledDistance(distance);
      drawUniverse();
      StdDraw.show();
      StdDraw.pause(pause);
    }
  }

  private static void drawUniverse() {
      Body[] bodiesToDraw = universe.getBodies();
      int n = universe.getNumberOfBodies();
      for (int i = 0; i < n; i++){
        drawBody(bodiesToDraw[i].getPosition());
      }
  }

  // this method is only needed if you want to change the size of the bodies
  private static void drawBody(Vector r, double penRadius) {
    double pendentRadius = penRadius == 0 ? 0.025 : penRadius;
    StdDraw.setPenRadius(pendentRadius);
    StdDraw.point(r.cartesian(0), r.cartesian(1));
  }

  private static void drawBody(Vector r) {
    drawBody(r,0);
  }
}
