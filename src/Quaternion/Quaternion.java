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

    public Quaternion() {
        this.a = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;

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

    public Quaternion multiply(Quaternion b) {
        return new Quaternion(a * b.a - x * b.x - y * b.y - z * b.z, a * b.x + x * b.a + y * b.z - z * b.y,
                a * b.y - x * b.z + y * b.a + z * b.x, a * b.z + x * b.y - y * b.x + z * b.a);
    }

    public Quaternion plus(Quaternion b) { return new Quaternion(a + b.a, x + b.x, y + b.y, z + b.z); }

    public Quaternion minus(Quaternion b) { return new Quaternion(a - b.a, x - b.x, y - b.y, z - b.z); }

    public double abs() { return Math.sqrt(a * a + x * x + y * y + z * z); }

    public Quaternion divideOnNumber(double n) {
        if (n != 0) return new Quaternion(a / n, x / n, y / n, z / n);
        else throw new ArithmeticException("division by zero");
    }

    public Quaternion inverse() { return this.conjugation().divideOnNumber(this.abs() * this.abs()); }

    public Quaternion rational() { return this.divideOnNumber(this.abs()); }

    public Quaternion divide(Quaternion o) { return this.multiply(o.inverse()); }

    public double getScalarPart() { return a; }

    public QuaternionVector getVectorPart() { return new QuaternionVector(x, y, z); }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object != null && object instanceof Quaternion) {
            Quaternion other = (Quaternion) object;
            return a == other.a && x == other.x && y == other.y && z == other.z;
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

