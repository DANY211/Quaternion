package QuaternionUtilites;

import Quaternion.Quaternion;
import Vector.QuaternionVector;

public final class QuaternionUtilites {
    public static Quaternion getQuaternion(double w, QuaternionVector v) {
        return getQuaternion(w, v.getX(), v.getY(), v.getZ());
    }

    public static Quaternion getQuaternion(double a, double x, double y, double z) {
        return new Quaternion(Math.cos(a / 2), Math.sin(a / 2) * x, Math.sin(a / 2) * y, Math.sin(a / 2) * z);
    }

    public static Quaternion getQuaternion() { return new Quaternion(); }

    public static QuaternionVector getAxis(Quaternion a) { return a.getVectorPart(); }

    public static double getAngle(Quaternion a) { return a.getScalarPart(); }
}