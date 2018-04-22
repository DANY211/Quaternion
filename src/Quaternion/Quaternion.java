package Quaternion;

import Vector.QuaternionVector;

import java.util.Objects;

public class Quaternion {
    private final double x;
    private final double y;
    private final double z;
    private final double a;

    public Quaternion(double a, double x, double y, double z) {
        this.a = a;
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public Quaternion(double a, QuaternionVector v) {
        this.a = a;
        this.x = v.getX();
        this.y = v.getY();
        this.z = v.getZ();
    }

    public Quaternion conjugation() {
        return new Quaternion(a, -x, -y, -z);
    }

    public Quaternion multiplyNum(double n) {
        return new Quaternion(a * n, x * n, y * n, z * n);
    }

    /**
     * @param other quaternion to multiplication
     * @return quaternion of two multiplied quaternions
     */
    public Quaternion multiply(Quaternion other) {
        return new Quaternion(a * other.a - x * other.x - y * other.y - z * other.z,
                a * other.x + x * other.a + y * other.z - z * other.y,
                a * other.y - x * other.z + y * other.a + z * other.x,
                a * other.z + x * other.y - y * other.x + z * other.a);
    }

    public Quaternion plus(Quaternion b) { return new Quaternion(a + b.a, x + b.x, y + b.y, z + b.z); }

    public Quaternion minus(Quaternion b) { return new Quaternion(a - b.a, x - b.x, y - b.y, z - b.z); }

    public double abs() { return Math.sqrt(a * a + x * x + y * y + z * z); }

    public double norm() { return  (a * a + x * x + y * y + z * z); }

    public Quaternion divideOnNumber(double n) {
        if (n != 0) return new Quaternion(a / n, x / n, y / n, z / n);
        else throw new ArithmeticException("division by zero");
    }

    public Quaternion inverse() {return conjugation().divideOnNumber(Math.pow(abs(), 2d));}

    public Quaternion rational() { return this.divideOnNumber(this.abs()); }

    public Quaternion divide(Quaternion o) { return this.multiply(o.inverse()); }

    public double getScalarPart() { return a; }

    public QuaternionVector getVectorPart() { return new QuaternionVector(x, y, z); }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object != null && object instanceof Quaternion) {
            Quaternion o = (Quaternion) object;
            return a == o.a && x == o.x && y == o.y && z == o.z;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, x, y, z);
    }

    @Override
    public String toString() {
        return "" + a + ((x >= 0) ? "+" : "") + x + "m" + ((y >= 0) ? "+" : "") + y + "n" + ((z >= 0) ? "+" : "") + z + "p";
    }
}

