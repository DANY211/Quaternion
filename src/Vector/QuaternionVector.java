package Vector;

import java.util.Objects;

public class QuaternionVector {
    private final double x;
    private final double y;
    private final double z;

    public QuaternionVector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    private double length(){
        return Math.sqrt(x * x + y * y + z * z);
    }

    public QuaternionVector normalize(){
        double length = length();
        return new QuaternionVector(x/length, y/length, z/length);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object != null && object instanceof Vector.QuaternionVector) {
            Vector.QuaternionVector other = (Vector.QuaternionVector) object;
            return x == other.x && y == other.y && z == other.z;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() { return "" + x + "m" + ((y >= 0) ? "+" : "") + y + "n" + ((z >= 0) ? "+" : "") + z + "p";
    }
}
