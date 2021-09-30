import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/******************************************************************************
 *  Compilation:  javac Universe.java
 *  Execution:    java Universe dt input.txt
 *  Dependencies: Body.java Vector.java StdIn.java StdDraw.java
 *  Datafiles:    http://www.cs.princeton.edu/introcs/34nbody/2body.txt
 *                http://www.cs.princeton.edu/introcs/34nbody/3body.txt
 *                http://www.cs.princeton.edu/introcs/34nbody/4body.txt
 *                http://www.cs.princeton.edu/introcs/34nbody/2bodyTiny.txt
 *
 *  This data-driven program simulates motion in the universe defined
 *  by the standard input stream, increasing time at the rate on the
 *  command line.
 *
 *  %  java Universe 25000 4body.txt
 *
 *
 ******************************************************************************/

public class Universe {
    private  int numberOfBodies;             // number of bodies
    private  Body[] bodies;     // array of n bodies

    public int getNumberOfBodies() {
        return numberOfBodies;
    }

    public Body[] getBodies() {
        return bodies;
    }

    // read universe from standard input
    public Universe(String fname) {
        try {
            Scanner in = new Scanner(new FileReader(fname));
            numberOfBodies = Integer.parseInt(in.next());
            // number of bodies
            System.out.println("n=" + numberOfBodies);

            // the set scale for drawing on screen
            double radius = Double.parseDouble(in.next());
            System.out.println("radius=" + radius);
            StdDraw.setXscale(-radius, +radius);
            StdDraw.setYscale(-radius, +radius);

            // read in the n bodies
            bodies = new Body[numberOfBodies];
            initCelestialBodies(in);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initCelestialBodies(Scanner in) {
        for (int i = 0; i < numberOfBodies; i++) {
            double rx = Double.parseDouble(in.next());
            double ry = Double.parseDouble(in.next());
            double vx = Double.parseDouble(in.next());
            double vy = Double.parseDouble(in.next());
            double mass = Double.parseDouble(in.next());
            double[] position = {rx, ry};
            double[] velocity = {vx, vy};
            Vector r = new Vector(position);
            Vector v = new Vector(velocity);
            bodies[i] = new Body(r, v, mass);
        }
    }

    // increment time by dt units, assume forces are constant in given interval
    public void increaseTimeByTraveledDistance(double distance) {

        // initialize the forces to zero
        Vector[] f = new Vector[numberOfBodies];
        for (int i = 0; i < numberOfBodies; i++) {
            f[i] = new Vector(new double[2]);
        }

        // compute the forces
        for (int i = 0; i < numberOfBodies; i++) {
            for (int j = 0; j < numberOfBodies; j++) {
                if (i != j) {
                    f[i] = f[i].plus(bodies[i].forceFrom(bodies[j]));
                }
            }
        }

        // move the bodies
        for (int i = 0; i < numberOfBodies; i++) {
            bodies[i].move(f[i], distance);
        }
    }
}
