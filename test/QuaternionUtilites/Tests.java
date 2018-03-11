package QuaternionUtilites;

import org.junit.Test;
import Vector.QuaternionVector;
import Quaternion.Quaternion;

import static org.junit.Assert.assertEquals;

public class Tests {
    @Test
    public void getQuaternion() {
        assertEquals(new Quaternion(1, 0, 0, 0), QuaternionUtilites.getQuaternion(0, 2, 3, 4));
        final Quaternion exp = new Quaternion(0, 7.5, -23, 18);
        final Quaternion res = QuaternionUtilites.getQuaternion(Math.PI, new QuaternionVector(7.5, -23, 18));
        assertEquals(exp.getScalarPart(), res.getScalarPart(), 1e-6);
        assertEquals(exp.getVectorPart().getX(), res.getVectorPart().getX(), 1e-6);
        assertEquals(exp.getVectorPart().getY(), res.getVectorPart().getY(), 1e-6);
        assertEquals(exp.getVectorPart().getZ(), res.getVectorPart().getZ(), 1e-6);
        assertEquals(new Quaternion(), QuaternionUtilites.getQuaternion());
    }

    @Test
    public void getAxis() {
        assertEquals(new Quaternion(1, 2, 3, 4).getVectorPart(), QuaternionUtilites.getAxis(new Quaternion(1, 2, 3, 4)));
    }

    @Test
    public void getAngle() {
        assertEquals(new Quaternion(1, 2, 3, 4).getScalarPart(), QuaternionUtilites.getAngle(new Quaternion(1, 2, 3, 4)), 1e-10);
    }
}