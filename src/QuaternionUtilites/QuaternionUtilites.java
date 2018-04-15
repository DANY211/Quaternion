package QuaternionUtilites;

import Quaternion.Quaternion;
import Vector.QuaternionVector;

public final class QuaternionUtilites {

    public static Quaternion getQuaternion(double w, QuaternionVector v) {
        QuaternionVector unitV = v.normalize();
        double a = Math.cos(w / 2);
        double x = unitV.getX() * Math.sin(w / 2);
        double y = unitV.getY() * Math.sin(w / 2);
        double z = unitV.getZ() * Math.sin(w / 2);
        return new Quaternion(a, x, y, z);
    }

    public static QuaternionVector getAxis(Quaternion a) {
        return a.getVectorPart();
    }

    public static double getAngle(Quaternion a) {
        return a.getScalarPart();
    }

}