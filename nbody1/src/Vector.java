/******************************************************************************
 *  Compilation:  javac Vector.java
 *  Execution:    java Vector
 *
 *  Implementation of a vector of real numbers.
 *
 *  This class is implemented to be immutable: once the client program
 *  initialize a Vector, it cannot change any of its fields
 *  (N or data[i]) either directly or indirectly. Immutability is a
 *  very desirable feature of a data type.
 *
 *
 *  % java Vector
 *  x        =  (1.0, 2.0, 3.0, 4.0)
 *  y        =  (5.0, 2.0, 4.0, 1.0)
 *  x + y    =  (6.0, 4.0, 7.0, 5.0)
 *  10x      =  (10.0, 20.0, 30.0, 40.0)
 *  |x|      =  5.477225575051661
 *  <x, y>   =  25.0
 *  |x - y|  =  5.0990195135927845
 *
 *  Note that java.util.Vector is an unrelated Java library class.
 *
 ******************************************************************************/

public class Vector { 

    private final int numberOfElements;         // length of the vector
    private double[] data;       // array of vector's components

    // create the zero vector of length n
    public Vector(int n) {
        this.numberOfElements = n;
        this.data = new double[n];
    }

    // create a vector from an array
    public Vector(double[] otherVector) {
        numberOfElements = otherVector.length;

        // defensive copy so that client can't alter our copy of otherVector[]
        this.data = new double[numberOfElements];
        for (int i = 0; i < numberOfElements; i++)
            this.data[i] = otherVector[i];
    }

    public int length() {
        return numberOfElements;
    }

    // return the inner product of this Vector a and b
    public double dot(Vector otherVector) {
        if (this.length() != otherVector.length())
            throw new IllegalArgumentException("dimensions disagree");
        double sum = 0.0;
        for (int i = 0; i < numberOfElements; i++)
            sum = sum + (this.data[i] * otherVector.data[i]);
        return sum;
    }

    // return the Euclidean norm of this Vector
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    public double euclideanDistanceTo(Vector otherVector) {
        if (this.length() != otherVector.length())
            throw new IllegalArgumentException("dimensions disagree");
        return this.minus(otherVector).magnitude();
    }

    // return this + that
    public Vector plus(Vector vectorToAdd) {
        if (this.length() != vectorToAdd.length())
            throw new IllegalArgumentException("dimensions disagree");
        Vector c = new Vector(numberOfElements);
        for (int i = 0; i < numberOfElements; i++)
            c.data[i] = this.data[i] + vectorToAdd.data[i];
        return c;
    }

    // return this - that
    public Vector minus(Vector vectorToSubstract) {
        if (this.length() != vectorToSubstract.length())
            throw new IllegalArgumentException("dimensions disagree");
        Vector c = new Vector(numberOfElements);
        for (int i = 0; i < numberOfElements; i++)
            c.data[i] = this.data[i] - vectorToSubstract.data[i];
        return c;
    }

    // return the corresponding coordinate
    public double cartesian(int i) {
        return data[i];
    }

    // create and return a new object whose value is (this * factor)
    @Deprecated
    public Vector times(double factor) {
        Vector c = new Vector(numberOfElements);
        for (int i = 0; i < numberOfElements; i++)
            c.data[i] = factor * data[i];
        return c;
    }

    // create and return a new object whose value is (this * factor)
    public Vector scale(double factor) {
        Vector c = new Vector(numberOfElements);
        for (int i = 0; i < numberOfElements; i++)
            c.data[i] = factor * data[i];
        return c;
    }


    // return the corresponding unit vector
    public Vector direction() {
        if (this.magnitude() == 0.0)
            throw new ArithmeticException("zero-vector has no direction");
        return this.scale(1.0 / this.magnitude());
    }

    // return a string representation of the vector
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append('(');
        for (int i = 0; i < numberOfElements; i++) {
            s.append(data[i]);
            if (i < numberOfElements -1) s.append(", ");
        }
        s.append(')');
        return s.toString();
    }

}
